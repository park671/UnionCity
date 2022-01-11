package com.extendsoft.nfcpayapp.model;


public class UserRechargeSumRequestMessage {

   private String PhoneNo;
   private String command = "Online.GetUserRechargeSum";


   public String getCommand() {
      return this.command;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }
}
