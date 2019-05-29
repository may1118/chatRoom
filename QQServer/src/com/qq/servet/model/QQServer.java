package com.qq.servet.model;


import com.qq.servet.common.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 监听，等待某个客户端连接
 */
public class QQServer {

    public QQServer(){
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                Socket s = ss.accept();
//            接收客户端发来的信息（账号和密码）
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                com.qq.servet.common.User u = (com.qq.servet.common.User)ois.readObject();
                Message message = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                if(u.getPassword().equals("123456")){
                    message.setMessType("1");
                    oos.writeObject(message);
//                    加入线程中
                    SerConClientThread scct = new SerConClientThread(s);
//                    单开一个线程，让该线程与该客户端保持通讯
                    MangeClientThread.addClientThread(u.getUid(),scct);
//                    与客户端通讯
                    scct.start();
                }else{
                    message.setMessType("2");
                    oos.writeObject(message);
                    s.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
