package com.extendsoft.nfcpayapp.model;


public class UserLoginRequestMessage {

   private String Password;
   private String PhoneNo;


   public String getPassword() {
      return this.Password;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public void setPassword(String var1) {
      this.Password = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }
}
