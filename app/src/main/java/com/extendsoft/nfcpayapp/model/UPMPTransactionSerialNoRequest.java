package com.extendsoft.nfcpayapp.model;


public class UPMPTransactionSerialNoRequest {

   private int DealNum;
   private String DealType;
   private int RechargeFee;
   private String Signature;
   private String command = "Online.GetUPMPTransactionSerialNo";


   public String getCommand() {
      return this.command;
   }

   public int getDealNum() {
      return this.DealNum;
   }

   public String getDealType() {
      return this.DealType;
   }

   public int getRechargeFee() {
      return this.RechargeFee;
   }

   public String getSignature() {
      return this.Signature;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setDealNum(int var1) {
      this.DealNum = var1;
   }

   public void setDealType(String var1) {
      this.DealType = var1;
   }

   public void setRechargeFee(int var1) {
      this.RechargeFee = var1;
   }

   public void setSignature(String var1) {
      this.Signature = var1;
   }
}
