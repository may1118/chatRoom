package com.qq.client.tools;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConSerThread extends Thread{
    private Socket s;

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public ClientConSerThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                com.qq.client.common.Message m = (com.qq.client.common.Message)ois.readObject();
                System.out.println("测试内容"+m.getGetter()+" "+m.getSender()+" "+m.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
