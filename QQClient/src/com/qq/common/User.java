package com.qq.client.common;

import java.io.Serializable;
//实现序列化，能够使文本在网络上安全传输
public class User implements Serializable {
    private String uid;
    private String password;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){}

}
