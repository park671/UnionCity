package com.extendsoft.nfcpayapp.model;

import com.extendsoft.nfcpayapp.model.ConsumptionApplyRequestMessage;

public class ConsumptionReverseRequestMessage {

   private int CardBalance;
   private String CardDealNo;
   private String CardNo;
   private String CardType;
   private String CityCode;
   private int DealNum;
   private String DealTime;
   private String PhoneNo;
   private String Random;
   private String ShopNo;
   private String TerminalNo;
   private String command;


   public ConsumptionReverseRequestMessage() {
      this.command = "Online.ShopConsumeReverse";
   }

   public ConsumptionReverseRequestMessage(ConsumptionApplyRequestMessage var1) {
      if(var1 != null) {
         this.command = "Online.ShopConsumeReverse";
         this.ShopNo = var1.getShopNo();
         this.PhoneNo = var1.getPhoneNo();
         this.CityCode = var1.getCityCode();
         this.CardNo = var1.getCardNo();
         this.CardType = var1.getCardType();
         this.TerminalNo = var1.getTerminalNo();
         this.DealNum = var1.getDealNum();
         this.CardDealNo = var1.getCardDealNo();
         this.CardBalance = var1.getCardBalance();
         this.DealTime = var1.getDealTime();
         this.Random = var1.getRandom();
      }
   }

   public ConsumptionReverseRequestMessage(String var1, String var2, String var3, String var4, String var5, String var6, int var7, String var8, int var9, String var10, String var11) {
      this.ShopNo = var1;
      this.PhoneNo = var2;
      this.CityCode = var3;
      this.CardNo = var4;
      this.CardType = var5;
      this.TerminalNo = var6;
      this.DealNum = var7;
      this.CardDealNo = var8;
      this.CardBalance = var9;
      this.DealTime = var10;
      this.Random = var11;
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
