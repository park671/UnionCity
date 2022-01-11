package com.extendsoft.nfcpayapp.model;

import com.extendsoft.nfcpayapp.model.ConsumptionRecord;
import com.extendsoft.nfcpayapp.model.PublicServicePaymentRecord;
import com.extendsoft.nfcpayapp.model.RechargeRecord;
import com.extendsoft.nfcpayapp.model.SelfRechargeRecord;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DemoDataProvider {

   private static final int default_size = 5;


   public static ArrayList getConsumptionRecord() {
      ArrayList var1 = new ArrayList();

      for(int var0 = 0; var0 < 5; ++var0) {
         ConsumptionRecord var2 = new ConsumptionRecord();
         var2.setNumber((long)(var0 + 1));
         Calendar var3 = Calendar.getInstance();
         var3.setTime(new Date());
         var3.add(10, var0 * -24);
         var2.setExchangeHour(var3.getTime());
         var2.setShopNumber("0085");
         var2.setMoney(new BigDecimal(200));
         var1.add(var2);
      }

      return var1;
   }

   public static ArrayList getPublicServicePaymentRecord() {
      ArrayList var1 = new ArrayList();

      for(int var0 = 0; var0 < 5; ++var0) {
         PublicServicePaymentRecord var2 = new PublicServicePaymentRecord();
         var2.setNumber((long)(var0 + 1));
         Calendar var3 = Calendar.getInstance();
         var3.setTime(new Date());
         var3.add(10, var0 * -24);
         var2.setExchangeHour(var3.getTime());
         var2.setType("电费");
         var2.setMoney(new BigDecimal(200));
         var1.add(var2);
      }

      return var1;
   }

   public static ArrayList getRechargeRecord() {
      ArrayList var1 = new ArrayList();

      for(int var0 = 0; var0 < 5; ++var0) {
         RechargeRecord var2 = new RechargeRecord();
         var2.setNumber((long)(var0 + 1));
         Calendar var3 = Calendar.getInstance();
         var3.setTime(new Date());
         var3.add(10, var0 * -24);
         var2.setExchangeHour(var3.getTime());
         var2.setCardNumber("0085");
         var2.setMoney(new BigDecimal(200));
         var2.setAgent("新华路");
         var1.add(var2);
      }

      return var1;
   }

   public static ArrayList getSelfRechargeRecord() {
      ArrayList var1 = new ArrayList();

      for(int var0 = 0; var0 < 5; ++var0) {
         SelfRechargeRecord var2 = new SelfRechargeRecord();
         var2.setNumber((long)(var0 + 1));
         Calendar var3 = Calendar.getInstance();
         var3.setTime(new Date());
         var3.add(10, var0 * -24);
         var2.setExchangeHour(var3.getTime());
         var2.setCardNumber("0085");
         var2.setMoney(new BigDecimal(200));
         var1.add(var2);
      }

      return var1;
   }
}
