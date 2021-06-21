package com.atguigu.ApplicationMain.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//允许跨域访问
@CrossOrigin

//RestController其实就是ResponseBody+Controller的整合，只需要写 @RestController 就能替代前面的两个注解
@Controller

public class Index {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/uploadPage")
    public String upload(){
        return "upload";
    }

}
