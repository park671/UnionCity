package com.extendsoft.nfcpayapp.model;


public class CardInitShopRechargeResponse {

   private String MAC1;
   private String algorithmId;
   private String keyVersion;
   private int oldBalance;
   private String randomNumber;
   private String transactionNo;


   public String getAlgorithmId() {
      return this.algorithmId;
   }

   public String getKeyVersion() {
      return this.keyVersion;
   }

   public String getMAC1() {
      return this.MAC1;
   }

   public int getOldBalance() {
      return this.oldBalance;
   }

   public String getRandomNumber() {
      return this.randomNumber;
   }

   public String getTransactionNo() {
      return this.transactionNo;
   }

   public void setAlgorithmId(String var1) {
      this.algorithmId = var1;
   }

   public void setKeyVersion(String var1) {
      this.keyVersion = var1;
   }

   public void setMAC1(String var1) {
      this.MAC1 = var1;
   }

   public void setOldBalance(int var1) {
      this.oldBalance = var1;
   }

   public void setRandomNumber(String var1) {
      this.randomNumber = var1;
   }

   public void setTransactionNo(String var1) {
      this.transactionNo = var1;
   }
}
