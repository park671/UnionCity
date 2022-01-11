package com.extendsoft.nfcpayapp.model;


public class ShopConsumeReportQueryRequest {

   private String BeginDate;
   private String EndDate;
   private int PageSize;
   private int Position;
   private String ShopNo;
   private String TerminalNo;
   private String command = "Online.ShopConsumeReportQuery";


   public String getBeginDate() {
      return this.BeginDate;
   }

   public String getCommand() {
      return this.command;
   }

   public String getEndDate() {
      return this.EndDate;
   }

   public int getPageSize() {
      return this.PageSize;
   }

   public int getPosition() {
      return this.Position;
   }

   public String getShopNo() {
      return this.ShopNo;
   }

   public String getTerminalNo() {
      return this.TerminalNo;
   }

   public void setBeginDate(String var1) {
      this.BeginDate = var1;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setEndDate(String var1) {
      this.EndDate = var1;
   }

   public void setPageSize(int var1) {
      this.PageSize = var1;
   }

   public void setPosition(int var1) {
      this.Position = var1;
   }

   public void setShopNo(String var1) {
      this.ShopNo = var1;
   }

   public void setTerminalNo(String var1) {
      this.TerminalNo = var1;
   }
}
