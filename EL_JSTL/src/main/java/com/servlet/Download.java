package com.servlet;

import org.apache.commons.io.IOUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;


public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要下载的文件名
        String downloadFileName = "kirito.jpg";
        //读取要下载的文件内容（通过servletContext对象可以读取）
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型" +mimeType);
        //在回传前，概述客户端返回的数据类型
        resp.setContentType(mimeType);
        //还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        //Content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，表示下载使用
        //filename = 表示指定下载的文件名
        /*resp.setHeader("Content-Disposition","attachment;filename = "+downloadFileName);*/ /*标准的英文形式*/
        //filename的文件名是可以指定的，可以与源文件不同
        /*resp.setHeader("Content-Disposition","attachment;filename = 折木奉太郎.jpg");*/   /*这里的中文会错误显示*/

        //解决方式
        //1，使用中文文件名时谷歌浏览器会出现问题，这时需要对文件名进行url编码,,,就是把汉字转化为%xx%xx的形式
        /*resp.setHeader("Content-Disposition","attachment;filename = "+ URLEncoder.encode("折木奉太郎.jpg","UTF-8"));*/

        //2,火狐浏览器使用的是BASE64编码，谷歌和ie的url编码并不能显示
        //resp.setHeader("Content-Disposition","attachment;filename ==?UTF-8?B? "+ Base64.getEncoder().encodeToString("折木奉太郎.jpg".getBytes("UTF-8")));

        //3,进行判断，分别处理
        if(req.getHeader("User-Agent").contains("Firefox"))
        {
            resp.setHeader("Content-Disposition","attachment;filename ==?UTF-8?B? "+ Base64.getEncoder().encodeToString("折木奉太郎.jpg".getBytes("UTF-8")));
        }
        else
        {
            resp.setHeader("Content-Disposition","attachment;filename = "+ URLEncoder.encode("折木奉太郎.jpg","UTF-8"));
        }




        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应输出流
        OutputStream outputStream = resp.getOutputStream();
        //读取流种全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);



    }
}
