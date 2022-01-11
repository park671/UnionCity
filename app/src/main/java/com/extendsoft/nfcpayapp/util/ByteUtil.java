package com.extendsoft.nfcpayapp.util;


public final class ByteUtil {

   private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


   public static byte[] hex2bytes(String var0) {
      int var2 = var0.length() / 2;
      byte[] var3 = new byte[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1] = (byte)Integer.parseInt(var0.substring(var1 * 2, (var1 + 1) * 2), 16);
      }

      return var3;
   }

   public static int parseInt(String var0, int var1, int var2) {
      try {
         var1 = Integer.valueOf(var0, var1).intValue();
         return var1;
      } catch (Exception var3) {
         return var2;
      }
   }

   public static byte[] str2byte(String var0) {
      int var2 = var0.length() / 2;
      byte[] var3 = new byte[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1] = Byte.parseByte(var0.substring(var1 * 2, (var1 + 1) * 2));
      }

      return var3;
   }

   public static String toAmountString(float var0) {
      return String.format("%.2f", new Object[]{Float.valueOf(var0)});
   }

   public static byte[] toBytes(int var0) {
      return new byte[]{(byte)(var0 >>> 24 & 255), (byte)(var0 >>> 16 & 255), (byte)(var0 >>> 8 & 255), (byte)(var0 & 255)};
   }

   public static String toHexString(byte[] data, int offset, int length) {
      char[] var7 = new char[length * 2];
      int var3 = offset;

      for(int var4 = 0; var3 < offset + length; ++var3) {
         byte var5 = data[var3];
         int var6 = var4 + 1;
         var7[var4] = HEX[var5 >> 4 & 15];
         var4 = var6 + 1;
         var7[var6] = HEX[var5 & 15];
      }

      return new String(var7);
   }

   public static String toHexStringR(byte[] var0, int var1, int var2) {
      char[] var6 = new char[var2 * 2];
      var2 = var1 + var2 - 1;

      for(int var3 = 0; var2 >= var1; --var2) {
         byte var4 = var0[var2];
         int var5 = var3 + 1;
         var6[var3] = HEX[var4 >> 4 & 15];
         var3 = var5 + 1;
         var6[var5] = HEX[var4 & 15];
      }

      return new String(var6);
   }

   public static int toInt(byte ... var0) {
      int var2 = 0;
      int var3 = var0.length;

      for(int var1 = 0; var1 < var3; ++var1) {
         var2 = var2 << 8 | var0[var1] & 255;
      }

      return var2;
   }

   public static int toInt(byte[] var0, int var1, int var2) {
      int var4 = 0;

      for(int var3 = var1; var3 < var1 + var2; ++var3) {
         var4 = var4 << 8 | var0[var3] & 255;
      }

      return var4;
   }

   public static int toIntR(byte[] var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var1 >= 0 && var2 > 0; --var2) {
         var3 = var3 << 8 | var0[var1] & 255;
         --var1;
      }

      return var3;
   }
}
