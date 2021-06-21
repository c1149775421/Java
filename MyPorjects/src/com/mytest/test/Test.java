package com.mytest.test;
//打开cmd并退出
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws AWTException {
        //创建工具类实例
        Utils utils = new Utils();
        //创建一个Java机器人
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_R);
        robot.delay((int)utils.auto());
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_R);

        robot.delay((int)utils.autoSleep());

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay((int)utils.auto());
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay((int)utils.autoSleep());

        Integer[] iii = utils.getList("exit");
        for (int i = 0; i < iii.length; i++) {
            robot.keyPress(iii[i]);
            robot.delay((int)utils.auto());
            robot.keyRelease(iii[i]);
        }

        robot.delay((int)utils.autoSleep());

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay((int)utils.auto());
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
