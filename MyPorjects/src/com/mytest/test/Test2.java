package com.mytest.test;

import java.awt.*;
import java.util.Scanner;

public class Test2 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws AWTException {
        Utils utils = new Utils();
        Robot robot = new Robot();
        System.out.print("输入1执行，输入0退出：");
        int s1 = scanner.nextInt();
        if(s1==1){
            Integer[] iii = utils.getList("exit");
            for (int i = 0; i < iii.length; i++) {
                robot.delay(2000);
                robot.keyPress(iii[i]);
                robot.delay(300);
                robot.keyRelease(iii[i]);
            }
        }else if(s1==0){
            System.out.println("退出");
        }else{
            System.out.println("error");
        }
    }
}
