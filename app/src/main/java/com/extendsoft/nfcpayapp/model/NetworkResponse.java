package com.extendsoft.nfcpayapp.model;


public class NetworkResponse {

   private String MAC1;
   private String MAC2;
   private String message;
   private int reputationQuota;
   private boolean result;
   private int terminalDealNo;


   public NetworkResponse() {}

   public NetworkResponse(boolean var1, String var2, String var3, int var4, int var5, String var6) {
      this.result = var1;
      this.MAC1 = var2;
      this.MAC2 = var3;
      this.reputationQuota = var4;
      this.terminalDealNo = var5;
      this.message = var6;
   }

   public String getMAC1() {
      return this.MAC1;
   }

   public String getMAC2() {
      return this.MAC2;
   }

   public String getMessage() {
      return this.message;
   }

   public int getReputationQuota() {
      return this.reputationQuota;
   }

   public int getTerminalDealNo() {
      return this.terminalDealNo;
   }

   public boolean isResult() {
      return this.result;
   }

   public void setMAC1(String var1) {
      this.MAC1 = var1;
   }

   public void setMAC2(String var1) {
      this.MAC2 = var1;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void setReputationQuota(int var1) {
      this.reputationQuota = var1;
   }

   public void setResult(boolean var1) {
      this.result = var1;
   }

   public void setTerminalDealNo(int var1) {
      this.terminalDealNo = var1;
   }
}
