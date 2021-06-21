package com.atguigu.ApplicationMain.Controller.book;

import com.atguigu.ApplicationMain.myTools.MysqlTest;
import com.atguigu.ApplicationMain.myTools.RedisClient;
import com.atguigu.ApplicationMain.myTools.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
@Component
public class User {
    //redis工具类
    @Autowired
    public RedisClient redisClient;
    //工具类
    @Autowired
    public Utils utils;
    //数据库工具类
    @Autowired
    public MysqlTest mysqlTest;

    //注册
    @RequestMapping("regist")
    public Map<String,String> regist(@RequestParam String username, String password, String email){
        //邮件的正则表达式
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();

        //用户名和密码的正则表达式
        String notNull = "^[a-z0-9A-Z]{6,}$";
        Pattern ad = Pattern.compile(notNull);
        Matcher eq = ad.matcher(username);
        boolean isflag = eq.matches();
        Matcher eq2 = ad.matcher(password);
        boolean isflag2 = eq2.matches();

        try {
            //根据正则表达式判断格式是否正确
            if(isMatched && isflag && isflag2){
                //调用方法查询数据库中的所有用户信息
                List<Map<String, Object>> list = mysqlTest.getDbType();
                //遍历查询到的所有用户信息
                for (int i = 0; i < list.size(); i++) {
                    if( username.equals(list.get(i).get("username")) ){
                        //调用方法把提示信息存入集合中并返回
                        return utils.returnMap("error","用户名["+username+"]已存在");
                    }
                }
                //添加用户的SQL语句
                String sql = "insert into `t_user` values(null,\""+username+"\",\""+password+"\",\""+email+"\")";
                //调用方法执行SQL语句
                mysqlTest.update(sql);
                //调用方法把提示信息存入集合中并返回
                return utils.returnMap("success",username+"注册成功");
            }else if(!isflag){
                //调用方法把提示信息存入集合中并返回
                return utils.returnMap("error","账号格式错误");
            }else if(!isflag2){
                //调用方法把提示信息存入集合中并返回
                return utils.returnMap("error","密码格式错误");
            }else if(!isMatched){
                //调用方法把提示信息存入集合中并返回
                return utils.returnMap("error","邮箱格式错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用方法把提示信息存入集合中并返回
        return utils.returnMap("error",username+"注册失败");
    }

    //登录
    @RequestMapping("login")
    public Map<String,String> login(@RequestParam String username,String password){
        //创建集合，用于返回json数据
        Map<String,String> mapLogin = new HashMap<>();

        Map temp = redisClient.keysAll();
        for (Object key:temp.keySet()) {
            if( temp.get(key).equals(username+"-"+password) ){
                mapLogin.put("success",username+"登录成功");
                mapLogin.put("token", (String) key);
                return mapLogin;
            }
        }

        try {
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> list = mysqlTest.getDbType();
            //遍历查询到的所有用户信息
            for (int i = 0; i < list.size(); i++) {
                //判断遍历到的用户信息和传入的用户信息是否相同
                if( username.equals(list.get(i).get("username")) && password.equals(list.get(i).get("password")) ){
                    //调用方法生成唯一标识码
                    String token = utils.randomUUID();
                    //把对应用户的唯一标识码存入redis的列表中
                    redisClient.set(token,username+"-"+password);
                    System.out.println(username+"已登录");
                    //提示信息和数据存入集合中
                    mapLogin.put("success",username+"登录成功");
                    mapLogin.put("token",token);
                    //返回集合中的信息和数据
                    return mapLogin;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utils.returnMap("error",username+"登录失败");
    }

    //权限检查
    @RequestMapping("isRoot")
    public Map<String,String> isRoot(@RequestParam String token){
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            String sql = "select root from t_user where username=? and password=?";
            return utils.returnMap("isRoot", mysqlTest.userRootQueryStmt(sql,usr,pwd));
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
    }

    //退出登录
    @RequestMapping("loginOut")
    public Map<String,String> loginOut(@RequestParam String token){
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> list = mysqlTest.getDbType();
            //遍历查询到的所有用户信息
            for (int i = 0; i < list.size(); i++) {
                if( list.get(i).get("username").equals(usr) && list.get(i).get("password").equals(pwd) ){
                    //删除对应用户redis列表中的唯一标识码
                    redisClient.del(token);
                    return utils.returnMap("success",usr+"：退出登录成功");
                }
            }
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
        return null;
    }

    //注销用户
    @RequestMapping("registOut")
    public Map<String,String> registOut(@RequestParam String token){
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> list = mysqlTest.getDbType();
            //遍历查询到的所有用户信息
            for (int i = 0; i < list.size(); i++) {
                if( list.get(i).get("username").equals(usr) && list.get(i).get("password").equals(pwd) ){
                    //查询对应用户的id值
                    Object id = list.get(i).get("id");
                    //根据id值删除对应的用户信息
                    String sql = "delete from `t_user` where id="+id;
                    //调用方法执行SQL语句
                    mysqlTest.update(sql);
                    //删除对应用户redis列表中的唯一标识码
                    redisClient.del(token);
                    return utils.returnMap("success",usr+"：注销成功");
                }
            }
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
        return null;
    }

}
