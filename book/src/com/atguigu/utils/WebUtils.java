package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * HTTPServletRequest  会导致
 * Dao层
 * Service层
 * Web层  耦合度高
 * Map可以做到三层通用
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
//            System.out.println("注入之前"+bean);
            //就这么一行代码，把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,value);
//            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     *将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return 如果转换失败，返回默认值
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            if(strInt==null){
                return defaultValue;
            }
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
