package com.qq.client.model;

import com.qq.client.common.User;

public class QQClientUser {
    public boolean checkUser(User user){
//        完成验证工作
        return new QQClientConServer().sendLoginInfoToServer(user);
    }
    public QQClientUser(){

    }
}
