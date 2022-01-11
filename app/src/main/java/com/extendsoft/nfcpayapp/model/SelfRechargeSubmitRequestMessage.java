package com.extendsoft.nfcpayapp.model;


public class SelfRechargeSubmitRequestMessage {

   private String CardDealNo;
   private String CardNo;
   private String CardType;
   private String CityCode;
   private int DealNum;
   private String DealTime;
   private int PayType;
   private String PhoneNo;
   private int RechargeFee;
   private String TAC;
   private int TerminalDealNo;
   private String TerminalNo;
   private String TransactionSerialNo;
   private String WriteCardStatus;
   private String command = "Online.UserRechargeCommit";


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

   public int getPayType() {
      return this.PayType;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public int getRechargeFee() {
      return this.RechargeFee;
   }

   public String getTAC() {
      return this.TAC;
   }

   public int getTerminalDealNo() {
      return this.TerminalDealNo;
   }

   public String getTerminalNo() {
      return this.TerminalNo;
   }

   public String getTransactionSerialNo() {
      return this.TransactionSerialNo;
   }

   public String getWriteCardStatus() {
      return this.WriteCardStatus;
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

   public void setPayType(int var1) {
      this.PayType = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setRechargeFee(int var1) {
      this.RechargeFee = var1;
   }

   public void setTAC(String var1) {
      this.TAC = var1;
   }

   public void setTerminalDealNo(int var1) {
      this.TerminalDealNo = var1;
   }

   public void setTerminalNo(String var1) {
      this.TerminalNo = var1;
   }

   public void setTransactionSerialNo(String var1) {
      this.TransactionSerialNo = var1;
   }

   public void setWriteCardStatus(String var1) {
      this.WriteCardStatus = var1;
   }
}
