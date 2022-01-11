package com.extendsoft.nfcpayapp.model;


public class ShopReputationQuotaRechargeRecord {

   private int dealSum;
   private String dealTime;
   private long number;
   private String recordCode;


   public int getDealSum() {
      return this.dealSum;
   }

   public String getDealTime() {
      return this.dealTime;
   }

   public long getNumber() {
      return this.number;
   }

   public String getRecordCode() {
      return this.recordCode;
   }

   public void setDealSum(int var1) {
      this.dealSum = var1;
   }

   public void setDealTime(String var1) {
      this.dealTime = var1;
   }

   public void setNumber(long var1) {
      this.number = var1;
   }

   public void setRecordCode(String var1) {
      this.recordCode = var1;
   }
}
