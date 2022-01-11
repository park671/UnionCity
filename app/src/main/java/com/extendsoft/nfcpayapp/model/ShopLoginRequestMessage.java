package com.extendsoft.nfcpayapp.model;


public class ShopLoginRequestMessage {

   private String Password;
   private String ShopNo;
   private String TerminalNo;
   private String command;


   public ShopLoginRequestMessage() {
      this.command = "Online.ShopLogin";
   }

   public ShopLoginRequestMessage(String var1, String var2, String var3) {
      this.ShopNo = var1;
      this.TerminalNo = var2;
      this.Password = var3;
   }

   public String getCommand() {
      return this.command;
   }

   public String getPassword() {
      return this.Password;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public String getTerminalNo() {
      return this.TerminalNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPassword(String var1) {
      this.Password = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }

   public void setTerminalNo(String var1) {
      this.TerminalNo = var1;
   }
}
