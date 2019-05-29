package com.qq.client.view;

import com.qq.client.common.User;
import com.qq.client.model.QQClientUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQClientLogin extends JFrame implements ActionListener {
    JLabel jLabel1 = null;

    JTabbedPane jtp = null;
    JPanel jp1,jp2,jp3;
    JLabel jp1_jlb1,jp1_jlb2,jp1_jlb3,jp1_jlb4;
    JButton jp1_jb;
    JTextField jp1_jtf;
    JPasswordField jp1_jpsw;
    JCheckBox jp1_jcb1,jp1_jcb2;

    JPanel jpl = null;
    JButton jpl_jb1 = null;
    JButton jpl_jb2 = null;
    JButton jpl_jb3 = null;

    public QQClientLogin(){
//        处理北部
        jLabel1 = new JLabel(new ImageIcon("images/tou.gif"));
//        中部
        jtp = new JTabbedPane();
        jp1 = new JPanel();
        jp2 = new JPanel(new GridLayout(3,3));
        jp3 = new JPanel();
        jp1_jlb1 = new JLabel("QQ号码",JLabel.CENTER);
        jp1_jlb2 = new JLabel("QQ密码",JLabel.CENTER);
        jp1_jlb3 = new JLabel("忘记密码",JLabel.CENTER);
        jp1_jlb3.setForeground(Color.BLUE);
        jp1_jlb4 = new JLabel("申请密码保护",JLabel.CENTER);
        jp1_jlb4.setForeground(Color.BLUE);
        jp1_jb = new JButton(new ImageIcon("images/clear.gif"));
        jp1_jpsw = new JPasswordField();
        jp1_jtf = new JTextField();
        jp1_jcb1 = new JCheckBox("隐身登入");
        jp1_jcb2 = new JCheckBox("记住密码");
//        按照要求加入JPanel
        jp2.add(jp1_jlb1);
        jp2.add(jp1_jtf);
        jp2.add(jp1_jb);
        jp2.add(jp1_jlb2);
        jp2.add(jp1_jpsw);
        jp2.add(jp1_jlb3);
        jp2.add(jp1_jcb1);
        jp2.add(jp1_jcb2);
        jp2.add(jp1_jlb4);

        jtp.add("QQ号码",jp2);
        this.add(jtp);
//        处理南部
        jpl = new JPanel(new FlowLayout());
        jpl_jb1 = new JButton(new ImageIcon("images/denglu.gif"));
        jpl_jb1.addActionListener(this);
        jpl_jb2 = new JButton(new ImageIcon("images/quxiao.gif"));
        jpl_jb3 = new JButton(new ImageIcon("images/xiangdao.gif"));
        jpl.add(jpl_jb1);
        jpl.add(jpl_jb2);
        jpl.add(jpl_jb3);

        this.add(jLabel1,"North");
        this.add(jpl,"South");
        this.setSize(350,240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("登入");
        this.setIconImage(new ImageIcon("images/qq.gif").getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        QQClientLogin one = new QQClientLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpl_jb1){
//            实现登入，进行响应
            QQClientUser qqClientUser = new QQClientUser();
            User user = new User();
            user.setUid(jp1_jtf.getText().trim());
//            本身是一个字符数组，强制转换陈该字符串
            user.setPassword(new String(jp1_jpsw.getPassword()));
            if(qqClientUser.checkUser(user) == true){
//                验证成功，同时关闭登入界面
                QQFriendList qqFriendList = new QQFriendList(user.getUid());
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"用户名密码错误");
            }
        }
    }
}
