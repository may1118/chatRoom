package com.qq.servet.model;

import java.util.HashMap;

public class MangeClientThread {
    public static HashMap hm = new HashMap<String,SerConClientThread>();
    public static void addClientThread(String uid,SerConClientThread serConClientThread){
//        添加一个通讯线程
        hm.put(uid,serConClientThread);
    }
    public static SerConClientThread getClientThread(String uid){
        return (SerConClientThread)hm.get(uid);
    }
}
