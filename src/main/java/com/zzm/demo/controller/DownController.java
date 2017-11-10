package com.zzm.demo.controller;

import com.zzm.demo.utils.QRcode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created by ${sq} on 2017/10/16.
 */
@Controller
public class DownController {

    @RequestMapping(value = "/down",method= RequestMethod.GET)
    public void downLoad(HttpServletResponse response) throws Exception{
        byte [] b = QRcode.getImageBytes();
        //展示图片
       /* response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);*/
       String fileName = "123.png";
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        OutputStream out = null;
        out = response.getOutputStream();
        out.write(b);
        out.flush();
        out.close();
    }
}
