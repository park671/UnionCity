package com.extendsoft.nfcpayapp.util;


public class DigitalTrans {

   public static String AsciiStringToString(String var0) {
      String var4 = "";
      int var3 = var0.length() / 2;

      for(int var2 = 0; var2 < var3; ++var2) {
         char var1 = (char)hexStringToAlgorism(var0.substring(var2 * 2, var2 * 2 + 2));
         var4 = var4 + String.valueOf(var1);
      }

      return var4;
   }

   public static String StringToAsciiString(String var0) {
      String var3 = "";
      int var2 = var0.length();

      for(int var1 = 0; var1 < var2; ++var1) {
         String var4 = Integer.toHexString(var0.charAt(var1));
         var3 = var3 + var4;
      }

      return var3;
   }

   public static String algorismToHEXString(int var0) {
      String var2 = Integer.toHexString(var0);
      String var1 = var2;
      if(var2.length() % 2 == 1) {
         var1 = "0" + var2;
      }

      return var1.toUpperCase();
   }

   public static String algorismToHEXString(int var0, int var1) {
      String var3 = Integer.toHexString(var0);
      String var2 = var3;
      if(var3.length() % 2 == 1) {
         var2 = "0" + var3;
      }

      return patchHexString(var2.toUpperCase(), var1);
   }

   public static int binaryToAlgorism(String var0) {
      int var3 = var0.length();
      int var2 = 0;

      for(int var1 = var3; var1 > 0; --var1) {
         char var4 = var0.charAt(var1 - 1);
         var2 = (int)((double)var2 + Math.pow(2.0D, (double)(var3 - var1)) * (double)(var4 - 48));
      }

      return var2;
   }

   public static final String byte2hex(byte[] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
      } else {
         String var2 = "";

         for(int var1 = 0; var1 < var0.length; ++var1) {
            String var3 = Integer.toHexString(var0[var1] & 255);
            if(var3.length() == 1) {
               var2 = var2 + "0" + var3;
            } else {
               var2 = var2 + var3;
            }
         }

         return var2.toUpperCase();
      }
   }

   public static String bytetoString(byte[] var0) {
      String var4 = "";
      int var3 = var0.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         char var1 = (char)var0[var2];
         var4 = var4 + var1;
      }

      return var4;
   }

   public static final byte[] hex2byte(String var0) throws IllegalArgumentException {
      if(var0.length() % 2 != 0) {
         throw new IllegalArgumentException();
      } else {
         char[] var5 = var0.toCharArray();
         byte[] var6 = new byte[var0.length() / 2];
         int var2 = 0;
         int var3 = var0.length();

         int var4;
         for(int var1 = 0; var1 < var3; var1 = var4 + 1) {
            StringBuilder var7 = new StringBuilder();
            var4 = var1 + 1;
            var6[var2] = (new Integer(Integer.parseInt(var7.append(var5[var1]).append(var5[var4]).toString(), 16) & 255)).byteValue();
            ++var2;
         }

         return var6;
      }
   }

   public static int hexStringToAlgorism(String var0) {
      var0 = var0.toUpperCase();
      int var4 = var0.length();
      int var2 = 0;

      for(int var1 = var4; var1 > 0; --var1) {
         char var3 = var0.charAt(var1 - 1);
         int var5;
         if(var3 >= 48 && var3 <= 57) {
            var5 = var3 - 48;
         } else {
            var5 = var3 - 55;
         }

         var2 = (int)((double)var2 + Math.pow(16.0D, (double)(var4 - var1)) * (double)var5);
      }

      return var2;
   }

   public static String hexStringToBinary(String var0) {
      String var4 = var0.toUpperCase();
      String var3 = "";
      int var2 = var4.length();

      for(int var1 = 0; var1 < var2; var3 = var0) {
         var0 = var3;
         switch(var4.charAt(var1)) {
         case 48:
            var0 = var3 + "0000";
            break;
         case 49:
            var0 = var3 + "0001";
            break;
         case 50:
            var0 = var3 + "0010";
            break;
         case 51:
            var0 = var3 + "0011";
            break;
         case 52:
            var0 = var3 + "0100";
            break;
         case 53:
            var0 = var3 + "0101";
            break;
         case 54:
            var0 = var3 + "0110";
            break;
         case 55:
            var0 = var3 + "0111";
            break;
         case 56:
            var0 = var3 + "1000";
            break;
         case 57:
            var0 = var3 + "1001";
         case 58:
         case 59:
         case 60:
         case 61:
         case 62:
         case 63:
         case 64:
            break;
         case 65:
            var0 = var3 + "1010";
            break;
         case 66:
            var0 = var3 + "1011";
            break;
         case 67:
            var0 = var3 + "1100";
            break;
         case 68:
            var0 = var3 + "1101";
            break;
         case 69:
            var0 = var3 + "1110";
            break;
         case 70:
            var0 = var3 + "1111";
            break;
         default:
            var0 = var3;
         }

         ++var1;
      }

      return var3;
   }

   public static byte[] hexStringToByte(String var0) {
      int var2 = var0.length() / 2;
      byte[] var3 = new byte[var2];
      var0 = hexStringToBinary(var0);

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1] = (byte)binaryToAlgorism(var0.substring(var1 * 8 + 1, (var1 + 1) * 8));
         if(var0.charAt(var1 * 8) == 49) {
            var3[var1] = (byte)(0 - var3[var1]);
         }
      }

      return var3;
   }

   public static String hexStringToString(String var0, int var1) {
      String var5 = "";
      int var4 = var0.length() / var1;

      for(int var3 = 0; var3 < var4; ++var3) {
         char var2 = (char)hexStringToAlgorism(var0.substring(var3 * var1, (var3 + 1) * var1));
         var5 = var5 + var2;
      }

      return var5;
   }

   public static int parseToInt(String var0, int var1) {
      try {
         int var2 = Integer.parseInt(var0);
         return var2;
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static int parseToInt(String var0, int var1, int var2) {
      try {
         var2 = Integer.parseInt(var0, var2);
         return var2;
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static String patchHexString(String var0, int var1) {
      String var3 = "";

      for(int var2 = 0; var2 < var1 - var0.length(); ++var2) {
         var3 = "0" + var3;
      }

      return (var3 + var0).substring(0, var1);
   }
}
