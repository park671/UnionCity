package com.extendsoft.nfcpayapp.nfc;

import android.nfc.tech.IsoDep;

import com.extendsoft.nfcpayapp.util.ByteUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Iso7816 {

    public static final byte[] EMPTY = new byte[1];
    public static final short SW_APPLET_SELECT_FAILED = 27033;
    public static final short SW_BYTES_REMAINING_00 = 24832;
    public static final short SW_CLA_NOT_SUPPORTED = 28160;
    public static final short SW_COMMAND_NOT_ALLOWED = 27014;
    public static final short SW_CONDITIONS_NOT_SATISFIED = 27013;
    public static final short SW_CORRECT_LENGTH_00 = 27648;
    public static final short SW_DATA_INVALID = 27012;
    public static final short SW_FILE_FULL = 27268;
    public static final short SW_FILE_INVALID = 27011;
    public static final short SW_FILE_NOT_FOUND = 27266;
    public static final short SW_FUNC_NOT_SUPPORTED = 27265;
    public static final short SW_INCORRECT_P1P2 = 27270;
    public static final short SW_INS_NOT_SUPPORTED = 27904;
    public static final short SW_NO_ERROR = -28672;
    public static final short SW_RECORD_NOT_FOUND = 27267;
    public static final short SW_SECURITY_STATUS_NOT_SATISFIED = 27010;
    public static final short SW_UNKNOWN = 28416;
    public static final short SW_WRONG_DATA = 27264;
    public static final short SW_WRONG_LENGTH = 26368;
    public static final short SW_WRONG_P1P2 = 27392;
    protected byte[] data;

    protected Iso7816() {
        this.data = EMPTY;
    }

    protected Iso7816(byte[] var1) {
        byte[] var2 = var1;
        if (var1 == null) {
            var2 = EMPTY;
        }

        this.data = var2;
    }

    //fixme error fix
    protected void init(byte[] var1) {
        byte[] var2 = var1;
        if (var1 == null) {
            var2 = EMPTY;
        }
        this.data = var2;
    }

    public byte[] getBytes() {
        return this.data;
    }

    public int size() {
        return this.data.length;
    }

    public String toString() {
        return ByteUtil.toHexString(this.data, 0, this.data.length);
    }

    public static final class Response extends Iso7816 {

        public static final byte[] EMPTY = new byte[0];
        public static final byte[] ERROR;


        static {
            byte[] var0 = new byte[]{(byte) 111, (byte) 0};
            ERROR = var0;
        }

        public Response(byte[] var1) {
            byte[] var2;

            label11:
            {
                if (var1 != null) {
                    var2 = var1;
                    if (var1.length >= 2) {
                        break label11;
                    }
                }

                var2 = ERROR;
            }
            super.init(var2);
        }

        public boolean equalsSw12(short var1) {
            return this.getSw12() == var1;
        }

        public byte[] getBytes() {
            return this.isOkey() ? Arrays.copyOfRange(this.data, 0, this.size()) : EMPTY;
        }

        public byte getSw1() {
            return this.data[this.data.length - 2];
        }

        public short getSw12() {
            byte[] var2 = this.data;
            int var1 = var2.length;
            return (short) (var2[var1 - 2] << 8 | var2[var1 - 1] & 255);
        }

        public byte getSw2() {
            return this.data[this.data.length - 1];
        }

        public boolean isOkey() {
            return this.equalsSw12((short) -28672);
        }

        public int size() {
            return this.data.length - 2;
        }
    }

    public static final class Tag {

        private Iso7816.ID id;
        private final IsoDep nfcTag;


        public Tag(IsoDep var1) {
            this.nfcTag = var1;
            this.id = new Iso7816.ID(var1.getTag().getId());
        }

        public void close() {
            try {
                this.nfcTag.close();
            } catch (Exception var2) {
                ;
            }
        }

        public void connect() {
            try {
                this.nfcTag.connect();
            } catch (Exception var2) {
                ;
            }
        }

        public Iso7816.Response getBalance(boolean var1) {
            byte var2 = 1;
            byte[] var3 = new byte[]{(byte) -128, (byte) 92, (byte) 0, (byte) 0, (byte) 0};
            if (var1) {
                var2 = 2;
            }

            var3[3] = (byte) var2;
            var3[4] = 4;
            return new Iso7816.Response(this.transceive(var3));
        }

        public Iso7816.ID getID() {
            return this.id;
        }

        public Iso7816.Response initPurchase(boolean var1) {
            byte[] var3 = new byte[17];
            var3[0] = -128;
            var3[1] = 80;
            var3[2] = 1;
            var3[3] = (byte) (var1 ? 2 : 1);
            var3[4] = 11;
            var3[5] = 1;
            var3[10] = 17;
            var3[11] = 34;
            var3[12] = 51;
            var3[13] = 68;
            var3[14] = 85;
            var3[15] = 102;
            var3[16] = 15;
            return new Iso7816.Response(this.transceive(var3));
        }

        public Iso7816.Response readBinary(int var1) {
            byte[] var2 = new byte[]{(byte) 0, (byte) -80, (byte) (var1 & 31 | 128), (byte) 0, (byte) 0};
            return new Iso7816.Response(this.transceive(var2));
        }

        public Iso7816.Response readCardNo(int var1) {
            byte[] var2 = new byte[]{(byte) 0, (byte) -80, (byte) (var1 & 31 | 128), (byte) 0, (byte) 0};
            return new Iso7816.Response(this.transceive(var2));
        }

        public Iso7816.Response readData(int var1) {
            byte[] var2 = new byte[]{(byte) -128, (byte) -54, (byte) 0, (byte) (var1 & 31), (byte) 0};
            return new Iso7816.Response(this.transceive(var2));
        }

        public Iso7816.Response readRecord(int var1) {
            byte[] var2 = new byte[]{(byte) 0, (byte) -78, (byte) 1, (byte) (var1 << 3 | 5), (byte) 0};
            return new Iso7816.Response(this.transceive(var2));
        }

        public Iso7816.Response readRecord(int var1, int var2) {
            byte[] var3 = new byte[]{(byte) 0, (byte) -78, (byte) var2, (byte) (var1 << 3 | 4), (byte) 0};
            return new Iso7816.Response(this.transceive(var3));
        }

        public Iso7816.Response selectByID(byte... var1) {
            ByteBuffer var2 = ByteBuffer.allocate(var1.length + 6);
            var2.put((byte) 0).put((byte) -92).put((byte) 0).put((byte) 0).put((byte) var1.length).put(var1).put((byte) 0);
            return new Iso7816.Response(this.transceive(var2.array()));
        }

        public Iso7816.Response selectByName(byte... var1) {
            ByteBuffer var2 = ByteBuffer.allocate(var1.length + 6);
            var2.put((byte) 0).put((byte) -92).put((byte) 4).put((byte) 0).put((byte) var1.length).put(var1).put((byte) 0);
            return new Iso7816.Response(this.transceive(var2.array()));
        }

        public byte[] transceive(byte[] var1) {
            try {
                var1 = this.nfcTag.transceive(var1);
                return var1;
            } catch (Exception var2) {
                return Iso7816.Response.ERROR;
            }
        }

        public Iso7816.Response verify() {
            byte[] var1 = new byte[]{(byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 2, (byte) 18, (byte) 52};
            return new Iso7816.Response(this.transceive(var1));
        }
    }

    public static final class ID extends Iso7816 {

        public ID(byte[] var1) {
            super(var1);
        }
    }
}
