package swing;

// 通过直接在main方法中创建一个Label对象，来展示如何使用Label类
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class c_JLabel {
    public static void main(String[] args){
        // 创建一个JFrame对象
        JFrame frame = new JFrame();
        // 设置窗口标题
        frame.setTitle("c_JLabel Example");
        // 设置窗口大小
        frame.setSize(500, 500);
        // 设置窗口可见
        frame.setVisible(true);
        // 设置窗口关闭时的操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个JLabel对象
        JLabel label = new JLabel();
        // 设置label的文本
        label.setText("Bro, do you even code?");
        // 设置图标/图标
        ImageIcon icon = new ImageIcon("src/main/resources/pic1.png");
        label.setIcon(icon);

        // 将label添加到frame中
        frame.add(label);

        // 调整文本与图像的相对位置
        label.setHorizontalTextPosition(JLabel.CENTER); // 将文本放置在图像的中心/右侧/左侧
        label.setVerticalTextPosition(JLabel.BOTTOM); // 将文本放置在图像的底部/顶部

        // 设置Text和图像的间距
        label.setIconTextGap(50); // 设置Text和图像的间距

        // 设置text的颜色
        label.setForeground(new Color(0X00FF00)); // 设置text的颜色
        // 设置text的字体
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // 设置text的字体

        // 设置label的背景颜色
        label.setBackground(Color.BLACK);
        // 设置label的透明度
        label.setOpaque(true);

        // 设置label的边框
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        label.setBorder(border);

        // 设置label的对齐方式
        label.setHorizontalAlignment(JLabel.CENTER); // 设置label的水平对齐方式
        label.setVerticalAlignment(JLabel.CENTER); // 设置label的垂直对齐方式

        // 设置label的大小
        label.setBounds(100, 100, 300, 300); // 设置label的位置和大小
        frame.setLayout(null); // 设置frame的布局方式



    }
}
