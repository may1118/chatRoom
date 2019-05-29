package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QQFriendList extends JFrame implements ActionListener, MouseListener {
    String myId = null;
    CardLayout cardLayout = null;
//    第一张
    JPanel jPanel1,jPanel2,jPanel3;
    JButton jPanel1_jb1,jPanel1_jb2,jPanel1_jb3;
    JScrollPane jScrollPane1;
//    第二张
    JPanel jPanelM1,jPanelM2,jPanelM3;
    JButton jPanelM1_jb1,jPanelM1_jb2,jPanelM1_jb3;
    JScrollPane jScrollPane2;

    public QQFriendList(String myId){
        this.myId = myId;
        cardLayout = new CardLayout();
//        处理第一张卡片，好友列表
        jPanel1_jb1 = new JButton("我的好友");
        jPanel1_jb2 = new JButton("陌生人");
        jPanel1_jb2.addActionListener(this);
        jPanel1_jb3 = new JButton("黑名单");
        jScrollPane1 = new JScrollPane(jPanel2);

        jPanel1 = new JPanel(new BorderLayout());
        jPanel2 = new JPanel(new GridLayout(50,1,4,4));
        jPanel3 = new JPanel(new GridLayout(2,1));
        JLabel[] jbls = new JLabel[50];
        for (int i=0;i<jbls.length;i++){
            jbls[i] = new JLabel((i+1)+"",(new ImageIcon("images/mm.jpg")),JLabel.LEFT);
            jbls[i].addMouseListener(this);
            jPanel2.add(jbls[i]);
        }
        jScrollPane1 = new JScrollPane(jPanel2);
        jPanel3.add(jPanel1_jb2);
        jPanel3.add(jPanel1_jb3);

        jPanel1.add(jPanel1_jb1,"North");
        jPanel1.add(jScrollPane1,"Center");
        jPanel1.add(jPanel3,"South");
//        处理第二张卡片
        jPanelM1_jb1 = new JButton("我的好友");
        jPanelM1_jb1.addActionListener(this);
        jPanelM1_jb2 = new JButton("陌生人");
        jPanelM1_jb3 = new JButton("黑名单");
        jScrollPane2 = new JScrollPane(jPanelM1_jb2);

        jPanelM1 = new JPanel(new BorderLayout());
        jPanelM2 = new JPanel(new GridLayout(20,1,4,4));
        jPanelM3 = new JPanel(new GridLayout(2,1));
        JLabel[] jbls2 = new JLabel[20];
        for (int i=0;i<jbls2.length;i++){
            jbls2[i] = new JLabel(("陌生人："+i+1)+"",(new ImageIcon("images/mm.jpg")),JLabel.LEFT);
            jbls2[i].addMouseListener(this);
            jPanelM2.add(jbls2[i]);
        }
        jScrollPane2 = new JScrollPane(jPanelM2);
        jPanelM3.add(jPanelM1_jb1);
        jPanelM3.add(jPanelM1_jb2);

        jPanelM1.add(jPanelM3,"North");
        jPanelM1.add(jScrollPane2,"Center");
        jPanelM1.add(jPanelM1_jb3,"South");

//        卡片布局
        this.setLayout(cardLayout);
        this.add(jPanel1,"1");
        this.add(jPanelM1,"2");
        this.setTitle(myId);
        this.setSize(250,400);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        QQFriendList one = new QQFriendList();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jPanel1_jb2){
            cardLayout.show(this.getContentPane(),"2");
        }
        if(e.getSource() == jPanelM1_jb1){
            cardLayout.show(this.getContentPane(),"1");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        得到好友编号
        if(e.getClickCount() >= 2){
            String num = ((JLabel)e.getSource()).getText();
            QQChat one = new QQChat(this.myId,num);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel)e.getSource();
        jLabel.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel)e.getSource();
        jLabel.setForeground(Color.BLACK);
    }
}
