package com.extendsoft.nfcpayapp.model;

import java.util.ArrayList;

public class ShopRechargeRecordQueryResponse {

   private ArrayList recordList = new ArrayList();
   private int totalCount;


   public ArrayList getRecordList() {
      return this.recordList;
   }

   public int getTotalCount() {
      return this.totalCount;
   }

   public void setTotalCount(int var1) {
      this.totalCount = var1;
   }
}
