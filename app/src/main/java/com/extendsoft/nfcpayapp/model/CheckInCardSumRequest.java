package com.extendsoft.nfcpayapp.model;


public class CheckInCardSumRequest {

   private String CardNo;
   private String PhoneNo;
   private String command = "Online.GetNoCheckInCardSum";


   public String getCardNo() {
      return this.CardNo;
   }

   public String getCommand() {
      return this.command;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public void setCardNo(String var1) {
      this.CardNo = var1;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }
}
