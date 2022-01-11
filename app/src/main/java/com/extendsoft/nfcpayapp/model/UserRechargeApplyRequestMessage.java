package com.extendsoft.nfcpayapp.model;


public class UserRechargeApplyRequestMessage {

   private String MAC1;
   private String alipayAccountNo;
   private String bankCardNo;
   private int cardBalance;
   private String cardDealNo;
   private String cardNo;
   private String cardType;
   private String cityCode;
   private String command;
   private int dealNum;
   private String dealTime;
   private int payType;
   private String paymentSerialNo;
   private String phoneNo;
   private String random;
   private String terminalNo;
   private String userName;


   public UserRechargeApplyRequestMessage() {
      this.command = "Online.UserRechargeRequest";
   }

   public UserRechargeApplyRequestMessage(String var1, String var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, int var11, String var12, int var13, String var14, String var15, String var16) {
      this.userName = var1;
      this.phoneNo = var2;
      this.payType = var3;
      this.bankCardNo = var4;
      this.alipayAccountNo = var5;
      this.paymentSerialNo = var6;
      this.cityCode = var7;
      this.cardNo = var8;
      this.cardType = var9;
      this.terminalNo = var10;
      this.dealNum = var11;
      this.cardDealNo = var12;
      this.cardBalance = var13;
      this.dealTime = var14;
      this.random = var15;
      this.MAC1 = var16;
   }

   public String getAlipayAccountNo() {
      return this.alipayAccountNo;
   }

   public String getBankCardNo() {
      return this.bankCardNo;
   }

   public int getCardBalance() {
      return this.cardBalance;
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

   public String getCityCode() {
      return this.cityCode;
   }

   public String getCommand() {
      return this.command;
   }

   public int getDealNum() {
      return this.dealNum;
   }

   public String getDealTime() {
      return this.dealTime;
   }

   public String getMAC1() {
      return this.MAC1;
   }

   public int getPayType() {
      return this.payType;
   }

   public String getPaymentSerialNo() {
      return this.paymentSerialNo;
   }

   public String getPhoneNo() {
      return this.phoneNo;
   }

   public String getRandom() {
      return this.random;
   }

   public String getTerminalNo() {
      return this.terminalNo;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setAlipayAccountNo(String var1) {
      this.alipayAccountNo = var1;
   }

   public void setBankCardNo(String var1) {
      this.bankCardNo = var1;
   }

   public void setCardBalance(int var1) {
      this.cardBalance = var1;
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

   public void setCityCode(String var1) {
      this.cityCode = var1;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setDealNum(int var1) {
      this.dealNum = var1;
   }

   public void setDealTime(String var1) {
      this.dealTime = var1;
   }

   public void setMAC1(String var1) {
      this.MAC1 = var1;
   }

   public void setPayType(int var1) {
      this.payType = var1;
   }

   public void setPaymentSerialNo(String var1) {
      this.paymentSerialNo = var1;
   }

   public void setPhoneNo(String var1) {
      this.phoneNo = var1;
   }

   public void setRandom(String var1) {
      this.random = var1;
   }

   public void setTerminalNo(String var1) {
      this.terminalNo = var1;
   }

   public void setUserName(String var1) {
      this.userName = var1;
   }
}
