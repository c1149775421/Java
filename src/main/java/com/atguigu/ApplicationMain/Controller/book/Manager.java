package com.atguigu.ApplicationMain.Controller.book;

import com.atguigu.ApplicationMain.myTools.MysqlTest;
import com.atguigu.ApplicationMain.myTools.RedisClient;
import com.atguigu.ApplicationMain.myTools.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

public class Manager {
    @Autowired
    public RedisClient redisClient;
    @Autowired
    public Utils utils;
    @Autowired
    public MysqlTest mysqlTest;
    @Autowired
    public User user;

    //管理添加图书
    @RequestMapping("managerBookAdd")
    //String token,String name,BigDecimal price,String author,int sales,int stock,String img_path
    public Object managerBookAdd(@RequestParam String token, String name, BigDecimal price, String author, int sales, int stock, String img_path){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> listAll = mysqlTest.getDbType();
            for (int i = 0; i < listAll.size(); i++) {
                //判断token中的账号是否拥有管理员权限
                if( listAll.get(i).get("username").equals(usr) && listAll.get(i).get("password").equals(pwd) ){
                    //如果有权限，继续执行操作
                    String sql ="insert into t_book values(null,?,?,?,?,?,?)";
                    mysqlTest.updateStmt(sql,name,price,author,sales,stock,img_path);
                    return utils.returnMap("success","成功添加图书："+name);
                }
            }
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
        return null;
    }

    //管理更改图书
    @RequestMapping("managerBookUpdate")
    //String token, int bookId, String name,BigDecimal price,String author,int sales,int stock,String img_path
    public Object managerBookUpdate(@RequestParam String token, int bookId, String name,BigDecimal price,String author,int sales,int stock,String img_path){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> listUser = mysqlTest.getDbType();
            for (int i = 0; i < listUser.size(); i++) {
                //判断token中的账号是否拥有管理员权限
                if( listUser.get(i).get("username").equals(usr) && listUser.get(i).get("password").equals(pwd) ){
                    List<Map<String, Object>> allBook = mysqlTest.getAllBook();
                    for (int j = 0; j < allBook.size(); j++) {
                        Object id = allBook.get(j).get("id");
                        if(id.equals(bookId)){
                            String sql = "update t_book set `id`=?,`name`=?,`price`=?,`author`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
                            mysqlTest.updateStmt(sql,bookId,name,price,author,sales,stock,img_path,bookId);
                            return utils.returnMap("success","【"+name+"】修改成功");
                        }
                    }
                    return utils.returnMap("error","图书编号不正确");
                }
            }
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
        return null;
    }

    //管理删除图书
    @RequestMapping("managerBookDelete")
    public Object managerBookDelete(@RequestParam String token,int bookId){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        try {
            String t = redisClient.get(token);
            String usr = t.split("-")[0];
            String pwd = t.split("-")[1];
            //调用方法查询数据库中的所有用户信息
            List<Map<String, Object>> listUser = mysqlTest.getDbType();
            for (int i = 0; i < listUser.size(); i++) {
                //判断token中的账号是否拥有管理员权限
                if( listUser.get(i).get("username").equals(usr) && listUser.get(i).get("password").equals(pwd) ){
                    List<Map<String, Object>> allBook = mysqlTest.getAllBook();
                    for (int j = 0; j < allBook.size(); j++) {
                        Object id = allBook.get(j).get("id");
                        if(id.equals(bookId)){
                            Object name = allBook.get(j).get("name");
                            System.out.println(id+":"+name);
                                String sql = "delete from t_book where id="+id;
                                mysqlTest.update(sql);
                            return utils.returnMap("success","成功删除图书："+name);
                        }
                    }
                    return utils.returnMap("error","图书编号不正确");
                }
            }
        } catch (Exception e) {
            return utils.returnMap("error","token错误");
        }
        return null;
    }

    //查询所有订单信息
    @RequestMapping("orderAll")
    public Object orderAll(@RequestParam String token){
        return "token="+token;
    }

    //管理更改订单信息
    @RequestMapping("managerOrderUpdate")
    public Object managerOrderUpdate(@RequestParam String token,int order){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        return null;
    }

    //管理删除订单
    @RequestMapping("managerOrderDelete")
    public Object managerOrderDelete(@RequestParam String token,int order){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        return null;
    }

    //管理发货
    @RequestMapping("managerOrderStatus")
    public Object managerOrderStatus(@RequestParam String token,int order,int status){
        String isRoot = user.isRoot(token).get("isRoot");
        if(isRoot.equals("0")){
            return utils.returnMap("error","抱歉，你没有管理员权限!");
        }
        return null;
    }

}
