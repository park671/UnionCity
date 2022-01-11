package com.youngpark.parkbus;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.extendsoft.nfcpayapp.model.UnionCitySDCard;
import com.extendsoft.nfcpayapp.nfc.UnionCitySDCardHelper;
import com.extendsoft.nfcpayapp.util.ByteUtil;
import com.youngpark.util.TlvUtil;

public class DebitCardActivity extends AppCompatActivity {

    private TextView contentTextView;

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;

    private Button infoButton, personButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0, (new Intent(this, getClass())).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        onNewIntent(getIntent());

        findViews();
        setListeners();
    }

    private void findViews() {
        contentTextView = findViewById(R.id.contentTextView);

        infoButton = findViewById(R.id.infoButton);
        personButton = findViewById(R.id.personButton);
    }

    private void setListeners() {
        infoButton.setOnClickListener(clickListener);
        personButton.setOnClickListener(clickListener);
    }

    private int operation = -1;

    public static final int INFO = 1, PERSON = 2;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.infoButton:
                    operation = INFO;
                    break;
                case R.id.personButton:
                    operation = PERSON;
                    break;
            }
        }
    };

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag != null) {
                IsoDep isoDep = IsoDep.get(tag);
                isoDep.connect();
                isoDep.transceive(ByteUtil.hex2bytes("00A4040008A000000333010101"));

                byte[] receiveData = null;

                switch (operation) {
                    case INFO:
                        receiveData = isoDep.transceive(ByteUtil.hex2bytes("00B2011400"));
                        break;
                    case PERSON:
                        receiveData = isoDep.transceive(ByteUtil.hex2bytes("00B2020C00"));
                        break;
                    default:
                }


                isoDep.close();

                TlvUtil tlvUtil = new TlvUtil();
                tlvUtil.pbocTlvAns(receiveData, receiveData.length);

                String resultString = tlvUtil.getString(tlvUtil.tags);

                contentTextView.setText(resultString);
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
            Toast.makeText(DebitCardActivity.this, "银行卡读卡失败，请确认卡片类型", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, UnionCitySDCardHelper.FILTERS, UnionCitySDCardHelper.TECH_LISTS);
        }

    }

}
