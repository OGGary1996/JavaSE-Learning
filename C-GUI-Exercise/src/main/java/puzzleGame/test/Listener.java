package puzzleGame.test;

// 如果要想创建一个监听器，有两种方法：
    // 1.使用需要创建listener的类来实现ActionListener,MouseListener等接口。
    // 2.使用匿名内部类将实现了ActionListener,MouseListener等接口的对象传递给需要监听的组件。

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener extends JFrame {
    JButton button = new JButton("Click me!");

    public Listener (){
        initFrame();
        initButton();
        this.setVisible(true);
    }

    public void initFrame(){
        this.setTitle("监听器");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
    }

    public void initButton() {
        button.setBounds(150,150,100,50);
        // 添加监听器
        button.addActionListener( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });
        // 添加按钮到JFrame中
        this.add(button);
    }

    public static void main(String[] args) {
        new Listener();
    }
}
