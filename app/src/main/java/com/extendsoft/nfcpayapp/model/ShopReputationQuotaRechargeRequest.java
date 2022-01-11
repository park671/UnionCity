package com.extendsoft.nfcpayapp.model;


public class ShopReputationQuotaRechargeRequest {

   private int DealNum;
   private int PayType;
   private String ShopNo;
   private String Signature;
   private String TransactionSerialNo;
   private String command = "Online.ShopReputationQuotaRecharge";


   public String getCommand() {
      return this.command;
   }

   public int getDealNum() {
      return this.DealNum;
   }

   public int getPayType() {
      return this.PayType;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public String getSignature() {
      return this.Signature;
   }

   public String getTransactionSerialNo() {
      return this.TransactionSerialNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setDealNum(int var1) {
      this.DealNum = var1;
   }

   public void setPayType(int var1) {
      this.PayType = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }

   public void setSignature(String var1) {
      this.Signature = var1;
   }

   public void setTransactionSerialNo(String var1) {
      this.TransactionSerialNo = var1;
   }
}
