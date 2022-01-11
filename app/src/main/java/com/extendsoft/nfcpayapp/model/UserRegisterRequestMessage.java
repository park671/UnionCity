package com.extendsoft.nfcpayapp.model;


public class UserRegisterRequestMessage {

   private String IdentifyingCode;
   private String Password;
   private String PhoneNo;
   private String command = "Online.UserRegister";


   public String getCommand() {
      return this.command;
   }

   public String getIdentifyingCode() {
      return this.IdentifyingCode;
   }

   public String getPassword() {
      return this.Password;
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

   public void setPassword(String var1) {
      this.Password = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }
}
