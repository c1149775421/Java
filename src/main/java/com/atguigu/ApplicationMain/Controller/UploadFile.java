package com.atguigu.ApplicationMain.Controller;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class UploadFile {
    @PostMapping("/upload")
    public String upload(@RequestParam("myfile")MultipartFile file, Model model){
        //判断文件是否为空
        if(file.isEmpty()){
//            model.addAttribute("result","文件为空");
            return "文件为空";
        }

        //创建文件输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置
//            String path = "/var/ftp/pub/upload/";
            String path = "D:/Test/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            //注意是路径+文件名
            File targetFile = new File(path + fileName);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

            //判断文件父目录是否存在
            if(!targetFile.getParentFile().exists()){
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);
            /*参数是通过源码
                public static int copy(InputStream in, OutputStream out) throws IOException {
                    ......
                }
           而得知的*/

            //告诉页面上传成功了
//            model.addAttribute("result", "上传成功");
            return "upload_success";
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
//            model.addAttribute("result", "上传失败");
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "index";
    }
}
