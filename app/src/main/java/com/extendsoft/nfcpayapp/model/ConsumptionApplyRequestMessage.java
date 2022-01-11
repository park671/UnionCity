package com.extendsoft.nfcpayapp.model;


public class ConsumptionApplyRequestMessage {

   private int CardBalance;
   private String CardDealNo;
   private String CardNo;
   private String CardType;
   private String CityCode;
   private int DealNum;
   private String DealTime;
   private int DealType;
   private String PhoneNo;
   private String Random;
   private String ShopNo;
   private String TerminalNo;
   private String command;


   public ConsumptionApplyRequestMessage() {
      this.command = "Online.ShopConsumeRequest";
      this.DealType = 5;
   }

   public ConsumptionApplyRequestMessage(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, String var9, int var10, String var11, String var12) {
      this.ShopNo = var1;
      this.PhoneNo = var2;
      this.CityCode = var3;
      this.CardNo = var4;
      this.CardType = var5;
      this.TerminalNo = var6;
      this.DealNum = var8;
      this.CardDealNo = var9;
      this.CardBalance = var10;
      this.DealTime = var11;
      this.Random = var12;
   }

   public int getCardBalance() {
      return this.CardBalance;
   }

   public String getCardDealNo() {
      return this.CardDealNo;
   }

   public String getCardNo() {
      return this.CardNo;
   }

   public String getCardType() {
      return this.CardType;
   }

   public String getCityCode() {
      return this.CityCode;
   }

   public String getCommand() {
      return this.command;
   }

   public int getDealNum() {
      return this.DealNum;
   }

   public String getDealTime() {
      return this.DealTime;
   }

   public int getDealType() {
      return this.DealType;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public String getRandom() {
      return this.Random;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public String getTerminalNo() {
      return this.TerminalNo;
   }

   public void setCardBalance(int var1) {
      this.CardBalance = var1;
   }

   public void setCardDealNo(String var1) {
      this.CardDealNo = var1;
   }

   public void setCardNo(String var1) {
      this.CardNo = var1;
   }

   public void setCardType(String var1) {
      this.CardType = var1;
   }

   public void setCityCode(String var1) {
      this.CityCode = var1;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setDealNum(int var1) {
      this.DealNum = var1;
   }

   public void setDealTime(String var1) {
      this.DealTime = var1;
   }

   public void setDealType(int var1) {
      this.DealType = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setRandom(String var1) {
      this.Random = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }

   public void setTerminalNo(String var1) {
      this.TerminalNo = var1;
   }
}
