package com.atguigu.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Element;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

//@RestController
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
//@CrossOrigin
public class Hello {
    public static List<Map<String,Object>> allData = new ArrayList<>();

//    @RequestMapping("/")
    public List<Map<String,Object>> test(@RequestParam String date, String price, String tips){
        //如果有空值，返回提示信息
        if ((price == "null" || price == "" || price == null) || (tips == "null" || tips == "" || tips == null)){
            Map<String,Object> map = new HashMap<>();
            List<Map<String,Object>> temp = new ArrayList<>();
            map.put("data","请填写完整不能留空");
            temp.add(map);
            return temp;
        }

        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date dates = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(dates));
        //获取当前时间字符
        String str = dates.toString().split(" ")[3];
//        System.out.println(str);

        //定义一个map集合存放数据
        Map<String,Object> map = new HashMap<>();
        map.put("date",date+" "+str);
        map.put("price",price);
        map.put("tips",tips);
        try {
            //将map的数据添加到list列表集合中
            allData.add(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回list的数据
        return allData;
    }

//    @RequestMapping("/get")
    public List<Map<String,Object>> get(){
        for (int i = 0; i < allData.size() ; i++) {
            System.out.println(allData.get(i));
        }
        return allData;
    }

//    @RequestMapping("/del")
    public List<Map<String,Object>> del(@RequestParam String dat){
        for (int i = 0; i < allData.size(); i++) {
//            System.out.println(i);
//            System.out.println(allData.get(i).get("date"));
//            System.out.println(dat);
            if(allData.get(i).get("date").equals(dat)){
                System.out.println("delete="+dat);
                allData.remove(i);
            }
        }
        return allData;
    }

}
