package com.extendsoft.nfcpayapp.model;

import com.extendsoft.nfcpayapp.util.ByteHelper;
import java.nio.ByteBuffer;

public class ServerRequest {

   private static final byte INSERT_BYTE = 126;
   private static final byte TRANSFER_BYTE_7E = 126;
   private static final byte TRANSFER_BYTE_7F = 127;
   private final byte[] body;
   private final byte[] head;


   public ServerRequest(byte[] var1) {
      this.body = var1;
      var1 = this.transferrBytes(ByteHelper.Int32ToByte4(Integer.valueOf(var1.length)));
      ByteBuffer var2 = ByteBuffer.allocate(var1.length + 15);
      var2.put((byte)127).put((byte)74).put((byte)0).put((byte)0).put(var1).put((byte)82).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)0).put((byte)127);
      this.head = var2.array();
   }

   private byte[] transferrBytes(byte[] var1) {
      int var2 = ByteHelper.countOf(var1, (byte)126) + ByteHelper.countOf(var1, (byte)127);
      if(var2 == 0) {
         return var1;
      } else {
         byte[] var6 = new byte[var1.length + var2];
         int var4 = 0;

         for(int var3 = 0; var3 < var1.length; var4 = var2) {
            if(var1[var3] != 126 && var1[var3] != 127) {
               var6[var4] = var1[var3];
               var2 = var4 + 1;
            } else {
               var2 = var4;
               if(var4 + 1 < var6.length) {
                  int var5 = var4 + 1;
                  var6[var4] = 126;
                  var2 = var5 + 1;
                  var6[var5] = (byte)(var1[var3] ^ 32);
               }
            }

            ++var3;
         }

         return var6;
      }
   }

   public byte[] buildRequest() {
      byte[] var1 = new byte[this.body.length + this.head.length];
      System.arraycopy(this.head, 0, var1, 0, this.head.length);
      System.arraycopy(this.body, 0, var1, this.head.length, this.body.length);
      return var1;
   }
}
