package com.extendsoft.nfcpayapp.model;

import java.util.Date;

public class CardRecord {

   private String cardNumber;
   private Date exchangeHour;
   private String money;
   private long number;
   private String shopNumber;
   private String sign;


   public String getCardNumber() {
      return this.cardNumber;
   }

   public Date getExchangeHour() {
      return this.exchangeHour;
   }

   public String getMoney() {
      return this.money;
   }

   public long getNumber() {
      return this.number;
   }

   public String getShopNumber() {
      return this.shopNumber;
   }

   public String getSign() {
      return this.sign;
   }

   public void setCardNumber(String var1) {
      this.cardNumber = var1;
   }

   public void setExchangeHour(Date var1) {
      this.exchangeHour = var1;
   }

   public void setMoney(String var1) {
      this.money = var1;
   }

   public void setNumber(long var1) {
      this.number = var1;
   }

   public void setShopNumber(String var1) {
      this.shopNumber = var1;
   }

   public void setSign(String var1) {
      this.sign = var1;
   }
}
