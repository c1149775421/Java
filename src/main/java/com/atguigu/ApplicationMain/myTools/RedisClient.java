package com.atguigu.ApplicationMain.myTools;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RedisClient {
    //连接本地的 Redis 服务
    Jedis jedis = new Jedis("127.0.0.1");

    public static void main(String[] args) {
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
//        System.out.println("连接成功");
        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());

        RedisClient pc = new RedisClient();
//        System.out.println(pc.keysAll());

        Set<String> list = pc.jedis.keys("*");
        for(Object str:list ) {
            pc.jedis.del((String) str);
            System.out.println(str);
        }
//        System.out.println(pc.jedis.keys("*"));

//        pc.lrange("username",0,100);
//        pc.lrange("password",0,100);
//        pc.lrange("email",0,100);
    }

    //获取所有的键和值
    public Map<String,String> keysAll(){
        Set<String> set = jedis.keys("*");
        Map<String,String> map = new HashMap<>();
        for(String item:set){
            map.put(item,jedis.get(item));
        }
        jedis.close();
        return map;
    }

    //设置单个键值
    public String set(String key,String value){
        jedis.set(key,value);
        jedis.expire(key,86400);//24小时
        System.out.println("设置成功："+key+"=>"+value);
        jedis.close();
        return key+"=>"+value;
    }

    //查询单个键值
    public String get(String key){
        String test = jedis.get(key);
        System.out.println("查询完成："+key+"=>"+test);
        jedis.close();
        return test;
    }

    //删除单个键值
    public String del(String key){
        jedis.del(key);
        System.out.println("删除成功："+key);
        jedis.close();
        return key;
    }

    //添加键值列表
    public String lpush(String key,String values){
        jedis.lpush(key,values);
        System.out.println("添加成功："+key+"=>"+values);
        jedis.close();
        return "添加成功："+key+"=>"+values;
    }

    //查询键值列表
    public List<String> lrange(String key,int start,int end){
        List<String> list = jedis.lrange(key,start,end);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项"+key+"为："+list.get(i));
        }
        jedis.close();
        return list;
    }

    //删除指定的列表键值
    public List<String> lrem(String key,String value){
        List<String> list = lrange(key,0,100);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(value)){
                jedis.lrem(key,1,value);
                System.out.println(key+"删除成功："+value);
            }
        }
        jedis.close();
        return list;
    }

}
