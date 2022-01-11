package com.youngpark.parkbus;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.extendsoft.nfcpayapp.model.TipBundle;
import com.extendsoft.nfcpayapp.model.UnionCitySDCard;
import com.extendsoft.nfcpayapp.nfc.UnionCitySDCardHelper;
import com.extendsoft.nfcpayapp.util.SharedPreferencesKeeper;
import com.extendsoft.nfcpayapp.util.UIHelper;


public class ChargeActivity extends AppCompatActivity {


    private String moneyStr;
    private String msg;
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private String serverMode = "00";
    private TipBundle tipBundle;
    private String tn;

    private TextView tv_recharge_balance;
    private TextView tv_recharge_cardNo;

    private Button bt_recharge_now;

    private EditText et_selfrecharge_money;

    private boolean flag0;
    private LinearLayout ll_selfrecharge_money;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                default:
                    return;
                case 1:
                    Toast.makeText(ChargeActivity.this, "1 was catched", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText( ChargeActivity.this, "获取交易流水号失败", Toast.LENGTH_SHORT).show();
                    ChargeActivity.this.bt_recharge_now.setEnabled(true);
                    return;
                case 3:
                    Toast.makeText( ChargeActivity.this, "个人充值登帐失败", Toast.LENGTH_SHORT).show();
                    ChargeActivity.this.bt_recharge_now.setEnabled(true);
                    return;
                case 4:
                    break;
            }
            int i = message.getData().getInt("rechargeSum");
            String str = message.getData().getString("transactionSerialNo");
//            ChargeActivity.this.tipBundle.setActivityName(SelfRechargeSuccessActivity.class.getName());
            ChargeActivity.this.tipBundle.setMoney(i);
            ChargeActivity.this.tipBundle.setTransactionSerialNo(str);
            ChargeActivity.this.tipBundle.setMessage(String.valueOf(i / 100));
            Intent intent = new Intent(ChargeActivity.this, SelfRechargeTipActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(TipBundle.class.getSimpleName(), ChargeActivity.this.tipBundle);
            intent.putExtras(bundle);
            ChargeActivity.this.startActivity(intent);
        }
    };

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);
        findViews();

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0, (new Intent(this, getClass())).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        tipBundle = new TipBundle();
        et_selfrecharge_money.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                String str = param1Editable.toString();
                if (!str.isEmpty()) {
                    UIHelper.clearCheck(ll_selfrecharge_money, null);
                } else {
                    UIHelper.setEnableOfCheckBox(ll_selfrecharge_money, true);
                }
                if (!str.contains(".") && str.length() > 4) {
                    et_selfrecharge_money.setText(str.subSequence(0, 4));
                    et_selfrecharge_money.setSelection(4);
                }
                int i = str.indexOf(".");
                if (i > 0 && str.length() - i - 1 > 2) {
                    et_selfrecharge_money.setText(str.subSequence(0, i + 3));
                    et_selfrecharge_money.setSelection(str.length() - 1);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            }

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            }
        });
        float f = SharedPreferencesKeeper.readRechargefee( this);
        onNewIntent(getIntent());
    }

    private void findViews() {
        tv_recharge_balance = findViewById(R.id.tv_recharge_balance);
        tv_recharge_cardNo = findViewById(R.id.tv_recharge_cardNo);
        bt_recharge_now = findViewById(R.id.bt_recharge_now);
        et_selfrecharge_money = findViewById(R.id.et_selfrecharge_money);
        ll_selfrecharge_money = findViewById(R.id.ll_selfrecharge_money);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        Tag tag = (Tag) paramIntent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag != null) {
            IsoDep isoDep = IsoDep.get(tag);
            if (isoDep != null) {
                UnionCitySDCard unionCitySDCard = (new UnionCitySDCardHelper(isoDep)).readAll();
                tipBundle.setBalance(unionCitySDCard.getCardBalance());
                tv_recharge_cardNo.setText(unionCitySDCard.getCardNumber());
                tv_recharge_balance.setText(unionCitySDCard.getCardBalance());
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        tipBundle.setBalance("");
        tv_recharge_cardNo.setText("");
        tv_recharge_balance.setText("");
        if (nfcAdapter != null)
            nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nfcAdapter != null)
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, UnionCitySDCardHelper.FILTERS, UnionCitySDCardHelper.TECH_LISTS);
    }

    public void rechargeNow(View view) {
        String str;
        int i = 1000;
        int j = 5000;
        int k = 5000;

//                    i = SharedPreferencesKeeper.readUserRechargeLowerLimit( this);
//                    j = SharedPreferencesKeeper.readCardTotalRechargeSum( this);
//                    k = SharedPreferencesKeeper.readUserRechargeUpperLimit( this);
        if (moneyStr == null || moneyStr.isEmpty()) {
            Toast.makeText( this, "请选择或者输入金额", Toast.LENGTH_SHORT).show();
            bt_recharge_now.setEnabled(false);
            return;
        }
        str = tipBundle.getBalance();

        if ((int) (Float.valueOf(moneyStr) * 100.0F) < i) {
            Toast.makeText( this, "充值金额低于充值下限" + (i / 100) + "元，请重新输入", Toast.LENGTH_SHORT).show();
            bt_recharge_now.setEnabled(true);
            return;
        }
        if ((int) (Float.valueOf(moneyStr) * 100.0F) > k) {
            Toast.makeText( this, "每笔充值金额不能高于" + (k / 100) + "元，请重新输入", Toast.LENGTH_SHORT).show();
            bt_recharge_now.setEnabled(true);
            return;
        }
        if (str == null || str.equals("")) {
            Toast.makeText( this, "充值前请先读取卡内余额", Toast.LENGTH_SHORT).show();
            bt_recharge_now.setEnabled(true);
            return;
        }
        if ((int) (Float.valueOf(moneyStr) * 100.0F) + (int) (Float.valueOf(str) * 100.0F) > j) {
            Toast.makeText( this, "卡内金额不能超过" + (j / 100) + "元，请重新输入", Toast.LENGTH_SHORT).show();
            bt_recharge_now.setEnabled(true);
            return;
        }
        (new Thread() {
            @Override
            public void run() {
                try {
//                    SharedPreferencesKeeper.readPhoneNo( ChargeActivity.this);
//                    int i = (int) (SharedPreferencesKeeper.readRechargefee( ChargeActivity.this) * 1.0D / 10000.0D * dealNum);
//                    JSONObject jSONObject = (new ServerHelper()).getUPMPTransactionSerialNoResult(dealNum, i, String.valueOf(dealNum) + i + "37TPTfTOaWchJHuLfPnFHoXTF4XsJP80", "02");
                    boolean success = true;
                    String backMessage = "fake success";
                    String dealId = "67676710";
                    Log.i("ChargeActivity", "获取交易流水号是否成功：" + success + "  获取交易流水号返回信息：" + backMessage + " 获取交易流水号:" + dealId);
                    if (success) {
                        Message message = Message.obtain();
                        message.what = 1;
                        message.getData().putString("transactionSerialNo", dealId);
                        message.getData().putInt("rechargeSum", (int) (Float.valueOf(moneyStr) * 100.0F));
                        handler.sendMessage(message);
                        return;
                    }
                    handler.sendEmptyMessage(2);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    handler.sendEmptyMessage(2);
                }
            }
        }).start();
    }


    public void checkBoxOnClick(View view) {
        UIHelper.clearCheck(this.ll_selfrecharge_money, view);

        bt_recharge_now.setEnabled(true);
        moneyStr = "";
        CheckBox checkBox = UIHelper.getCheckedCheckBox(ll_selfrecharge_money);


        if (checkBox != null) {
            switch (checkBox.getId()) {
                default:

                    break;
                case R.id.value_30_btn:
                    moneyStr = "30";
                    break;
                case R.id.value_50_btn:
                    moneyStr = "50";
                    break;
//                case R.id.value_100_btn:
//                    moneyStr = "80";
//                    break;
//                case R.id.value_100_btn:
//                    moneyStr = "100";
//                    break;
                case R.id.value_200_btn:
                    moneyStr = "150";
                    break;
                case R.id.value_300_btn:
                    moneyStr = "200";
                    break;
            }
        } else if (!et_selfrecharge_money.getText().toString().isEmpty()) {
            moneyStr = et_selfrecharge_money.getText().toString();
        }

        if (view instanceof CheckBox) {
            if (((CheckBox) view).isChecked()) {
                this.et_selfrecharge_money.setText("");
                return;
            }
        } else {
            return;
        }
        this.et_selfrecharge_money.setEnabled(true);
    }

}
