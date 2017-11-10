package com.zzm.demo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;

/**
 * Created by ${sq} on 2017/10/16.
 */
public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        String text = "http://192.166.1.244:12531?accountNo=q3234";
        int width = 300;
        int height = 300;
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        //直接写入文件
        File outputFile = new File("C:/JavaDevelopment/项目/MeJust/new.png");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

        //通过流写入文件，不需要flush()
        OutputStream os1 = new FileOutputStream("C:/JavaDevelopment/项目/MeJust/new2.png");
        MatrixToImageWriter.writeToStream(bitMatrix, format, os1);

        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream os = new ByteArrayOutputStream();//新建流。
        ImageIO.write(image, format, os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
        byte b[] = os.toByteArray();//从流中获取数据数组。
        String str = new BASE64Encoder().encode(b);
        System.out.println(str);
    }
}
