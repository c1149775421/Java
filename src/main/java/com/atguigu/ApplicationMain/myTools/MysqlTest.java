package com.atguigu.ApplicationMain.myTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Component
public class MysqlTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询所有用户
    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from t_user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//        for (Map<String, Object> map : list) {
//            Set<Map.Entry<String, Object>> entries = map.entrySet( );
//            if(entries != null) {
//                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                while(iterator.hasNext( )) {
//                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                    Object key = entry.getKey( );
//                    Object value = entry.getValue();
//                    System.out.println(key+":"+value);
//                }
//            }
//        }
        return list;
    }

    //查询所有图书
    public List<Map<String,Object>> getAllBook(){
        String sql = "select * from t_book";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        return list;
    }

    //查询所有订单
    public List<Map<String,Object>> getAllOrder(){
        String sql = "select * from t_order";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        return list;
    }

    //查询所有订单项
    public List<Map<String,Object>> getAllOrderItem(){
        String sql = "select * from t_order_item";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        return list;
    }

    //查询的预处理方法
    public List<Map<String,Object>> select(String sql,Object...args){
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,args);
        return list;
    }

    //更新数据库信息
    public int update(String sql){
        int aBoolean =  jdbcTemplate.update(sql);
        return aBoolean;
    }

    //更新数据库信息的预处理方法
    public int updateStmt(String sql, Object ...args){
        int aBoolean =  jdbcTemplate.update(sql,args);
        return aBoolean;
    }

//    查询账号权限
    public String userRootQueryStmt(String sql, Object ...args){
        final String[] i = new String[1];
        i[0] = String.valueOf(0);
        jdbcTemplate.query(sql,(rs) -> {
            i[0] = rs.getString("root");
        },args);
//        System.out.println(i[0]);
        return i[0];
    }

}