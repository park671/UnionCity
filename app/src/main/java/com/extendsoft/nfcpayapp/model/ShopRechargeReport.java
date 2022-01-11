package com.extendsoft.nfcpayapp.model;


public class ShopRechargeReport {

   private int dealCount;
   private String dealDate;
   private int dealSum;
   private long number;


   public int getDealCount() {
      return this.dealCount;
   }

   public String getDealDate() {
      return this.dealDate;
   }

   public int getDealSum() {
      return this.dealSum;
   }

   public long getNumber() {
      return this.number;
   }

   public void setDealCount(int var1) {
      this.dealCount = var1;
   }

   public void setDealDate(String var1) {
      this.dealDate = var1;
   }

   public void setDealSum(int var1) {
      this.dealSum = var1;
   }

   public void setNumber(long var1) {
      this.number = var1;
   }
}
