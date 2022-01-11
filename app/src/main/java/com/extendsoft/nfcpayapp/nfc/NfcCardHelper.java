package com.extendsoft.nfcpayapp.nfc;

import android.content.IntentFilter;
import android.nfc.tech.IsoDep;

public class NfcCardHelper {

   public static final byte[] ERROR;
   public static IntentFilter[] FILTERS;
   public static String[][] TECH_LISTS;


   static {
      byte[] var0 = new byte[]{(byte)111, (byte)0};
      ERROR = var0;

      try {
         TECH_LISTS = new String[][]{{IsoDep.class.getName()}};
         FILTERS = new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*")};
      } catch (Exception var1) {
         ;
      }
   }

}
