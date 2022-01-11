package com.extendsoft.nfcpayapp.util;

import com.extendsoft.nfcpayapp.util.DigitalTrans;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

public class ByteHelper {

   private static String charset = "UTF8";


   public static byte BoolToByte(boolean var0) {
      byte var1;
      if(var0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return (byte)var1;
   }

   public static short Byte2ToInt16(byte var0, byte var1) {
      return (short)((var0 & 255) << 8 | var1 & 255);
   }

   public static short Byte2ToInt16(byte[] var0, int var1) {
      return Byte2ToInt16(var0[var1], var0[var1 + 1]);
   }

   public static int Byte2ToInt32(byte[] var0) {
      return Byte2ToInt16(var0, 0);
   }

   public static Integer Byte2ToUInt16(byte var0, byte var1) {
      return Integer.valueOf((var0 & 255) << 8 | var1 & 255);
   }

   public static Integer Byte2ToUInt16(byte[] var0, int var1) {
      return Byte2ToUInt16(var0[var1], var0[var1 + 1]);
   }

   public static float Byte4ToFloat(byte var0, byte var1, byte var2, byte var3) {
      return Float.intBitsToFloat(Byte4ToInt32(var0, var1, var2, var3).intValue());
   }

   public static float Byte4ToFloat(byte[] var0, int var1) {
      return Byte4ToFloat(var0[var1], var0[var1 + 1], var0[var1 + 2], var0[var1 + 3]);
   }

   public static int Byte4ToInt32(byte[] var0) {
      return Byte4ToInt32(var0, 0).intValue();
   }

   public static Integer Byte4ToInt32(byte var0, byte var1, byte var2, byte var3) {
      return Integer.valueOf((var0 & 255) << 24 | (var1 & 255) << 16 | (var2 & 255) << 8 | var3 & 255);
   }

   public static Integer Byte4ToInt32(byte[] var0, int var1) {
      return Byte4ToInt32(var0[var1], var0[var1 + 1], var0[var1 + 2], var0[var1 + 3]);
   }

   public static long Byte4ToUInt32(byte var0, byte var1, byte var2, byte var3) {
      return (long)Byte4ToInt32(var0, var1, var2, var3).intValue();
   }

   public static long Byte4ToUInt32(byte[] var0, int var1) {
      return Byte4ToUInt32(var0[var1], var0[var1 + 1], var0[var1 + 2], var0[var1 + 3]);
   }

   public static Long Byte8ToInt64(byte[] var0) {
      return var0 != null && var0.length >= 8?Long.valueOf(((long)var0[0] & 255L) << 56 | ((long)var0[1] & 255L) << 48 | ((long)var0[2] & 255L) << 40 | ((long)var0[3] & 255L) << 32 | ((long)var0[4] & 255L) << 24 | ((long)var0[5] & 255L) << 16 | ((long)var0[6] & 255L) << 8 | ((long)var0[7] & 255L) << 0):null;
   }

   public static String BytesToHexString(byte[] var0) {
      return BytesToHexString(var0, 0, var0.length);
   }

   public static String BytesToHexString(byte[] var0, int var1, int var2) {
      StringBuilder var4 = new StringBuilder(var0.length * 2);

      for(int var3 = 0; var3 < var2; ++var3) {
         String var5 = Integer.toHexString(var0[var3 + var1] & 255);
         if(var5.length() == 1) {
            var4.append("0");
         }

         var4.append(var5);
      }

      return var4.toString();
   }

   public static String BytesToString(byte[] var0) {
      return BytesToString(var0, 0);
   }

   public static String BytesToString(byte[] var0, int var1) {
      return BytesToString(var0, var1, var0.length - var1);
   }

   public static String BytesToString(byte[] var0, int var1, int var2) {
      var0 = ArrayUtils.subarray(var0, var1, var1 + var2);

      try {
         String var4 = StringUtils.newString(var0, charset);
         return var4;
      } catch (IllegalStateException var3) {
         throw var3;
      }
   }

   public static int FillBase64(String var0, byte[] var1, int var2) throws UnsupportedEncodingException {
      return FillBase64(var0, var1, var2, 0);
   }

   public static int FillBase64(String var0, byte[] var1, int var2, int var3) throws UnsupportedEncodingException {
      int var4 = 0;
      if(var0 != null) {
         byte[] var6 = StringToBytes(var0);

         for(var4 = 0; var4 < var6.length; ++var4) {
            var1[var2 + var4] = var6[var4];
         }

         var4 = var6.length;
      }

      for(int var5 = var4; var5 < var3; ++var5) {
         var1[var2 + var5] = 0;
      }

      return var4 > var3?var4:var3;
   }

   public static void FloatToByte4(float var0, byte[] var1, int var2) {
      byte[] var4 = FloatToByte4(var0);

      for(int var3 = 0; var3 < 4; ++var3) {
         var1[var3 + var2] = var4[var3];
      }

   }

   public static byte[] FloatToByte4(float var0) {
      return IntToByte4(Integer.valueOf(Float.floatToIntBits(var0)));
   }

   public static byte[] HexStringToBytes(String var0) {
      byte[] var2 = new byte[var0.length() / 2];

      for(int var1 = 0; var1 < var2.length; ++var1) {
         var2[var1] = (byte)Integer.parseInt(var0.substring(var1 * 2, var1 * 2 + 2), 16);
      }

      return var2;
   }

   public static void Int16ToByte2(Short var0, byte[] var1, int var2) {
      byte[] var4 = Int16ToByte2(var0);

      for(int var3 = 0; var3 < 2; ++var3) {
         var1[var3 + var2] = var4[var3];
      }

   }

   public static byte[] Int16ToByte2(Short var0) {
      return new byte[]{(byte)(var0.shortValue() >> 8 & 255), (byte)(var0.shortValue() & 255)};
   }

   public static byte[] Int32ToByte2(Integer var0) {
      return Int16ToByte2(Short.valueOf(var0.shortValue()));
   }

   public static byte[] Int32ToByte4(Integer var0) {
      return IntToByte4(var0);
   }

   public static byte[] Int64ToByte8(Long var0) {
      return var0 == null?null:new byte[]{(byte)((int)(var0.longValue() >> 56)), (byte)((int)(var0.longValue() >> 48)), (byte)((int)(var0.longValue() >> 40)), (byte)((int)(var0.longValue() >> 32)), (byte)((int)(var0.longValue() >> 24)), (byte)((int)(var0.longValue() >> 16)), (byte)((int)(var0.longValue() >> 8)), (byte)((int)(var0.longValue() >> 0))};
   }

   public static void IntToByte4(Integer var0, byte[] var1, int var2) {
      byte[] var4 = IntToByte4(var0);

      for(int var3 = 0; var3 < 4; ++var3) {
         var1[var3 + var2] = var4[var3];
      }

   }

   public static byte[] IntToByte4(Integer var0) {
      return new byte[]{(byte)((-16777216 & var0.intValue()) >> 24), (byte)((16711680 & var0.intValue()) >> 16), (byte)(('\uff00' & var0.intValue()) >> 8), (byte)(var0.intValue() & 255)};
   }

   public static short ReversalByte2ToInt16(byte var0, byte var1) {
      return (short)(var0 << 8 | var1);
   }

   public static short ReversalByte2ToInt16(byte[] var0, int var1) {
      return ReversalByte2ToInt16(var0[var1 + 1], var0[var1]);
   }

   public static byte[] StringToBytes(String var0) {
      try {
         byte[] var2 = StringUtils.getBytesUnchecked(var0, charset);
         return var2;
      } catch (IllegalStateException var1) {
         throw var1;
      }
   }

   public static void UInt16ToByte2(Integer var0, byte[] var1, int var2) {
      byte[] var4 = UInt16ToByte2(var0);

      for(int var3 = 0; var3 < 2; ++var3) {
         var1[var3 + var2] = var4[var3];
      }

   }

   public static byte[] UInt16ToByte2(Integer var0) {
      return new byte[]{(byte)(('\uff00' & var0.intValue()) >> 8), (byte)(var0.intValue() & 255)};
   }

   public static void UIntToByte4(Long var0, byte[] var1, int var2) {
      byte[] var4 = UIntToByte4(var0);

      for(int var3 = 0; var3 < 4; ++var3) {
         var1[var3 + var2] = var4[var3];
      }

   }

   public static byte[] UIntToByte4(Long var0) {
      return new byte[]{(byte)((int)((4278190080L & var0.longValue()) >> 24)), (byte)((int)((16711680L & var0.longValue()) >> 16)), (byte)((int)((65280L & var0.longValue()) >> 8)), (byte)((int)(255L & var0.longValue()))};
   }

   public static int countOf(byte[] var0, byte var1) {
      int var3 = 0;
      int var5 = var0.length;

      int var4;
      for(int var2 = 0; var2 < var5; var3 = var4) {
         var4 = var3;
         if(var0[var2] == var1) {
            var4 = var3 + 1;
         }

         ++var2;
      }

      return var3;
   }

   public static String hexStringToString(String var0, int var1) {
      String var5 = "";
      int var4 = var0.length() / var1;

      for(int var3 = 0; var3 < var4; ++var3) {
         char var2 = (char)DigitalTrans.hexStringToAlgorism(var0.substring(var3 * var1, (var3 + 1) * var1));
         var5 = var5 + var2;
      }

      return var5;
   }

   public static int indexOf(byte[] var0, byte var1, int var2) {
      int var4 = 1;

      int var5;
      for(int var3 = 0; var3 < var0.length; var4 = var5) {
         var5 = var4;
         if(var0[var3] == var1) {
            if(var4 > var2) {
               return var3;
            }

            var5 = var4 + 1;
         }

         ++var3;
      }

      return -1;
   }

   public static String read(InputStream var0) throws Exception {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      byte[] var3 = new byte[1024];

      while(true) {
         int var1 = var0.read(var3);
         if(var1 == -1) {
            var3 = var2.toByteArray();
            var2.close();
            var0.close();
            return BytesToString(var3);
         }

         var2.write(var3, 0, var1);
      }
   }

   public static void save(OutputStream var0, String var1) throws Exception {
      var0.write(StringToBytes(var1));
      var0.flush();
      var0.close();
   }
}
