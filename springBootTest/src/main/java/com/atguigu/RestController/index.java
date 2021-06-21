package com.atguigu.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//允许跨域访问
@CrossOrigin
public class index {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/get")
    public String get(){
        return "恭喜你发现了get接口!";
    }
}
