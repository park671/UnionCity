package com.extendsoft.nfcpayapp.network;

import com.extendsoft.nfcpayapp.model.AppAutoUpdateInfoRequest;
import com.extendsoft.nfcpayapp.model.CheckInCardCommitRequest;
import com.extendsoft.nfcpayapp.model.CheckInCardRequest;
import com.extendsoft.nfcpayapp.model.CheckInCardSumRequest;
import com.extendsoft.nfcpayapp.model.ComplaintAndSuggestionRequestMessage;
import com.extendsoft.nfcpayapp.model.GetIdentifyingCodeRequestMessage;
import com.extendsoft.nfcpayapp.model.PeripheralShopQueryResponse;
import com.extendsoft.nfcpayapp.model.PersonRechargeRecordQueryResponse;
import com.extendsoft.nfcpayapp.model.PersonRechargeReportQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopConsumeRecordQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopConsumeReportQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopLoginRequestMessage;
import com.extendsoft.nfcpayapp.model.ShopRechargeRecordQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopRechargeReportQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopReputationQuotaRechargeRecordQueryResponse;
import com.extendsoft.nfcpayapp.model.ShopReputationQuotaRechargeRequest;
import com.extendsoft.nfcpayapp.model.UPMPTransactionSerialNoRequest;
import com.extendsoft.nfcpayapp.model.UserLoginRequestMessage;
import com.extendsoft.nfcpayapp.model.UserModifyPasswordRequestMessage;
import com.extendsoft.nfcpayapp.model.UserRechargeAccountRequestMessage;
import com.extendsoft.nfcpayapp.model.UserRechargeSumRequestMessage;
import com.extendsoft.nfcpayapp.model.UserRegisterRequestMessage;
import com.extendsoft.nfcpayapp.network.SocketDataProcess;
import com.extendsoft.nfcpayapp.util.MD5;
import org.json.JSONObject;

public class ServerHelper {

   public static final int ERROR_QUOTA = -1;
   private SocketDataProcess socketDataProcess;


   public ServerHelper() {
      this.socketDataProcess = SocketDataProcess.Instance;
   }

   public JSONObject getAppAutoUpdateInfoRequest(String var1, int var2) {
      AppAutoUpdateInfoRequest var3 = new AppAutoUpdateInfoRequest();
      var3.setPhoneNo(var1);
      var3.setUpdateType(var2);
      return this.getJsonObject(var3, (String)null);
   }

   public JSONObject getCheckInCardCommitRequest(String var1, String var2, String var3, String var4, String var5, int var6, String var7, int var8, String var9, String var10, String var11) {
      CheckInCardCommitRequest var12 = new CheckInCardCommitRequest();
      var12.setPhoneNo(var1);
      var12.setCityCode(var2);
      var12.setCardNo(var3);
      var12.setCardType(var4);
      var12.setTerminalNo(var5);
      var12.setDealNum(var6);
      var12.setCardDealNo(var7);
      var12.setTerminalDealNo(var8);
      var12.setDealTime(var9);
      var12.setWriteCardStatus(var10);
      var12.setTAC(var11);
      return this.getJsonObject(var12, (String)null);
   }

   public JSONObject getCheckInCardRequest(String var1, String var2, String var3, String var4, String var5, int var6, int var7, String var8, int var9, String var10, String var11, String var12) {
      CheckInCardRequest var13 = new CheckInCardRequest();
      var13.setPhoneNo(var1);
      var13.setCityCode(var2);
      var13.setCardNo(var3);
      var13.setCardType(var4);
      var13.setTerminalNo(var5);
      var13.setDealType(var6);
      var13.setDealNum(var7);
      var13.setCardDealNo(var8);
      var13.setCardBalance(var9);
      var13.setDealTime(var10);
      var13.setRandom(var11);
      var13.setMAC1(var12);
      return this.getJsonObject(var13, (String)null);
   }

   public JSONObject getComplaintAndSuggestionResult(int var1, String var2, String var3, String var4) {
      ComplaintAndSuggestionRequestMessage var5 = new ComplaintAndSuggestionRequestMessage();
      var5.setNo(var2);
      var5.setMail(var3);
      var5.setComplaintAndSuggestion(var4);
      return this.getJsonObject(var5, (String)null);
   }

   public JSONObject getIdentifyingCode(String var1, int var2) {
      GetIdentifyingCodeRequestMessage var3 = new GetIdentifyingCodeRequestMessage();
      var3.setPhoneNo(var1);
      var3.setUseType(var2);
      return this.getJsonObject(var3, (String)null);
   }

