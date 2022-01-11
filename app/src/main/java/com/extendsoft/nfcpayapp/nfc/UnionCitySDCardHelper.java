package com.extendsoft.nfcpayapp.nfc;

import android.nfc.tech.IsoDep;

import com.extendsoft.nfcpayapp.model.CardConsumeResponse;
import com.extendsoft.nfcpayapp.model.CardInitConsumptionResponse;
import com.extendsoft.nfcpayapp.model.CardInitShopRechargeResponse;
import com.extendsoft.nfcpayapp.model.CardRecord;
import com.extendsoft.nfcpayapp.model.CardSelect15hFileResponse;
import com.extendsoft.nfcpayapp.model.UnionCitySDCard;
import com.extendsoft.nfcpayapp.nfc.Iso7816;
import com.extendsoft.nfcpayapp.nfc.NfcCardHelper;
import com.extendsoft.nfcpayapp.util.ByteUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class UnionCitySDCardHelper extends NfcCardHelper {

    private static final byte[] DFI_ED;
    private static final byte[] DFI_MF;
    private static final String ENCODING = "UTF-8";
    private static final int MAX_LOG = 10;
    private static final int SFI_EXTRA_CNT = 21;
    private static final int SFI_LOG = 24;
    public static String SW_UNKNOWN = "SW_UNKNOWN";
    private static final byte TRANS_CSU = 6;
    private static final byte TRANS_CSU_CPX = 9;
    private static final byte TRANS_RECHARGE = 1;
    private final Iso7816.Tag mTag;


    static {
        byte[] var0 = new byte[]{(byte) 63, (byte) 0};
        DFI_MF = var0;
        DFI_ED = new byte[]{(byte) 90, (byte) 66, (byte) 71, (byte) 71, (byte) 81, (byte) 66};
    }

    public UnionCitySDCardHelper(IsoDep var1) {
        this.mTag = new Iso7816.Tag(var1);
    }

    private boolean addLog(Iso7816.Response var1, ArrayList var2) {
        if (var1.isOkey()) {
            byte[] var6 = var1.getBytes();
            int var5 = var6.length - 23;
            if (var5 >= 0) {
                int var4;
                for (int var3 = 0; var3 <= var5; var3 = var4) {
                    var4 = var3 + 23;
                    var2.add(Arrays.copyOfRange(var6, var3, var4));
                }

                return true;
            }
        }

        return false;
    }

    private String getTransactionProve(int var1, String var2) {
        var2 = "805A00" + var2 + "02";
        String var5 = padLeft(var1, 4);
        byte[] var6 = ByteUtil.hex2bytes(var2 + var5 + "08");
        Iso7816.Response var7 = new Iso7816.Response(this.mTag.transceive(var6));
        byte var3 = var7.getSw1();
        byte var4 = var7.getSw2();
        byte[] var8 = Iso7816.Response.ERROR;
        if (Arrays.equals(new byte[]{var3, var4}, var8)) {
            return SW_UNKNOWN;
        } else if (var7.isOkey() && var7.size() >= 4) {
            var8 = var7.getBytes();
            var2 = ByteUtil.toHexString(var8, 0, 4);
            var5 = ByteUtil.toHexString(var8, 4, 4);
            return var2 + var5;
        } else {
            return null;
        }
    }

    public static String padLeft(int var0, int var1) {
        String var3 = Integer.toHexString(var0);
        char[] var2 = var3.toCharArray();
        if (var2.length >= var1) {
            return var3;
        } else {
            char[] var4 = new char[var1];
            System.arraycopy(var2, 0, var4, var1 - var2.length, var2.length);

            for (var0 = 0; var0 < var1 - var2.length; ++var0) {
                var4[var0] = 48;
            }

            return new String(var4);
        }
    }

    private CardSelect15hFileResponse parse15hFile(Iso7816.Response var1) {
        if (var1.isOkey() && var1.size() >= 44) {
            CardSelect15hFileResponse var2 = new CardSelect15hFileResponse();
            byte[] var3 = var1.getBytes();
            var2.setCityCode(ByteUtil.toHexString(var3, 9, 2));
            var2.setCardType(ByteUtil.toHexString(var3, 11, 1));
            var2.setCardNo(ByteUtil.toHexString(var3, 17, 5));
            return var2;
        } else {
            return null;
        }
    }

    private String parseBalance(Iso7816.Response var1) {
        return var1.isOkey() && var1.size() >= 4 ? ByteUtil.toAmountString((float) ByteUtil.toInt(var1.getBytes(), 0, 4) / 100.0F) : null;
    }

    private String parseCardNo(Iso7816.Response var1) {
        return var1.isOkey() && var1.size() >= 50 ? ByteUtil.toHexString(var1.getBytes(), 17, 5) : null;
    }

    private CardConsumeResponse parseConsume(Iso7816.Response var1) {
        CardConsumeResponse var4 = new CardConsumeResponse();
        byte var2 = var1.getSw1();
        byte var3 = var1.getSw2();
        byte[] var5 = Iso7816.Response.ERROR;
        if (Arrays.equals(new byte[]{var2, var3}, var5)) {
            var4.setHasResponse(false);
            return var4;
        } else if (var1.isOkey() && var1.size() >= 8) {
            byte[] var6 = var1.getBytes();
            var4.setTac(ByteUtil.toHexString(var6, 0, 4));
            var4.setMac2(ByteUtil.toHexString(var6, 4, 4));
            return var4;
        } else {
            var4.setIsSuccess(false);
            return var4;
        }
    }

    private CardInitConsumptionResponse parseInitConsumption(Iso7816.Response var1) {
        if (var1.isOkey() && var1.size() >= 15) {
            CardInitConsumptionResponse var2 = new CardInitConsumptionResponse();
            byte[] var3 = var1.getBytes();
            var2.setOldBalance(ByteUtil.toInt(var3, 0, 4));
            var2.setTransactionNo(ByteUtil.toHexString(var3, 4, 2));
            var2.setRandomNumber(ByteUtil.toHexString(var3, 11, 4));
            return var2;
        } else {
            return null;
        }
    }

    private CardInitShopRechargeResponse parseInitShopRecharge(Iso7816.Response var1) {
        if (var1.isOkey() && var1.size() >= 16) {
            CardInitShopRechargeResponse var2 = new CardInitShopRechargeResponse();
            byte[] var3 = var1.getBytes();
            var2.setOldBalance(ByteUtil.toInt(var3, 0, 4));
            var2.setTransactionNo(ByteUtil.toHexString(var3, 4, 2));
            var2.setRandomNumber(ByteUtil.toHexString(var3, 8, 4));
            var2.setMAC1(ByteUtil.toHexString(var3, 12, 4));
            return var2;
        } else {
            return null;
        }
    }

    private ArrayList parseLog(ArrayList var1) throws ParseException {
        ArrayList var4 = new ArrayList();
        int var2 = 1;
        Iterator var5 = var1.iterator();

        while (var5.hasNext()) {
            byte[] var6 = (byte[]) var5.next();
            int var3 = ByteUtil.toInt(var6, 5, 4);
            if (var3 > 0) {
                CardRecord var7 = new CardRecord();
                var7.setNumber((long) var2);
                String var8 = String.format("%02X%02X-%02X-%02X %02X:%02X", new Object[]{Byte.valueOf(var6[16]), Byte.valueOf(var6[17]), Byte.valueOf(var6[18]), Byte.valueOf(var6[19]), Byte.valueOf(var6[20]), Byte.valueOf(var6[21]), Byte.valueOf(var6[22])});
                var7.setExchangeHour((new SimpleDateFormat("yyyy-MM-dd HH:mm")).parse(var8));
                if (var6[9] == 1) {
                    var8 = "+";
                } else {
                    var8 = "-";
                }

                var7.setSign(var8);
                var7.setMoney(ByteUtil.toAmountString((float) var3 / 100.0F));
                var7.setShopNumber(ByteUtil.toHexString(var6, 10, 6));
                var4.add(var7);
                ++var2;
            }
        }

        return var4;
    }

    private ArrayList readLog(int var1) {
        ArrayList var3 = new ArrayList(10);
        Iso7816.Response var4 = this.mTag.readRecord(var1);
        if (var4.isOkey()) {
            this.addLog(var4, var3);
        } else {
            for (int var2 = 1; var2 <= 10 && this.addLog(this.mTag.readRecord(var1, var2), var3); ++var2) {
                ;
            }
        }

        return var3;
    }

    private ArrayList readRecordBySign(String var1) {
        ArrayList var2 = new ArrayList();

        try {
            this.mTag.connect();
            if (this.selectId() && this.selectName()) {
                Iterator var3 = this.readRecord().iterator();

                while (var3.hasNext()) {
                    CardRecord var4 = (CardRecord) var3.next();
                    if (var4.getSign() == var1) {
                        var2.add(var4);
                    }
                }
            }

            this.mTag.close();
            return var2;
        } catch (Exception var5) {
            return null;
        }
    }

    public CardInitConsumptionResponse InitComsuption(int var1, String var2) {
        String var3 = padLeft(var1, 8);
        byte[] var4 = ByteUtil.hex2bytes("805001010B01" + var3 + var2 + "10");
        return this.parseInitConsumption(new Iso7816.Response(this.mTag.transceive(var4)));
    }

    public CardInitShopRechargeResponse InitShopRecharge(int var1, String var2) {
        String var3 = padLeft(var1, 8);
        byte[] var4 = ByteUtil.hex2bytes("805000010B01" + var3 + var2 + "10");
        return this.parseInitShopRecharge(new Iso7816.Response(this.mTag.transceive(var4)));
    }

    public void close() {
        this.mTag.close();
    }

    public void connect() {
        this.mTag.connect();
    }

    public CardConsumeResponse consume(int var1, String var2, String var3) {
        String var4 = padLeft(var1, 8);
        byte[] var5 = ByteUtil.hex2bytes("805401000F" + var4 + var2 + var3 + "08");
        return this.parseConsume(new Iso7816.Response(this.mTag.transceive(var5)));
    }

    public String getConsumeTransactionProve(int var1) {
        return this.getTransactionProve(var1, "05");
    }

    public String getRechargeTransactionProve(int var1) {
        String var3 = this.getTransactionProve(var1, "01");
        String var2 = var3;
        if (var3 != null) {
            var2 = var3;
            if (var3 != SW_UNKNOWN) {
                var2 = var3.substring(8, var3.length());
            }
        }

        return var2;
    }

    public UnionCitySDCard readAll() {
        try {
            this.mTag.connect();
            UnionCitySDCard var1 = new UnionCitySDCard();
            if (this.selectId()) {
                var1.setCardType("山东城联卡");
                var1.setCardNumber(this.readCardNo());
                if (this.selectName()) {
                    var1.setCardBalance(this.readBalance());
                    var1.getCardRecords().addAll(this.readRecord());
                }
            }

            this.mTag.close();
            return var1;
        } catch (Exception var2) {
            return null;
        }
    }

    public String readBalance() {
        return this.parseBalance(this.mTag.getBalance(false));
    }

    public String readCardNo() {
        return this.parseCardNo(this.mTag.readCardNo(21));
    }

    public ArrayList readConsumptionRecord() {
        return this.readRecordBySign("-");
    }

    public ArrayList readRechargeRecord() {
        return this.readRecordBySign("+");
    }

    public ArrayList readRecord() throws ParseException {
        return this.parseLog(this.readLog(24));
    }

    public String recharge(String var1, String Mac) {
        byte[] var5 = ByteUtil.hex2bytes("805200000B" + var1 + Mac + "04");
        Iso7816.Response var6 = new Iso7816.Response(this.mTag.transceive(var5));
        byte var3 = var6.getSw1();
        byte var4 = var6.getSw2();
        byte[] var7 = Iso7816.Response.ERROR;
        return Arrays.equals(new byte[]{var3, var4}, var7) ? SW_UNKNOWN : (var6.isOkey() && var6.size() >= 4 ? ByteUtil.toHexString(var6.getBytes(), 0, 4) : null);
    }

    public CardSelect15hFileResponse select15hFile() {
        byte[] var1 = ByteUtil.hex2bytes("00B095002F");
        return this.parse15hFile(new Iso7816.Response(this.mTag.transceive(var1)));
    }

    public boolean selectId() {
        return this.mTag.selectByID(DFI_MF).isOkey();
    }

    public boolean selectName() {
        return this.mTag.selectByName(DFI_ED).isOkey();
    }

    public void verify() {
        this.mTag.verify();
    }
}
