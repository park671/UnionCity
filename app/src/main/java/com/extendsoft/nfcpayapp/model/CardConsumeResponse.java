package com.extendsoft.nfcpayapp.model;


public class CardConsumeResponse {

   private boolean hasResponse = true;
   private boolean isSuccess = true;
   private String mac2;
   private String tac;


   public boolean getHasResponse() {
      return this.hasResponse;
   }

   public boolean getIsSuccess() {
      return this.isSuccess;
   }

   public String getMac2() {
      return this.mac2;
   }

   public String getTac() {
      return this.tac;
   }

   public void setHasResponse(boolean var1) {
      this.hasResponse = var1;
   }

   public void setIsSuccess(boolean var1) {
      this.isSuccess = var1;
   }

   public void setMac2(String var1) {
      this.mac2 = var1;
   }

   public void setTac(String var1) {
      this.tac = var1;
   }
}
