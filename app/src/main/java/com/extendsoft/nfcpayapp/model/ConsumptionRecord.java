package com.extendsoft.nfcpayapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumptionRecord {

   private Date exchangeHour;
   private BigDecimal money;
   private long number;
   private String shopNumber;


   public Date getExchangeHour() {
      return this.exchangeHour;
   }

   public BigDecimal getMoney() {
      return this.money;
   }

   public long getNumber() {
      return this.number;
   }

   public String getShopNumber() {
      return this.shopNumber;
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

   public void setShopNumber(String var1) {
      this.shopNumber = var1;
   }
}
