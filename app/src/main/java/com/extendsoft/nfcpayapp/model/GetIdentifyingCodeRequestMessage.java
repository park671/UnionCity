package com.extendsoft.nfcpayapp.model;


public class GetIdentifyingCodeRequestMessage {

   private String PhoneNo;
   private int UseType;
   private String command = "Online.GetIdentifyingCode";


   public String getCommand() {
      return this.command;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public int getUseType() {
      return this.UseType;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setUseType(int var1) {
      this.UseType = var1;
   }
}
