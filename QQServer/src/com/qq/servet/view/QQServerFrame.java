package com.qq.servet.view;

import com.qq.servet.model.QQServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 可以开启服务器和关闭服务器
 */
public class QQServerFrame extends JFrame implements ActionListener {
    JPanel jPanel1;
    JButton jButton1,jButton2;

    public QQServerFrame(){
        jPanel1 = new JPanel();
        jButton1 = new JButton("启动服务器");
        jButton1.addActionListener(this);
        jButton2 = new JButton("关闭服务器");
        jButton2.addActionListener(this);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);

        this.add(jPanel1,"Center");
        this.setTitle("服务器管理");
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        QQServerFrame one = new QQServerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QQServer qqServer = null;
        if(e.getSource() == jButton1){
            qqServer = new QQServer();
        }
        if(e.getSource() == jButton2){
//           关闭服务器失败???
        }
    }
}
