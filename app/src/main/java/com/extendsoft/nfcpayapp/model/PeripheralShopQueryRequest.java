package com.extendsoft.nfcpayapp.model;


public class PeripheralShopQueryRequest {

   private int PageSize;
   private int Position;
   private String ShopName;
   private String ShopNo;
   private String command = "Online.PeripheralShopQuery";


   public String getCommand() {
      return this.command;
   }

   public int getPageSize() {
      return this.PageSize;
   }

   public int getPosition() {
      return this.Position;
   }

   public String getShopName() {
      return this.ShopName;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setPageSize(int var1) {
      this.PageSize = var1;
   }

   public void setPosition(int var1) {
      this.Position = var1;
   }

   public void setShopName(String var1) {
      this.ShopName = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }
}
