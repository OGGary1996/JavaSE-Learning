package puzzleGame.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerImpl extends JFrame implements ActionListener {
    JButton button = new JButton("Click me!");

    public ListenerImpl (){
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

    public void initButton(){
        button.setBounds(150,150,100,50);
        // 添加监听器，既然本类已经实现了ActionListener接口，那么就可以直接传入this，使用this作为监听器的实现类传入
        button.addActionListener(this);
        // 添加按钮到JFrame中
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
}
