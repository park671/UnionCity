package com.extendsoft.nfcpayapp.model;


public class UserModifyPasswordRequestMessage {

   private String IdentifyingCode;
   private String NewPassword;
   private String PhoneNo;
   private String command = "Online.UserModifyPassword";


   public String getCommand() {
      return this.command;
   }

   public String getIdentifyingCode() {
      return this.IdentifyingCode;
   }

   public String getNewPassword() {
      return this.NewPassword;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setIdentifyingCode(String var1) {
      this.IdentifyingCode = var1;
   }

   public void setNewPassword(String var1) {
      this.NewPassword = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }
}
