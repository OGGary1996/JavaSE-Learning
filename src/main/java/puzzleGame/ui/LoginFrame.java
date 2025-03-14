package puzzleGame.ui;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame(){
        // 设置界面的标题、大小、是否可调整大小、是否可见、关闭操作
        this.setTitle("Login");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置界面居中显示
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
