package com.atguigu.test;
import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        //改动：
//        for(int i = 0;i < 20;i++){
//            Connection connection = JdbcUtils.getConnection();
//            System.out.println(connection);
//            //数据要及时的释放，否则会超过最大连接数
//            JdbcUtils.close(connection);
//        }
    }
}
