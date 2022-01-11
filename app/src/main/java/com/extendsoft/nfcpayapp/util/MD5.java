package com.extendsoft.nfcpayapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

   private static final String[] strDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


   public static String GetMD5Code(String dataStr) {
      try {
         MessageDigest m = MessageDigest.getInstance("MD5");
         m.update(dataStr.getBytes("UTF8"));
         byte s[] = m.digest();
         String result = "";
         for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
         }
         return result;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return "";
   }

   private static String byteToArrayString(byte var0) {
      byte var1 = var0;
      int var2 = var0;
      if(var1 < 0) {
         var2 = var1 + 256;
      }

      int var3 = var2 / 16;
      return strDigits[var3] + strDigits[var2 % 16];
   }

   private static String byteToString(byte[] var0) {
      StringBuffer var2 = new StringBuffer();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.append(byteToArrayString(var0[var1]));
      }

      return var2.toString();
   }
}
