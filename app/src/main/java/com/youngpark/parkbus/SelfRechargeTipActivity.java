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
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.extendsoft.nfcpayapp.model.CardInitShopRechargeResponse;
import com.extendsoft.nfcpayapp.model.CardSelect15hFileResponse;
import com.extendsoft.nfcpayapp.model.SelfRechargeApplyRequestMessage;
import com.extendsoft.nfcpayapp.model.SelfRechargeSubmitRequestMessage;
import com.extendsoft.nfcpayapp.model.ServerRequest;
import com.extendsoft.nfcpayapp.model.TipBundle;
import com.extendsoft.nfcpayapp.nfc.UnionCitySDCardHelper;
import com.extendsoft.nfcpayapp.util.ByteUtil;
import com.extendsoft.nfcpayapp.util.JSONUtils;
import com.extendsoft.nfcpayapp.util.SharedPreferencesKeeper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelfRechargeTipActivity extends AppCompatActivity {

    private TextView back_tv;
    private boolean isPowerDown;
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    //private SocketDataProcess socketDataProcess = SocketDataProcess.Instance;

    private final SelfRechargeSubmitRequestMessage submitRequest = new SelfRechargeSubmitRequestMessage();

    private TipBundle tipBundle;
    private TextView tv_notice;
    private TextView tv_notice1;
    private TextView tv_notice2;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        public void handleMessage(Message param1Message) {
            Intent intent;
            Bundle bundle;
            switch (param1Message.what) {
                default:
                    super.handleMessage(param1Message);
                    return;
                case 1:
                    showToast("写入失败，请检查MAC");
                    break;
                case 2:
                    showToast("操作失败，请重新尝试");
                    break;
                case 4:
                    param1Message.getData().getFloat("f");
                    Toast.makeText(getApplicationContext(), "卡内余额最大不可超过1000元，请重新输入充值金额", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(SelfRechargeTipActivity.this, "5 err", Toast.LENGTH_SHORT).show();
                    break;
            }
            showToast("卡片断电，请重新贴卡");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_recharge_tip);
        findViews();

        nfcAdapter = NfcAdapter.getDefaultAdapter((Context) this);
        pendingIntent = PendingIntent.getActivity((Context) this, 0, (new Intent((Context) this, getClass())).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        tipBundle = (TipBundle) getIntent().getExtras().get(TipBundle.class.getSimpleName());
        tv_notice1.setText("本次充值金额：");
        tv_notice.setText(ByteUtil.toAmountString(tipBundle.getMoney() / 100.0F));
        tv_notice2.setText("元，请确认后再刷卡充值");
        onNewIntent(getIntent());
    }

    private void findViews() {
        tv_notice = findViewById(R.id.tv_notice);
        tv_notice1 = findViewById(R.id.tv_notice1);
        tv_notice2 = findViewById(R.id.tv_notice2);
    }

    private void recharge(final IsoDep isoDep) {
        (new Thread() {
            private void dealPowerDown() throws UnsupportedEncodingException, JSONException {
                isPowerDown = false;
                UnionCitySDCardHelper unionCitySDCardHelper = new UnionCitySDCardHelper(isoDep);
                unionCitySDCardHelper.connect();
                if (!unionCitySDCardHelper.selectId()) {
                    myHandler.sendEmptyMessage(5);
                    return;
                }
                unionCitySDCardHelper.select15hFile();
                if (!unionCitySDCardHelper.selectName()) {
                    myHandler.sendEmptyMessage(5);
                    return;
                }
                String str3 = unionCitySDCardHelper.getRechargeTransactionProve(Integer.valueOf(submitRequest.getCardDealNo(), 16) + 1);
                unionCitySDCardHelper.close();
                if (str3 == UnionCitySDCardHelper.SW_UNKNOWN) {
                    isPowerDown = true;
                    myHandler.sendEmptyMessage(5);
                    //socketDataProcess.stopConnect();
                    return;
                }
                String str2 = "00";
                String str1 = str3;
                if (str3 == null) {
                    str2 = "01";
                    str1 = "";
                }
                submitRequest.setWriteCardStatus(str2);
                submitRequest.setTAC(str1);
                rechargeSubmit();
            }

            private void rechargeSubmit() {
                myHandler.sendEmptyMessage(1);
            }

            public void run() {
                int i;
                int j;
                String str5;
                String str6;
                String str7;
                String str8;
                SelfRechargeApplyRequestMessage selfRechargeApplyRequestMessage;
                try {
                    if (isPowerDown) {
                        dealPowerDown();
                        return;
                    }
                    str5 = SharedPreferencesKeeper.readPhoneNo((Context) SelfRechargeTipActivity.this);
                    str6 = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
                    i = tipBundle.getMoney();
                    j = (int) (SharedPreferencesKeeper.readRechargefee((Context) SelfRechargeTipActivity.this) * 1.0D / 10000.0D * i);
                    str7 = String.valueOf(str5) + "8";
                    str8 = tipBundle.getTransactionSerialNo();
                    selfRechargeApplyRequestMessage = new SelfRechargeApplyRequestMessage();
                    selfRechargeApplyRequestMessage.setPhoneNo(str5);
                    selfRechargeApplyRequestMessage.setPayType(1);
                    selfRechargeApplyRequestMessage.setTransactionSerialNo(str8);
                    UnionCitySDCardHelper unionCitySDCardHelper = new UnionCitySDCardHelper(isoDep);
                    unionCitySDCardHelper.connect();
                    if (!unionCitySDCardHelper.selectId()) {
                        Log.e("youngpark", "2-1");
                        myHandler.sendEmptyMessage(2);
                        return;
                    }

                    CardSelect15hFileResponse cardSelect15hFileResponse = unionCitySDCardHelper.select15hFile();
                    selfRechargeApplyRequestMessage.setCityCode(cardSelect15hFileResponse.getCityCode());
                    selfRechargeApplyRequestMessage.setCardNo(cardSelect15hFileResponse.getCardNo());
                    selfRechargeApplyRequestMessage.setCardType(cardSelect15hFileResponse.getCardType());
                    if (!unionCitySDCardHelper.selectName()) {
                        Log.e("youngpark", "2-2");
                        myHandler.sendEmptyMessage(2);
                        return;
                    }
                    String str3 = unionCitySDCardHelper.readBalance();
                    tipBundle.setBalance(str3);
                    unionCitySDCardHelper.verify();
                    CardInitShopRechargeResponse cardInitShopRechargeResponse = unionCitySDCardHelper.InitShopRecharge(i, str7);
                    selfRechargeApplyRequestMessage.setTerminalNo(str7);
                    selfRechargeApplyRequestMessage.setDealType(1);
                    selfRechargeApplyRequestMessage.setDealNum(i);
                    selfRechargeApplyRequestMessage.setRechargeFee(j);
                    selfRechargeApplyRequestMessage.setCardDealNo("67676710");
                    selfRechargeApplyRequestMessage.setCardBalance(80);
                    selfRechargeApplyRequestMessage.setDealTime(str6);
//                    selfRechargeApplyRequestMessage.setRandom(cardInitShopRechargeResponse.getRandomNumber());
//                    selfRechargeApplyRequestMessage.setMAC1(cardInitShopRechargeResponse.getMAC1());
                    byte[] arrayOfByte = (new ServerRequest(JSONUtils.toJsonWithoutBlank(selfRechargeApplyRequestMessage).getBytes("UTF-8"))).buildRequest();
//                    socketDataProcess.sendDate(arrayOfByte);
//                    JSONObject jSONObject = new JSONObject(socketDataProcess.getData());
                    String MAC = "67106710";
                    int termId = 6710;
                    MAC = unionCitySDCardHelper.recharge(str6, MAC);
                    unionCitySDCardHelper.close();
                    String str2 = "00";
                    String str1 = MAC;
                    if (MAC == null) {
                        str2 = "01";
                        str1 = "";
                    }
                    submitRequest.setPhoneNo(str5);
                    submitRequest.setPayType(1);
                    submitRequest.setTransactionSerialNo(str8);
                    submitRequest.setCityCode(selfRechargeApplyRequestMessage.getCityCode());
                    submitRequest.setCardNo(selfRechargeApplyRequestMessage.getCardNo());
                    submitRequest.setCardType(selfRechargeApplyRequestMessage.getCardType());
                    submitRequest.setTerminalNo(str7);
                    submitRequest.setDealNum(i);
                    submitRequest.setRechargeFee(j);
                    submitRequest.setCardDealNo(selfRechargeApplyRequestMessage.getCardDealNo());
                    submitRequest.setTerminalDealNo(termId);
                    submitRequest.setDealTime(str6);
                    submitRequest.setWriteCardStatus(str2);
                    submitRequest.setTAC(str1);
                    if (str1 == UnionCitySDCardHelper.SW_UNKNOWN) {
                        isPowerDown = true;
                        myHandler.sendEmptyMessage(5);
//                        socketDataProcess.stopConnect();
                        return;
                    }
                    rechargeSubmit();

                } catch (Exception exception) {
                    exception.printStackTrace();
                    Log.e("youngpark", "2-3");
                    myHandler.sendEmptyMessage(2);
//                    socketDataProcess.stopConnect();
                    return;
                }
            }
        }).start();
    }


    private void showToast(String paramString) {
        Toast.makeText((Context) this, paramString, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        Tag tag = (Tag) paramIntent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag != null) {
            IsoDep isoDep = IsoDep.get(tag);
            if (isoDep != null) {
                recharge(isoDep);
                return;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (nfcAdapter != null)
            nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nfcAdapter != null)
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, UnionCitySDCardHelper.FILTERS, UnionCitySDCardHelper.TECH_LISTS);
    }
}
