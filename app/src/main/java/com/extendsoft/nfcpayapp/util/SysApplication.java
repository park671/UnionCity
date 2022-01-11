package com.extendsoft.nfcpayapp.util;

import android.app.Activity;
import android.app.Application;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class SysApplication extends Application {

   private static final String TAG = "SysApplication";
   public static final String dbPath = "/storage/emulated/0/Android/data/com.extendsoft.nfcpayapp/database/nfcpayapp.db";
   public static final String dir = "/storage/emulated/0";
   private static SysApplication instance;
   private List mlist = new LinkedList();


   public static void createDir() {
      File var0 = new File("/storage/emulated/0/Android");
      if(!var0.exists()) {
         var0.mkdir();
      }

      var0 = new File("/storage/emulated/0/Android/data");
      if(!var0.exists()) {
         var0.mkdir();
      }

      var0 = new File("/storage/emulated/0/Android/data/com.extendsoft.nfcpayapp");
      if(!var0.exists()) {
         var0.mkdir();
      }

      var0 = new File("/storage/emulated/0/Android/data/com.extendsoft.nfcpayapp/database");
      if(!var0.exists()) {
         var0.mkdir();
      }

   }


   public static SysApplication getinstance() {
      synchronized(SysApplication.class){}

      SysApplication var0;
      try {
         if(instance == null) {
            instance = new SysApplication();
            createDir();
         }

         var0 = instance;
      } finally {
         ;
      }

      return var0;
   }

   public void addActivity(Activity var1) {
      this.mlist.add(var1);
   }

   public void exit() {
      // $FF: Couldn't be decompiled
   }

   public void onCreate() {
      super.onCreate();
   }

   public void onLowMemory() {
      super.onLowMemory();
      System.gc();
   }

   public int totalActivity() {
      return this.mlist.size();
   }
}
