package com.qq.client.model;

import com.qq.client.tools.ClientConSerThread;
import com.qq.client.tools.MangeClientConServerThread;
import com.qq.client.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//客户端连接服务器后台
public class QQClientConServer{
    public Socket s;
    boolean flag = false;
    public boolean sendLoginInfoToServer(Object o){
        try {
            s=new Socket("127.0.0.1",9999);
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            com.qq.client.common.Message ms=(com.qq.client.common.Message)ois.readObject();
            if(ms.getMessType().equals("1")){
                flag = true;
//                和服务器端保持通讯连接的线程
                ClientConSerThread ccst = new ClientConSerThread(s);
//                启动该通讯线程
                ccst.start();
                MangeClientConServerThread.addClientServerThread((((User)o).getUid()),ccst);
            }else{
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public void sendInfoToServer(Object o){

    }
}
