package com.extendsoft.nfcpayapp.model;


public class PersonRechargeRecord {

   private int beforeCardBalance;
   private String cardDealNo;
   private String cardNo;
   private String cardType;
   private int dealSum;
   private String dealTime;
   private long number;
   private String recordCode;
   private String tac;


   public int getBeforeCardBalance() {
      return this.beforeCardBalance;
   }

   public String getCardDealNo() {
      return this.cardDealNo;
   }

   public String getCardNo() {
      return this.cardNo;
   }

   public String getCardType() {
      return this.cardType;
   }

   public int getDealSum() {
      return this.dealSum;
   }

   public String getDealTime() {
      return this.dealTime;
   }

   public long getNumber() {
      return this.number;
   }

   public String getRecordCode() {
      return this.recordCode;
   }

   public String getTac() {
      return this.tac;
   }

   public void setBeforeCardBalance(int var1) {
      this.beforeCardBalance = var1;
   }

   public void setCardDealNo(String var1) {
      this.cardDealNo = var1;
   }

   public void setCardNo(String var1) {
      this.cardNo = var1;
   }

   public void setCardType(String var1) {
      this.cardType = var1;
   }

   public void setDealSum(int var1) {
      this.dealSum = var1;
   }

   public void setDealTime(String var1) {
      this.dealTime = var1;
   }

   public void setNumber(long var1) {
      this.number = var1;
   }

   public void setRecordCode(String var1) {
      this.recordCode = var1;
   }

   public void setTac(String var1) {
      this.tac = var1;
   }
}
