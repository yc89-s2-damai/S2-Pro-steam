package com.yc.steam.util;

import java.io.*;
import java.util.Base64;
import java.util.UUID;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

@Service
public class QRcodeUtil {


    /**
     * 生成发送二维码方法
     *
     * @param text   二维码生成规则(二维码可以是任何英文字母加数字生成的二维码)
     * @param width  宽度
     * @param height 高度
     */
    public String getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        //生成二维码类
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //生成的二维码
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        //如果要把二维码在前台显示的话需要转成Base64
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);
        byte[] bytes = baos.toByteArray();
        String encode = Base64.getEncoder().encodeToString(bytes);
        return encode;
    }


    public static void main(String[] args) {
        try {
            QRcodeUtil qRcodeUtil = new QRcodeUtil();
            String dd = qRcodeUtil.getQRCodeImage(" Pay success", 350, 350);
            System.out.println(dd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 把String自带的UUID去除下划线返回
     *
     * @return String UUID
     */
    public String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }
}
