package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class t_KeyListener {
    public static void main(String[] args) {
        // create a frame
        JFrame frame = new JFrame("KeyListener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setLayout(null);
        // create a panel and set a background pic for it
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("src/main/resources/space.jpg");
                g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),null);
            }
        };
        panel.setBounds(0,0,1000,800);
        panel.setLayout(null);
        // create a label to show a spaceship
        JLabel label = new JLabel();
        ImageIcon spaceship = new ImageIcon("src/main/resources/spaceship.png");
        label.setIcon(spaceship);
        label.setBounds(450,350,100,100);
        // create a label to show user typing
        JLabel label2 = new JLabel();
        label2.setBackground(Color.WHITE);
        label2.setOpaque(true);
        label2.setBounds(900,0,100,800);

        // add the key listener to the whole frame
        frame.addKeyListener(new KeyListener() {
            @Override
            // 读取按下的键盘的字符，并显示在label2上
            public void keyTyped(KeyEvent e) {
                label2.setText(e.getKeyChar()+" ");
            }

            @Override
            // 通过按下键盘的w,s,a,d来控制飞船的移动
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'w'){
                    label.setLocation(label.getX(),label.getY()-10);
                } else if (e.getKeyChar() == 's'){
                    label.setLocation(label.getX(),label.getY()+10);
                } else if (e.getKeyChar() == 'a'){
                    label.setLocation(label.getX()-10,label.getY());
                } else if (e.getKeyChar() == 'd'){
                    label.setLocation(label.getX()+10,label.getY());
                }
            }

            @Override
            // 通过松开键盘的w,s,a,d来模拟飞船的惯性
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'w'){
                    for (int i = 0; i < 5; i++) {
                        label.setLocation(label.getX(),label.getY()-5);
                    }
                } else if(e.getKeyChar() == 's'){
                    for (int i = 0; i < 5; i++) {
                        label.setLocation(label.getX(),label.getY()+5);
                    }
                } else if(e.getKeyChar() == 'a'){
                    for (int i = 0; i < 5; i++) {
                        label.setLocation(label.getX()-5,label.getY());
                    }
                } else if(e.getKeyChar() == 'd'){
                    for (int i = 0; i < 5; i++) {
                        label.setLocation(label.getX()+5,label.getY());
                    }
                }
            }
        });

        // add all the components to the frame
        panel.add(label);
        panel.add(label2);
        frame.add(panel);
        frame.setVisible(true);
    }
}
