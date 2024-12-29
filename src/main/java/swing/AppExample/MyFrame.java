package swing.AppExample;

import javax.swing.*;
import java.awt.*;

// 通过继承JFrame类，在构造函数中初始化窗口，可以自定义窗口
public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("MyFrame Example");

        this.setSize(500, 500);

        // 设置自动调整窗口大小，根据组件大小自动调整窗口大小，不需要设置setSize
        // this.pack();

        this.setVisible(true);

        //this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setBackground(java.awt.Color.RED);

        Color newColor = new Color(123, 50, 250);
        this.getContentPane().setBackground(newColor);

        Image appIcon = Toolkit.getDefaultToolkit().getImage("src/main/resources/Pony.png");
        Taskbar.getTaskbar().setIconImage(appIcon);

        this.setLayout(null);


    }
}
