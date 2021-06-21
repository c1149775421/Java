package com.mytest.test;

import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {
    Random random = new Random();
    Map<String,Integer> map = new HashMap<>();
    Utils(){
        map.put("a", KeyEvent.VK_A);
        map.put("b", KeyEvent.VK_B);
        map.put("c", KeyEvent.VK_C);
        map.put("d", KeyEvent.VK_D);
        map.put("e", KeyEvent.VK_E);
        map.put("f", KeyEvent.VK_F);
        map.put("g", KeyEvent.VK_G);
        map.put("h", KeyEvent.VK_H);
        map.put("i", KeyEvent.VK_I);
        map.put("j", KeyEvent.VK_J);
        map.put("k", KeyEvent.VK_K);
        map.put("l", KeyEvent.VK_L);
        map.put("m", KeyEvent.VK_M);
        map.put("n", KeyEvent.VK_N);
        map.put("o", KeyEvent.VK_O);
        map.put("p", KeyEvent.VK_P);
        map.put("q", KeyEvent.VK_Q);
        map.put("r", KeyEvent.VK_R);
        map.put("s", KeyEvent.VK_S);
        map.put("t", KeyEvent.VK_T);
        map.put("u", KeyEvent.VK_U);
        map.put("v", KeyEvent.VK_V);
        map.put("w", KeyEvent.VK_W);
        map.put("x", KeyEvent.VK_X);
        map.put("y", KeyEvent.VK_Y);
        map.put("z", KeyEvent.VK_Z);
        map.put("0", KeyEvent.VK_0);
        map.put("1", KeyEvent.VK_1);
        map.put("2", KeyEvent.VK_2);
        map.put("3", KeyEvent.VK_3);
        map.put("4", KeyEvent.VK_4);
        map.put("5", KeyEvent.VK_5);
        map.put("6", KeyEvent.VK_6);
        map.put("7", KeyEvent.VK_7);
        map.put("8", KeyEvent.VK_8);
        map.put("9", KeyEvent.VK_9);
        map.put("windows", KeyEvent.VK_WINDOWS);
    }

    public Integer get(Object str){
        return this.map.get(str);
    }

    public Integer[] getList(String str){
        Integer[] intList = new Integer[str.length()];
        String[] temp = str.split("");
        for (int i = 0; i < temp.length; i++) {
            intList[i]=this.map.get(temp[i]);
        }
        return intList;
    }

    public static double auto(){
        //随机数提起
        Random random = new Random();
        double v = 0.2 + random.nextDouble()*(0.4-0.2);
        v = v * 1000;
        System.out.println("v="+v);
        return v;
    }

    public static double autoSleep(){
        //随机数等待
        Random random = new Random();
        double v2 = 2 + random.nextDouble()*(4-2);
        v2 = v2 * 1000;
        System.out.println("v2="+v2);
        return v2;
    }

}
