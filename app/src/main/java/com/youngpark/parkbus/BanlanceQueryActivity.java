package com.youngpark.parkbus;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.extendsoft.nfcpayapp.model.CardRecord;
import com.extendsoft.nfcpayapp.model.UnionCitySDCard;
import com.extendsoft.nfcpayapp.nfc.UnionCitySDCardHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BanlanceQueryActivity extends AppCompatActivity {

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private TextView tv_balance;
    private TextView tv_cardNum;
    private TextView tv_city;
    private TextView tv_type;

    private TextView recordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banlance_query);

        tv_cardNum = findViewById(R.id.tv_cardNum);
        tv_balance = findViewById(R.id.tv_balance);
        tv_city = findViewById(R.id.tv_city);
        tv_type = findViewById(R.id.tv_type);

        recordTextView = findViewById(R.id.recordTextView);

        tv_type.setText("test");

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0, (new Intent(this, getClass())).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        onNewIntent(getIntent());
        Toast.makeText(this, "请刷卡查询余额", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag != null) {
                IsoDep isoDep = IsoDep.get(tag);
                if (isoDep != null) {
                    UnionCitySDCard unionCitySDCard = (new UnionCitySDCardHelper(isoDep)).readAll();

                    if (unionCitySDCard != null && unionCitySDCard.getCardType() != null && !unionCitySDCard.getCardType().isEmpty()) {
                        unionCitySDCard.setCity("淄博");
                        showInfo(unionCitySDCard);
                    } else {
                        clearInfo();
                        Toast.makeText(BanlanceQueryActivity.this, "读卡失败，请确认卡片类型", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
            clearInfo();
            Toast.makeText(BanlanceQueryActivity.this, "读卡失败，请确认卡片类型", Toast.LENGTH_SHORT).show();
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

    private void showInfo(UnionCitySDCard var1) {
        if (var1 != null) {
            tv_type.setText(var1.getCardType());
            tv_city.setText(var1.getCity());
            tv_cardNum.setText(var1.getCardNumber());
            tv_balance.setText(var1.getCardBalance());
            ArrayList<CardRecord> recordList = var1.getCardRecords();

            StringBuilder stringBuilder = new StringBuilder();
            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            for (CardRecord cardRecord : recordList) {
                stringBuilder
                        .append("编号:").append(cardRecord.getNumber()).append("\t  ")
                        .append("时间:").append(dateFormat.format(cardRecord.getExchangeHour())).append("\n")
                        .append("交易编号:").append(cardRecord.getShopNumber()).append("\t  ")
                        .append("金额:").append(cardRecord.getSign())
                        .append(cardRecord.getMoney()).append("\n\n");
            }
            recordTextView.setText(stringBuilder.toString());
        }
    }

    private void clearInfo(){
        tv_type.setText("");
        tv_city.setText("");
        tv_cardNum.setText("");
        tv_balance.setText("");
        recordTextView.setText("");
    }

}
