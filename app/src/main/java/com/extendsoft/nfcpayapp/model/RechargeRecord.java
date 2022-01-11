package com.extendsoft.nfcpayapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeRecord {

   private String agent;
   private String cardNumber;
   private Date exchangeHour;
   private BigDecimal money;
   private long number;


   public String getAgent() {
      return this.agent;
   }

   public String getCardNumber() {
      return this.cardNumber;
   }

   public Date getExchangeHour() {
      return this.exchangeHour;
   }

   public BigDecimal getMoney() {
      return this.money;
   }

   public long getNumber() {
      return this.number;
   }

   public void setAgent(String var1) {
      this.agent = var1;
   }

   public void setCardNumber(String var1) {
      this.cardNumber = var1;
   }

   public void setExchangeHour(Date var1) {
      this.exchangeHour = var1;
   }

   public void setMoney(BigDecimal var1) {
      this.money = var1;
   }

   public void setNumber(long var1) {
      this.number = var1;
   }
}
