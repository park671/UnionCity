package com.extendsoft.nfcpayapp.model;

import java.io.Serializable;

public class TipBundle implements Serializable {

   private String activityName;
   private String balance;
   private boolean isLock;
   private String message;
   private int money;
   private int task;
   private String transactionSerialNo;


   public String getActivityName() {
      return this.activityName;
   }

   public String getBalance() {
      return this.balance;
   }

   public String getMessage() {
      return this.message;
   }

   public int getMoney() {
      return this.money;
   }

   public int getTask() {
      return this.task;
   }

   public String getTransactionSerialNo() {
      return this.transactionSerialNo;
   }

   public boolean isLock() {
      return this.isLock;
   }

   public void setActivityName(String var1) {
      this.activityName = var1;
   }

   public void setBalance(String var1) {
      this.balance = var1;
   }

   public void setLock(boolean var1) {
      this.isLock = var1;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void setMoney(int var1) {
      this.money = var1;
   }

   public void setTask(int var1) {
      this.task = var1;
   }

   public void setTransactionSerialNo(String var1) {
      this.transactionSerialNo = var1;
   }
}
