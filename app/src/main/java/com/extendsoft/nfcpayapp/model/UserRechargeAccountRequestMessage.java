package com.extendsoft.nfcpayapp.model;


public class UserRechargeAccountRequestMessage {

   private int DealNum;
   private int PayType;
   private String PhoneNo;
   private int RechargeFee;
   private String Signature;
   private String TransactionSerialNo;
   private String command = "Online.UserRechargeAccount";


   public String getCommand() {
      return this.command;
   }

   public int getDealNum() {
      return this.DealNum;
   }

   public int getPayType() {
      return this.PayType;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public int getRechargeFee() {
      return this.RechargeFee;
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

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setRechargeFee(int var1) {
      this.RechargeFee = var1;
   }

   public void setSignature(String var1) {
      this.Signature = var1;
   }

   public void setTransactionSerialNo(String var1) {
      this.TransactionSerialNo = var1;
   }
}
