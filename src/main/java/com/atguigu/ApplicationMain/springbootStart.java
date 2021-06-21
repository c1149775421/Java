package com.atguigu.ApplicationMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//标注一个主程序类，说明这是一个Spring Boot应用，声明这个类的main方法就是springboot的运行入口
@SpringBootApplication
public class springbootStart {

    public static void main(String[] args) {
        //spring应用启动
        SpringApplication.run(springbootStart.class, args);
        System.out.println("started");
    }

}