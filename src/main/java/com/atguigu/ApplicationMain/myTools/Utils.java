package com.atguigu.ApplicationMain.myTools;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Utils {
    //生成唯一标识
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }

    //返回提示信息
    public Map<String,String> returnMap(String key,String value){
        Map<String,String> map = new HashMap<>();
        map.put(key,value);
        System.out.println(map);
        return map;
    }

    //主程序入口
    public static void main(String[] args) {
        Utils pc = new Utils();
        System.out.println(pc.randomUUID());
    }
}
