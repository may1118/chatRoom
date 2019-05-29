package com.qq.client.view;

import com.qq.client.common.Message;
import com.qq.client.tools.MangeClientConServerThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class QQChat extends JFrame implements ActionListener, KeyListener {
    String ownerId;
    String friendId;
    JPanel jPanel;
    JButton jButton;
    JTextArea jTextArea;
    JTextField jTextField;
    JScrollPane jScrollPane;

    public QQChat(String myId,String title){
        this.ownerId = myId;
        this.friendId = title;
        jPanel = new JPanel();
        jButton = new JButton("发送");
        jButton.addActionListener(this);
        jTextArea = new JTextArea();
        jTextArea.setEnabled(false);
        jTextField = new JTextField(10);
        jScrollPane = new JScrollPane(jTextArea);

        jPanel.add(jTextField);
        jPanel.add(jButton);
        this.add(jScrollPane,"Center");
        this.add(jPanel,"South");
        this.setIconImage(new ImageIcon("images/qq.gif").getImage());
        this.setTitle(myId+"正在和"+title+"聊天...");
        this.setSize(350,300);
        this.setLocation(200,200);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton) {
//            发送内容
            Message message = new Message();
            message.setSender(this.ownerId);
            message.setGetter(this.friendId);
            message.setContent(jTextField.getText());
            message.setSendTime(new Date().toString());
            jTextArea.append(this.ownerId + " 对 " + this.friendId + " 说: " + jTextField.getText()+"\r\n");
            jTextField.setText("");
            //            发送给服务器
            try {
                ObjectOutputStream oos = new ObjectOutputStream(MangeClientConServerThread.getClientServerThread(this.ownerId).getS().getOutputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
//            回车发送信息

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
