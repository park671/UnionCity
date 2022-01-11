package com.extendsoft.nfcpayapp.model;

import com.extendsoft.nfcpayapp.model.ConsumptionApplyRequestMessage;
import java.io.Serializable;

public class ConsumptionSubmitRequestMessage implements Serializable {

   private String CardDealNo;
   private String CardNo;
   private String CardType;
   private String CityCode;
   private int DealNum;
   private String DealTime;
   private String MAC2;
   private String PhoneNo;
   private String ShopNo;
   private String TAC;
   private int TerminalDealNo;
   private String TerminalNo;
   private String WriteCardStatus;
   private String command;


   public ConsumptionSubmitRequestMessage() {
      this.command = "Online.ShopConsumeCommit";
   }

   public ConsumptionSubmitRequestMessage(ConsumptionApplyRequestMessage var1) {
      if(var1 != null) {
         this.command = "Online.ShopConsumeCommit";
         this.ShopNo = var1.getShopNo();
         this.PhoneNo = var1.getPhoneNo();
         this.CityCode = var1.getCityCode();
         this.CardNo = var1.getCardNo();
         this.CardType = var1.getCardType();
         this.TerminalNo = var1.getTerminalNo();
         this.DealNum = var1.getDealNum();
         this.CardDealNo = var1.getCardDealNo();
         this.DealTime = var1.getDealTime();
      }
   }

   public ConsumptionSubmitRequestMessage(String var1, String var2, String var3, String var4, String var5, String var6, int var7, String var8, int var9, String var10, String var11, String var12, String var13) {
      this.ShopNo = var1;
      this.PhoneNo = var2;
      this.CityCode = var3;
      this.CardNo = var4;
      this.CardType = var5;
      this.TerminalNo = var6;
      this.DealNum = var7;
      this.CardDealNo = var8;
      this.TerminalDealNo = var9;
      this.DealTime = var10;
      this.WriteCardStatus = var11;
      this.TAC = var12;
      this.MAC2 = var13;
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

   public String getMAC2() {
      return this.MAC2;
   }

   public String getPhoneNo() {
      return this.PhoneNo;
   }

   public String getShopNo() {
      return this.ShopNo;
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

   public void setMAC2(String var1) {
      this.MAC2 = var1;
   }

   public void setPhoneNo(String var1) {
      this.PhoneNo = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
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

   public void setWriteCardStatus(String var1) {
      this.WriteCardStatus = var1;
   }
}
