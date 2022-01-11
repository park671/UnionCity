package com.extendsoft.nfcpayapp.util;


public class ResponseCmd {

   private byte[] data;
   private byte[] lenght;
   private byte state;


   public ResponseCmd() {}

   public ResponseCmd(byte[] var1) {
      this.lenght[0] = var1[4];
      this.lenght[1] = var1[4];
      this.lenght[2] = var1[4];
      this.lenght[3] = var1[4];
   }

   public byte[] getData() {
      return this.data;
   }

   public byte[] getLenght() {
      return this.lenght;
   }

   public byte getState() {
      return this.state;
   }

   public void setData(byte[] var1) {
      this.data = var1;
   }

   public void setLenght(byte[] var1) {
      this.lenght = var1;
   }

   public void setState(byte var1) {
      this.state = var1;
   }
}
