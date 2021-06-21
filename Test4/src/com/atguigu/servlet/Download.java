package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取要下载的文件名
        String downloadFileName = "05.jpg";

//        2.读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/static/file/" + downloadFileName);
        System.out.println("要下载的文件类型："+mimeType);

//        4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

//        5.还要告诉客户端收到的数据是用于下载的(还是使用响应头)，不是用来显示的
        //Content-Disposition 响应头，表示 收到的数据要怎么处理
        //attachment 表示 附件，用于下载使用
        //filename 表示 指定下载的文件名
        //URLEncoder.encode("文件名.jpg","UTF-8")); 是把汉字转换为%xx%xx的格式
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("中文.jpg","UTF-8"));

//        3.把下载的文件内容回传给客户端
        //斜杠被服务器解析地址为：http://ip:port/工程名/  (映射到服务器的web目录)
        InputStream resourceAsStream = servletContext.getResourceAsStream("/static/file/" + downloadFileName);
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //读取输入流中全部的数据，复制给输出流去输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
