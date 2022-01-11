package com.extendsoft.nfcpayapp.model;

import java.util.ArrayList;

public class PersonRechargeRecordQueryResponse {

   private ArrayList recordList = new ArrayList();
   private int totalCount;


   public ArrayList getRecordList() {
      return this.recordList;
   }

   public int getTotalCount() {
      return this.totalCount;
   }

   public void setRecordList(ArrayList var1) {
      this.recordList = var1;
   }

   public void setTotalCount(int var1) {
      this.totalCount = var1;
   }
}
