package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //javaBean和json互转
    @Test
    public void test1(){
        Person person = new Person(1,"国歌！");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把Java对象转换为json字符串
        String personToJsonStr = gson.toJson(person);
        System.out.println(personToJsonStr);
        //fromJson把json字符串转换为Java对象类型(第一个参数是json字符串，第二个参数是Java对象类型)
        Person person1 = gson.fromJson(personToJsonStr, Person.class);
        System.out.println(person1);
    }

    //List和json互转
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"国歌！"));
        personList.add(new Person(2,"康师傅！"));
        Gson gson = new Gson();
        //把List转换为json字符串
        String personListToJsonStr = gson.toJson(personList);
        System.out.println(personListToJsonStr);
        //把json字符串转换为List
        List list = gson.fromJson(personListToJsonStr,new PersonListType().getType());
        System.out.println(list);
    }

    //Map和json互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"国哥"));
        personMap.put(2,new Person(2,"康师傅"));
        Gson gson = new Gson();
        //把Map集合转换为json字符串
        String personMapToJsonStr = gson.toJson(personMap);
        System.out.println(personMapToJsonStr);
        //把json字符串转换为Map集合
        //使用匿名内部类，节省资源，随写随用，方便快捷
        Map<Integer,Person> map = gson.fromJson(personMapToJsonStr,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(map);
//        Person p = map.get(1);
//        System.out.println(p);
    }
}
