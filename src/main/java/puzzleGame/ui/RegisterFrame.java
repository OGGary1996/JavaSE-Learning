package puzzleGame.ui;

import javax.swing.*;

public class RegisterFrame extends JFrame {
    public RegisterFrame (){
        // 设置界面的标题、大小、是否可调整大小、是否可见、关闭操作
        this.setTitle("Register");
        this.setSize(488,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置界面居中显示
        this.setLocationRelativeTo(null);

        this.setVisible(true);

    }
}
