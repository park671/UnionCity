package com.extendsoft.nfcpayapp.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesKeeper {

   public static final String ADDRESS = "address";
   public static final String CARDTOTALRECHARGESUM = "cardTotalRechargeSum";
   public static final String HOSTPHONE = "hostPhone";
   public static final String IS_Personal = "is_personal";
   public static final String NAME = "data";
   public static final String PASSWORD = "password";
   public static final String PHONE = "phone";
   public static final String RECHARGEFEE = "rechargeFee";
   public static final String REPUTATIONQUOTA = "reputationQuota";
   public static final String SHOPCARDTOTALRECHARGESUM = "shopcardTotalRechargeSum";
   public static final String SHOPNAME = "shopName";
   public static final String SHOPNO = "shopNo";
   public static final String SHOPRECHARGELOWERLIMIT = "shoprechargelowerlimit";
   public static final String SHOPRECHARGEUPPERLIMIT = "shoprechargeupperlimit";
   public static final String TERMINALNO = "terminalNo";
   public static final String USERRECHARGELOWERLIMIT = "rechargelowerlimit";
   public static final String USERRECHARGEUPPERLIMIT = "rechargeupperlimit";
   public static final String USER_PASSWORD = "passWord";
   public static final String USER_PHONENO = "phoneNo";


   public static void clear(Context var0) {
      Editor var1 = var0.getSharedPreferences("data", '\u8000').edit();
      var1.clear();
      var1.commit();
   }

   public static void keepIsPersonal(Context var0, boolean var1) {
      Editor var2 = var0.getSharedPreferences("data", '\u8000').edit();
      var2.putBoolean("is_personal", var1);
      var2.commit();
   }

   public static void keepReputationQuota(Context var0, int var1) {
      Editor var2 = var0.getSharedPreferences("data", '\u8000').edit();
      var2.putInt("reputationQuota", var1);
      var2.commit();
   }

   public static void keepShop(Context var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, int var9, int var10) {
      Editor var11 = var0.getSharedPreferences("data", '\u8000').edit();
      var11.putString("shopNo", var1);
      var11.putString("shopName", var2);
      var11.putString("phone", var3);
      var11.putString("hostPhone", var4);
      var11.putString("address", var5);
      var11.putString("terminalNo", var6);
      var11.putString("password", var7);
      var11.putInt("shoprechargelowerlimit", var8);
      var11.putInt("shoprechargeupperlimit", var9);
      var11.putInt("shopcardTotalRechargeSum", var10);
      var11.commit();
   }

   public static void keepUser(Context var0, String var1, String var2, int var3, int var4, int var5, int var6) {
      Editor var7 = var0.getSharedPreferences("data", '\u8000').edit();
      var7.putString("phoneNo", var1);
      var7.putString("passWord", var2);
      var7.putInt("rechargeFee", var3);
      var7.putInt("rechargelowerlimit", var4);
      var7.putInt("rechargeupperlimit", var5);
      var7.putInt("cardTotalRechargeSum", var6);
      var7.commit();
   }

   public static String readAddress(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("address", "");
   }

   public static int readCardTotalRechargeSum(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("cardTotalRechargeSum", 0);
   }

   public static String readHostPhone(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("hostPhone", "");
   }

   public static boolean readIsPersonal(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getBoolean("is_personal", true);
   }

   public static String readPhone(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("phone", "");
   }

   public static String readPhoneNo(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("phoneNo", "");
   }

   public static int readRechargefee(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("rechargeFee", 0);
   }

   public static int readReputationQuota(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("reputationQuota", 0);
   }

   public static int readShopCardTotalRechargeSum(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("shopcardTotalRechargeSum", 0);
   }

   public static String readShopName(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("shopName", "");
   }

   public static String readShopNo(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getString("shopNo", "");
   }

   public static int readShopRechargeLowerLimit(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("shoprechargelowerlimit", 0);
   }

   public static int readShopRechargeUpperLimit(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("shoprechargeupperlimit", 100000);
   }

   public static int readUserRechargeLowerLimit(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("rechargelowerlimit", 0);
   }

   public static int readUserRechargeUpperLimit(Context var0) {
      return var0.getSharedPreferences("data", '\u8000').getInt("rechargeupperlimit", 0);
   }
}
