package com.youngpark.util;

import com.extendsoft.nfcpayapp.util.ByteUtil;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.arraycopy;

public class TlvUtil {

    public class Tag {
        String tag;
        String length;
        String value;

        @Override
        public String toString() {
            return "Tag{" +
                    "tag='" + tag + '\'' +
                    ", length='" + length + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public Tag tag;
    public List<Tag> tags;

    public TlvUtil() {
        tags = new ArrayList<>();
    }

    public String getString(List<Tag> tags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tag tag : tags) {
            stringBuilder.append(tag.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public int pbocTlvAns(byte[] rxbuf, int rxsize) {
        int cout = 0, n = 0, num = 0;
        //===========================================TLV解析
        while (cout < rxsize) {
            if ((((rxbuf[cout] & 0xff) & 0x1F) == 0x1F)) {
                //2字节Tag
                if (((rxbuf[cout] & 0xff) == 0xBF) && ((rxbuf[cout + 1] & 0xff) == 0x0C)) {
                    //=================================//模板
                    //模板里的数据还需要进一步解析
                    num = 0;
                } else {
                    //=================================//标签
                    num = 1;
                }
                tag = new Tag();
                tag.tag = String.format("%02x%02x", (rxbuf[cout] & 0xff), (rxbuf[cout + 1] & 0xff));
                cout += 2;
                if (((rxbuf[cout] & 0xff) & 0x80) == 0x80) {
                    //=============================//长度为非1字节
                    switch ((rxbuf[cout] & 0xff) & 0x7F) {
                        //目前只处理最多2字节
                        case 1:
                            n = (rxbuf[cout + 1] & 0xff);
                            tag.length = String.format("%02x%02x", (rxbuf[cout] & 0xff), (rxbuf[cout + 1] & 0xff));
                            cout += 2;
                            break;
                        case 2:
                            n = (((rxbuf[cout + 1] & 0xff) << 8) & 0xFF00) | (rxbuf[cout + 2] & 0xff);
                            tag.length = String.format("%02x%02x%02x", rxbuf[cout] & 0xff, rxbuf[cout + 1] & 0xff, rxbuf[cout + 2] & 0xff);
                            cout += 3;
                            break;
                        // case 3:
                        //n = ( ( rxbuf[cout+1] << 16 ) & 0xFF0000 ) | ( ( rxbuf[cout+2] << 8 ) & 0xFF00 ) | rxbuf[cout+3];
                        //cout += 4;
                        //break;
                        default:
                            //ErrMsg((U08*)"L解析错误\r\n",strlen("L解析错误\r\n") );
                            return 40;
                    }
                } else {
                    //=============================//长度为1字节
                    n = (rxbuf[cout] & 0xff);
                    tag.length = String.format("%02x", n);
                    cout += 1;
                }
                byte[] buffer = new byte[n];
                arraycopy(rxbuf, cout, buffer, 0, n);
                tag.value = ByteUtil.toHexString(buffer, 0, buffer.length);
                tags.add(tag);
                if (num == 0) {
                    //=================================//模板
                    //模板里的数据还需要进一步解析
                } else {
                    //=================================//标签
                    cout += n;
                }
            } else {
                //1字节T
                if (((rxbuf[cout] & 0xff) >= 0x61) && ((rxbuf[cout] & 0xff) <= 0x7F)) {//=================================//模板
                    //模板里的数据还需要进一步解析
                    num = 0;
                } else if (((rxbuf[cout] & 0xff) == 0x80) || ((rxbuf[cout] & 0xff) == 0xA5)) {
                    //=================================//模板
                    //模板里的数据还需要进一步解析
                    num = 0;
                } else {
                    //=================================//标签
                    num = 1;
                }
                tag = new Tag();
                tag.tag = String.format("%02x", (rxbuf[cout] & 0xff));
                cout++;
                if (((rxbuf[cout] & 0xff) & 0x80) == 0x80) {
                    //=============================//长度为非1字节
                    switch ((rxbuf[cout] & 0xff) & 0x7F) {
                        //目前只处理最多2字节
                        case 1:
                            n = (rxbuf[cout + 1] & 0xff);
                            tag.length = String.format("%02x%02x", (rxbuf[cout] & 0xff), (rxbuf[cout + 1] & 0xff));
                            cout += 2;
                            break;
                        case 2:
                            n = ((rxbuf[cout + 1] << 8) & 0xFF00) | rxbuf[cout + 2];
                            tag.length = String.format("%02x%02x%02x", (rxbuf[cout] & 0xff), (rxbuf[cout + 1] & 0xff), (rxbuf[cout + 2] & 0xff));
                            cout += 3;
                            break;
                        // case 3:
                        //n = ( ( rxbuf[cout+1] << 16 ) & 0xFF0000 ) | ( ( rxbuf[cout+2] << 8 ) & 0xFF00 ) | rxbuf[cout+3];
                        //cout += 4;
                        //break;
                        default:
                            //ErrMsg((U08*)"L解析错误\r\n",strlen("L解析错误\r\n") );
                            return 40;
                    }
                } else {
                    //=============================//长度为1字节
                    n = (rxbuf[cout] & 0xff);
                    tag.length = String.format("%02x", n);
                    cout += 1;
                }
                byte[] buffer = new byte[n];
                arraycopy(rxbuf, cout, buffer, 0, n);
                tag.value = ByteUtil.toHexString(buffer, 0, buffer.length);
                tags.add(tag);
                if (num == 0) {
                    //=================================//模板
                    //模板里的数据还需要进一步解析
                } else {
                    //=================================//标签
                    cout += n;
                }
            }
        }
        return 0;
    }

}