   public JSONObject getJsonObject(Object param1, String param2) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public JSONObject getNoCheckInCardSum(String var1, String var2) {
      CheckInCardSumRequest var3 = new CheckInCardSumRequest();
      var3.setPhoneNo(var1);
      var3.setCardNo(var2);
      return this.getJsonObject(var3, (String)null);
   }

   public PeripheralShopQueryResponse getPeripheralShop(String param1, String param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public JSONObject getShopLoginResult(String var1, String var2, String var3) {
      ShopLoginRequestMessage var4 = new ShopLoginRequestMessage();
      var4.setShopNo(var1);
      var4.setTerminalNo(var2);
      var4.setPassword(MD5.GetMD5Code(var3));
      return this.getJsonObject(var4, (String)null);
   }

   public JSONObject getUPMPTransactionSerialNoResult(int var1, int var2, String var3, String var4) {
      UPMPTransactionSerialNoRequest var5 = new UPMPTransactionSerialNoRequest();
      var5.setDealNum(var1);
      var5.setRechargeFee(var2);
      var5.setSignature(MD5.GetMD5Code(var3));
      var5.setDealType(var4);
      return this.getJsonObject(var5, (String)null);
   }

   public JSONObject getUserLoginResult(String var1, String var2) {
      UserLoginRequestMessage var3 = new UserLoginRequestMessage();
      var3.setPhoneNo(var1);
      var3.setPassword(MD5.GetMD5Code(var2));
      return this.getJsonObject(var3, "\"command\":\"Online.UserLogin\"");
   }

   public JSONObject getUserModifyPasswordResult(String var1, String var2, String var3) {
      UserModifyPasswordRequestMessage var4 = new UserModifyPasswordRequestMessage();
      var4.setPhoneNo(var1);
      var4.setNewPassword(MD5.GetMD5Code(var2));
      var4.setIdentifyingCode(var3);
      return this.getJsonObject(var4, (String)null);
   }

   public JSONObject getUserRechargeAccountResult(String var1, int var2, String var3, int var4, int var5, String var6) {
      UserRechargeAccountRequestMessage var7 = new UserRechargeAccountRequestMessage();
      var7.setPhoneNo(var1);
      var7.setPayType(var2);
      var7.setTransactionSerialNo(var3);
      var7.setDealNum(var4);
      var7.setRechargeFee(var5);
      var7.setSignature(MD5.GetMD5Code(var6));
      return this.getJsonObject(var7, (String)null);
   }

   public JSONObject getUserRechargeSum(String var1) {
      UserRechargeSumRequestMessage var2 = new UserRechargeSumRequestMessage();
      var2.setPhoneNo(var1);
      return this.getJsonObject(var2, (String)null);
   }

   public JSONObject getUserRegisterResult(String var1, String var2, String var3) {
      UserRegisterRequestMessage var4 = new UserRegisterRequestMessage();
      var4.setPhoneNo(var1);
      var4.setPassword(MD5.GetMD5Code(var2));
      var4.setIdentifyingCode(var3);
      return this.getJsonObject(var4, (String)null);
   }

   public PersonRechargeRecordQueryResponse queryPersonRechargeRecord(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public PersonRechargeReportQueryResponse queryPersonRechargeReport(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public ShopConsumeRecordQueryResponse queryShopConsumeRecords(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public ShopConsumeReportQueryResponse queryShopConsumeReport(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public ShopRechargeRecordQueryResponse queryShopRechargeRecord(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public ShopRechargeReportQueryResponse queryShopRechargeReport(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public int queryShopReputationQuota(String param1) {
      // $FF: Couldn't be decompiled
      return 1;
   }

   public ShopReputationQuotaRechargeRecordQueryResponse queryShopReputationQuotaRechargeRecord(String param1, String param2, String param3, String param4, int param5, int param6) {
      // $FF: Couldn't be decompiled
      return null;
   }

   public JSONObject shopReputationQuotaRecharge(String var1, int var2, String var3, int var4, String var5) {
      ShopReputationQuotaRechargeRequest var6 = new ShopReputationQuotaRechargeRequest();
      var6.setShopNo(var1);
      var6.setPayType(var2);
      var6.setTransactionSerialNo(var3);
      var6.setDealNum(var4);
      var6.setSignature(MD5.GetMD5Code(var5));
      return this.getJsonObject(var6, (String)null);
   }
}
