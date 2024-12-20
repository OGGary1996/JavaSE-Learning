package swing;
import javax.swing.*;
import java.awt.*;

// 通过直接在Main方法中创建JFrame对象，可以快速创建窗口

public class a_JFrame {
    public static void main(String[] args){
        // Create a frame
        JFrame frame = new JFrame();

        // Set the frame title
        frame.setTitle("a_JFrame Example");

        // Set the frame size
        frame.setSize(800, 800); // width, height

        // Make the frame visible
        frame.setVisible(true);

        // 默认情况下关闭窗口时，程序不会退出，只是隐藏窗口
        // frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置是否可以手动调节窗口大小
            // 默认情况下为true
        frame.setResizable(false);

        // 设置窗口左上角的图标
            // 默认情况下为null
            // step1. 创建ImageIcon对象
        ImageIcon logo = new ImageIcon("src/main/resources/pic4.png");
            // step2. 设置图标
        frame.setIconImage(logo.getImage());

        // 修改App图标
            //step1. 创建Image对象
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/pic4.png");
            //step2. 设置图标
        Taskbar.getTaskbar().setIconImage(image);


        // 替换背景颜色
            // 设置title bar的颜色
        frame.setBackground(Color.RED);
            // 设置背景颜色
        frame.getContentPane().setBackground(Color.BLACK);
            // 自定义RGB颜色
        Color newColor = new Color(50, 50, 50);
        frame.getContentPane().setBackground(newColor);

    }
}
