package com.extendsoft.nfcpayapp.model;


public class AppAutoUpdateInfoRequest {

   private String PhoneNo;
   private int UpdateType;
   private String command = "Online.AppAutoUpdateInfo";


   public String getCommand() {
      return this.command;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public int getUpdateType() {
      return this.UpdateType;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setUpdateType(int var1) {
      this.UpdateType = var1;
   }
}
