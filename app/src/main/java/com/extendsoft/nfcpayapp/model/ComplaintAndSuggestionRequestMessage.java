package com.extendsoft.nfcpayapp.model;


public class ComplaintAndSuggestionRequestMessage {

   private String ComplaintAndSuggestion;
   private String Mail;
   private String No;
   private int Type;
   private String command = "Online. ComplaintAndSuggestion";


   public String getCommand() {
      return this.command;
   }

   public String getComplaintAndSuggestion() {
      return this.ComplaintAndSuggestion;
   }

   public String getMail() {
      return this.Mail;
   }

   public String getNo() {
      return this.No;
   }

   public int getType() {
      return this.Type;
   }

   public void setCommand(String var1) {
      this.command = var1;
   }

   public void setComplaintAndSuggestion(String var1) {
      this.ComplaintAndSuggestion = var1;
   }

   public void setMail(String var1) {
      this.Mail = var1;
   }

   public void setNo(String var1) {
      this.No = var1;
   }

   public void setType(int var1) {
      this.Type = var1;
   }
}
