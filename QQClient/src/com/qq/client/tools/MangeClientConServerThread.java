package com.qq.client.tools;

import java.util.HashMap;

public class MangeClientConServerThread {
    private static HashMap hm = new HashMap<String,ClientConSerThread>();
    public MangeClientConServerThread(){

    }
    public static void addClientServerThread(String uid,ClientConSerThread ccst){
        hm.put(uid,ccst);
    }
    public static ClientConSerThread getClientServerThread(String uid){
        return (ClientConSerThread) hm.get(uid);
    }
}
