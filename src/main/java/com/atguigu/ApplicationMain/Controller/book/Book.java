package com.atguigu.ApplicationMain.Controller.book;

import com.atguigu.ApplicationMain.myTools.MysqlTest;
import com.atguigu.ApplicationMain.myTools.RedisClient;
import com.atguigu.ApplicationMain.myTools.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController

public class Book {
    @Autowired
    public RedisClient redisClient;
    @Autowired
    public Utils utils;
    @Autowired
    public MysqlTest mysqlTest;

    //查询所有图书
    @RequestMapping("getAllBook")
    public Object getAllBook(){
        List<Map<String, Object>> list = mysqlTest.getAllBook();
        return list;
    }

    //生成验证码
    @RequestMapping("getCode")
    public Object getCode(){
        Random random = new Random();
        int max=9999,min=1000;
        int randomNum = (int) (Math.random()*(max-min)+min);
        String codeNum = String.format("%s",randomNum);
        System.out.println("codeNum="+codeNum);
        return codeNum;
    }

    //价格区间搜索
    @RequestMapping("queryPrice")
    public Object queryPrice(@RequestParam BigDecimal start,BigDecimal end){
        return start+"=>"+end;
    }

    //生成订单号
    @RequestMapping("getOrder")
    public Object getOrder(){
        Random random = new Random();
        int max=10,min=1;
        int randomNum = (int) (Math.random()*(max-min)+min);
//        System.out.println("randomNum="+randomNum);
        long randomTime = System.currentTimeMillis();
//        System.out.println("randomTime="+randomTime);
        String orderNum = String.format("%s%d", randomTime, randomNum);
        return utils.returnMap("order",orderNum);
    }

}
