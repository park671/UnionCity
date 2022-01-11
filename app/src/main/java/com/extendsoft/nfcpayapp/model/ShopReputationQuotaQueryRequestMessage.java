package com.extendsoft.nfcpayapp.model;


public class ShopReputationQuotaQueryRequestMessage {

   private String ShopNo;
   private String command;


   public ShopReputationQuotaQueryRequestMessage() {
      this.command = "Online.ShopReputationQuotaQuery";
   }

   public ShopReputationQuotaQueryRequestMessage(String var1) {
      this.ShopNo = var1;
   }

   public String getCommand() {
      return this.command;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }
}
