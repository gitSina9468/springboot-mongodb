package com.zzm.demo.utils;

import com.zzm.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author songQiang
 * @create 2018-03-19 14:39
 * @desc fastdfs 上传测试
 */
//// SpringJUnit支持，由此引入Spring-Test框架支持！

@RunWith(SpringJUnit4ClassRunner.class)
//// 指定我们SpringBoot工程的Application启动类
@SpringBootTest(classes = DemoApplication.class)
public class FastDFSClientTest {


    /**
     * 文件上传测试
     */
    @Test
    public void testUpload() {
        File file = new File("C:\\Users\\admin\\Desktop\\测试图片\\QQ图片20180202002208.jpg");
        Map<String, String> metaList = new HashMap<String, String>();
        metaList.put("width", "750");
        metaList.put("height", "220");
        metaList.put("author", "呵呵");
        metaList.put("date", "20991231");

        for (int i = 0; i < 10000; i++) {

            String fid = FastDFSClient.uploadFile(file, file.getName(), metaList);
            System.out.println("num = "+ i + ",upload local file " + file.getPath() + " ok, fileid=" + fid);
        }
        //上传成功返回的文件ID： group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg
    }

    /**
     * 文件下载测试
     */
    @Test
    public void testDownload() {
        int r = FastDFSClient.downloadFile("/group1/M00/00/10/ZcmYc1l-ob2AI3RFAAAi4joolwY786.PNG", new File("C:\\mejust\\test\\Download.jpg"));
        System.out.println(r == 0 ? "下载成功" : "下载失败");
    }

    /**
     * 获取文件元数据测试
     */
    @Test
    public void testGetFileMetadata() {
        Map<String, String> metaList = FastDFSClient.getFileMetadata("group1/M00/00/00/rBNXVlq0znWASusEAANeyEWHbSg850.jpg");
        for (Iterator<Map.Entry<String, String>> iterator = metaList.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> entry = iterator.next();
            String name = entry.getKey();
            String value = entry.getValue();
            System.out.println(name + " = " + value);
        }
    }

    /**
     * 文件删除测试
     */
    @Test
    public void testDelete() {
        int r = FastDFSClient.deleteFile("group1/M00/00/00/rBNXVlq0znWASusEAANeyEWHbSg850.jpg");
        System.out.println(r == 0 ? "删除成功" : "删除失败");
    }
}
