package com.extendsoft.nfcpayapp.network;

import android.util.Log;
import com.extendsoft.nfcpayapp.util.ByteHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public class SocketDataProcess {

   public static SocketDataProcess Instance = new SocketDataProcess();
   private static final String TAG = "SocketDataProcess";
   private byte[] data = new byte[1024];
   private InputStream inputStream;
   private BufferedReader reader;
   private Socket socket;
   public boolean state;
   private int timeoutCount = 600;


   private byte[] dealHead(byte[] var1) {
      byte[] var6 = new byte[var1.length - ByteHelper.countOf(var1, (byte)126)];
      int var4 = 0;

      int var3;
      for(int var2 = 0; var2 < var1.length; var4 = var3) {
         int var5;
         if(var1[var2] != 126) {
            var6[var4] = var1[var2];
            var3 = var4 + 1;
            var5 = var2;
         } else {
            var5 = var2;
            var3 = var4;
            if(var2 + 1 < var1.length) {
               var5 = var2 + 1;
               var6[var4] = (byte)(var1[var5] ^ 32);
               var3 = var4 + 1;
            }
         }

         var2 = var5 + 1;
      }

      return var6;
   }

   private void ensureConnected() {
      if(this.socket != null && this.socket.isClosed()) {
         this.stopConnect();
         this.socket = null;
      }

      if(this.socket == null || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
         this.socket = new Socket();
      }

      InetSocketAddress var1 = new InetSocketAddress("218.201.171.1", 10088);

      try {
         if(!this.socket.isConnected()) {
            this.socket.connect(var1, this.timeoutCount * 10);
         }

      } catch (IOException var2) {
         Log.v("SocketDataProcess", var2.getMessage());
      }
   }

   private void startConnect() {
      this.ensureConnected();
      this.state = true;
   }

   private int verifyState(byte[] var1) {
      var1 = (byte[])var1.clone();
      int var2 = ByteHelper.indexOf(var1, (byte)127, 1);
      if(var2 == -1 || var1.length >= 19) {
         if(var2 == 18) {
            return var1[9];
         }

         var1 = this.dealHead(Arrays.copyOf(var1, var2 + 1));
         if(var1.length == 19) {
            return var1[9];
         }
      }

      return -1;
   }

   public String BytesToHexString(byte[] var1) {
      return this.BytesToHexString(var1, 0, var1.length);
   }

   public String BytesToHexString(byte[] var1, int var2, int var3) {
      StringBuilder var5 = new StringBuilder(var1.length * 2);

      for(int var4 = 0; var4 < var3; ++var4) {
         String var6 = Integer.toHexString(var1[var4 + var2] & 255);
         if(var6.length() == 1) {
            var5.append("0");
         }

         var5.append(var6);
      }

      return var5.toString();
   }

   public byte[] HexStringToBytes(String var1) {
      byte[] var3 = new byte[var1.length() / 2];

      for(int var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = (byte)Integer.parseInt(var1.substring(var2 * 2, var2 * 2 + 2), 16);
      }

      return var3;
   }

   public String getData() {
      // $FF: Couldn't be decompiled
      return null;
   }

   public boolean isConnect() {
      return this.socket != null && this.socket.isConnected() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
   }

   public void sendDate(byte[] var1) {
      synchronized(this){}

      try {
         this.sendDate(var1, true);
      } finally {
         ;
      }

   }

   public void sendDate(byte[] param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void stopConnect() {
      if(this.socket != null) {
         try {
            this.socket.shutdownInput();
            this.socket.shutdownOutput();
            this.socket.close();
         } catch (IOException var2) {
            Log.v("SocketDataProcess", var2.getMessage());
         }
      }
   }
}
