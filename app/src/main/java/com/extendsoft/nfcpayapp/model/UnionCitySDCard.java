package com.extendsoft.nfcpayapp.model;

import com.extendsoft.nfcpayapp.model.CardRecord;
import java.util.ArrayList;
import java.util.Iterator;

public class UnionCitySDCard {

   private String cardBalance;
   private String cardNumber;
   private final ArrayList cardRecords = new ArrayList();
   private String cardType;
   private String city;


   public String getCardBalance() {
      return this.cardBalance;
   }

   public String getCardNumber() {
      return this.cardNumber;
   }

   public ArrayList getCardRecords() {
      return this.cardRecords;
   }

   public String getCardType() {
      return this.cardType;
   }

   public String getCity() {
      return this.city;
   }

   public ArrayList getConsumptionRecords() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.cardRecords.iterator();

      while(var2.hasNext()) {
         CardRecord var3 = (CardRecord)var2.next();
         if(var3.getSign() == "-") {
            var1.add(var3);
         }
      }

      return var1;
   }

   public ArrayList getRechargeRecords() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.cardRecords.iterator();

      while(var2.hasNext()) {
         CardRecord var3 = (CardRecord)var2.next();
         if(var3.getSign() == "+") {
            var1.add(var3);
         }
      }

      return var1;
   }

   public void setCardBalance(String var1) {
      this.cardBalance = var1;
   }

   public void setCardNumber(String var1) {
      this.cardNumber = var1;
   }

   public void setCardType(String var1) {
      this.cardType = var1;
   }

   public void setCity(String var1) {
      this.city = var1;
   }
}
