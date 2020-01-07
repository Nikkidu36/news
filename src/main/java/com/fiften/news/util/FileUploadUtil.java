package com.fiften.news.util;


import okhttp3.*;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 刘佳昇
 * @Date 2019/9/12 20:00
 */
@Component
public class FileUploadUtil {


    /**
     * 文件上传
     * @param file
     * @param
     * @return
     */
    public String fileUpload(@RequestParam(name = "file") MultipartFile file){
        try {
            OkHttpClient client = new OkHttpClient();

            //临时存放点
            String tempPath =  System.getProperty("catalina.home")+"//";
            System.out.println(tempPath);
            /**
             * 上传文件格式
             */
            //存临时文件
            File f = new File(tempPath+file.getOriginalFilename());
            file.transferTo(f);
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), f);//将file转换成RequestBody文件
            RequestBody requestBody=new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file",f.getName(),fileBody)
                    .build();
            Request request = new Request.Builder()
                    .url("http://120.79.30.62:8889/uploadFile")
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            String url = Objects.requireNonNull(response.body()).string();

            if (f.delete()){
                return url;
            }else {
                throw new RuntimeException("临时文件删除失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "本地上传异常";
        }
    }


}
