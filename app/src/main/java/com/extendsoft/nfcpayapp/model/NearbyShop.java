package com.extendsoft.nfcpayapp.model;


public class NearbyShop {

   private String shopAddress;
   private String shopName;
   private String shopTelphone;
   private String shopType;


   public NearbyShop() {}

   public NearbyShop(String var1, String var2, String var3, String var4) {
      this.shopName = var1;
      this.shopAddress = var2;
      this.shopTelphone = var3;
      this.shopType = var4;
   }

   public String getShopAddress() {
      return this.shopAddress;
   }

   public String getShopName() {
      return this.shopName;
   }

   public String getShopTelphone() {
      return this.shopTelphone;
   }

   public String getShopType() {
      return this.shopType;
   }

   public void setShopAddress(String var1) {
      this.shopAddress = var1;
   }

   public void setShopName(String var1) {
      this.shopName = var1;
   }

   public void setShopTelphone(String var1) {
      this.shopTelphone = var1;
   }

   public void setShopType(String var1) {
      this.shopType = var1;
   }
}
