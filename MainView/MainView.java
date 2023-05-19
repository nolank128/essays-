package MainView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PublicKey;

public class MainView {
    public JFrame jf;
    public JPanel panel;
    public JButton btn;
    public JTextArea txtChat;
    public JTextArea txtSend;
    public JLabel labelIP;
    public JLabel labelDK;
    public JTextField txtIP;
    public JTextField txtDK;

    public MainView(){
        jf=new JFrame("会话窗口");
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);

        Border border=BorderFactory.createLineBorder(Color.BLACK);

        //发送按钮
        btn =new JButton("发送");
        btn.setLocation(480,500);
        btn.setSize(80,40);

        //按钮监听
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取的事件源就是按钮本身

                try{
                    int DK =Integer.parseInt(txtDK.getText());
                    Socket socket=new Socket(txtIP.getText(),DK);

                    OutputStream os=socket.getOutputStream();

                    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));

                    String send=txtSend.getText();
                    bw.write(send);
                    bw.flush();
                    txtChat.append("发送的信息："+send+'\n');
                    bw.close();
                    socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });
        panel.add(btn);

        //发送窗口
        txtSend=new JTextArea();
        txtSend.setLocation(10,470);
        txtSend.setSize(460,75);
        txtSend.setBorder(border);
        panel.add(txtSend);

        //聊天窗口
        txtChat =new JTextArea();
        txtChat.setLocation(10,80);
        txtChat.setLocation(10,80);
        txtChat.setSize(460,350);
        txtChat.setBorder(border);

        panel.add(txtChat);

        //ip地址
        labelIP=new JLabel();
        labelIP.setText("目标IP地址：");
        labelIP.setBounds(10,10,80,25);
        panel.add(labelIP);

        txtIP=new JTextField();
        txtIP.setBounds(100,10,100,25);
        panel.add(txtIP);

        //端口号
        labelDK=new JLabel();
        labelDK.setText("目的端口号：");
        labelDK.setBounds(220,10,80,25);
        panel.add(labelDK);
        txtDK=new JTextField();
        txtDK.setBounds(300,10,100,25);
        panel.add(txtDK);

        //把面板容器作为窗口的内容面板设置到窗口
        jf.setContentPane(panel);

        //显示窗口，前面创建的信息都在内存中，通过jf.setContentPane()把内存中的窗口显示在屏幕中
        jf.setVisible(true);


    }
}
