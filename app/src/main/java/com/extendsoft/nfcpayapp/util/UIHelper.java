package com.extendsoft.nfcpayapp.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class UIHelper {

   private static long lastClickTime;


   public static void clearCheck(LinearLayout var0, View var1) {
      for(int var2 = 0; var2 < var0.getChildCount(); ++var2) {
         View var4 = var0.getChildAt(var2);
         if(var4 instanceof LinearLayout) {
            LinearLayout var6 = (LinearLayout)var4;

            for(int var3 = 0; var3 < var6.getChildCount(); ++var3) {
               View var5 = var6.getChildAt(var3);
               if(var5 instanceof CheckBox && (var1 == null || !var5.equals(var1))) {
                  ((CheckBox)var5).setChecked(false);
               }
            }
         }
      }

   }

   public static CheckBox getCheckedCheckBox(LinearLayout var0) {
      for(int var1 = 0; var1 < var0.getChildCount(); ++var1) {
         View var3 = var0.getChildAt(var1);
         if(var3 instanceof LinearLayout) {
            LinearLayout var5 = (LinearLayout)var3;

            for(int var2 = 0; var2 < var5.getChildCount(); ++var2) {
               View var4 = var5.getChildAt(var2);
               if(var4 instanceof CheckBox && ((CheckBox)var4).isChecked()) {
                  return (CheckBox)var4;
               }
            }
         }
      }

      return null;
   }

   public static boolean isChecked(LinearLayout var0) {
      for(int var1 = 0; var1 < var0.getChildCount(); ++var1) {
         View var3 = var0.getChildAt(var1);
         if(var3 instanceof LinearLayout) {
            LinearLayout var5 = (LinearLayout)var3;

            for(int var2 = 0; var2 < var5.getChildCount(); ++var2) {
               View var4 = var5.getChildAt(var2);
               if(var4 instanceof CheckBox && ((CheckBox)var4).isChecked()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean isFastDoubleClick() {
      long var0 = System.currentTimeMillis();
      if(var0 - lastClickTime < 1000L) {
         return true;
      } else {
         lastClickTime = var0;
         return false;
      }
   }

   public static void setEnableOfCheckBox(LinearLayout var0, boolean var1) {
      for(int var2 = 0; var2 < var0.getChildCount(); ++var2) {
         View var4 = var0.getChildAt(var2);
         if(var4 instanceof LinearLayout) {
            LinearLayout var6 = (LinearLayout)var4;

            for(int var3 = 0; var3 < var6.getChildCount(); ++var3) {
               View var5 = var6.getChildAt(var3);
               if(var5 instanceof CheckBox) {
                  var5.setEnabled(var1);
               }
            }
         }
      }

   }
}
