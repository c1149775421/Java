package com.atguigu.pojo;

import java.util.Map;

public class Test {
    private String username;
    private String password;
    private String single;

    public Test(String username) {
        this.username = username;
    }

    public Test(String username, String password, String single) {
        this.username = username;
        this.password = password;
        this.single = single;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    @Override
    public String toString() {
        return "Test{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", single='" + single + '\'' +
                '}';
    }
}
