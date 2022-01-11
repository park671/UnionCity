package com.extendsoft.nfcpayapp.model;


public class SelfRechargeApplyRequestMessage {

   private int CardBalance;
   private String CardDealNo;
   private String CardNo;
   private String CardType;
   private String CityCode;
   private int DealNum;
   private String DealTime;
   private int DealType;
   private String MAC1;
   private int PayType;
   private String PhoneNo;
   private String Random;
   private int RechargeFee;
   private String TerminalNo;
   private String TransactionSerialNo;
   private String command = "Online.UserRechargeRequest";


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

   public String getMAC1() {
      return this.MAC1;
   }

   public int getPayType() {
      return this.PayType;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public String getRandom() {
      return this.Random;
   }

   public int getRechargeFee() {
      return this.RechargeFee;
   }

   public String getTerminalNo() {
      return this.TerminalNo;
   }

   public String getTransactionSerialNo() {
      return this.TransactionSerialNo;
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

   public void setMAC1(String var1) {
      this.MAC1 = var1;
   }

   public void setPayType(int var1) {
      this.PayType = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setRandom(String var1) {
      this.Random = var1;
   }

   public void setRechargeFee(int var1) {
      this.RechargeFee = var1;
   }

   public void setTerminalNo(String var1) {
      this.TerminalNo = var1;
   }

   public void setTransactionSerialNo(String var1) {
      this.TransactionSerialNo = var1;
   }
}
