package com.qq.servet.model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//服务器与某个客户端的通信线程
public class SerConClientThread extends Thread{
    Socket s;
    public SerConClientThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                com.qq.servet.common.Message message = (com.qq.servet.common.Message)ois.readObject();
                System.out.println("测试发送案例："+message.getSender()+" "+message.getGetter()+" "+message.getContent());
//                转发
                SerConClientThread sc = MangeClientThread.getClientThread(message.getGetter());
                if(sc != null){
                    ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
                    oos.writeObject(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
