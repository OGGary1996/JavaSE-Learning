package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// 通过直接在main方法中创建一个Label对象，来展示如何使用Label类
public class b_JLabel {
    public static void main(String[] args){
        // 创建一个JFrame对象
        JFrame frame = new JFrame();
        // 设置窗口标题
        frame.setTitle("b_JLabel Example");
        // 设置窗口大小
        frame.setSize(500, 500);
        // 设置窗口关闭时的操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个JLabel对象
        JLabel label = new JLabel();
        // 设置label的文本
        label.setText("Bro, do you even code?");
        // 设置图标/图标
        ImageIcon icon = new ImageIcon("src/main/resources/pic1.png");
        label.setIcon(icon);
        // 调整文本与图像的相对位置
        label.setHorizontalTextPosition(JLabel.CENTER); // 将文本放置在图像的中心/右侧/左侧
        label.setVerticalTextPosition(JLabel.BOTTOM); // 将文本放置在图像的底部/顶部
        // 设置Text和图像的间距
        label.setIconTextGap(50); // 设置Text和图像的间距
        // 设置Label的中整体元素在Label中的位置
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        // 设置text的颜色
        label.setForeground(new Color(0X00FF00)); // 设置text的颜色
        // 设置text的字体
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // 设置text的字体
        // 设置label的背景颜色
        label.setBackground(Color.BLACK);
        // 设置label的透明度,使得背景颜色生效
        label.setOpaque(true);
        // 设置label的边框
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        label.setBorder(border);

        // 添加Label进Frame
        // 需要设置Frame的布局方式：
            // 如果希望手动控制Label大小，需要设置布局方式为null（禁用布局管理器）
            // 设置label的大小，默认情况是占据整个Frame,然后设置Label中的内容相对位置
//        label.setBounds(100, 100, 300, 300);
//        frame.setLayout(null);
//        frame.add(label);

            // 如果希望自动调整Label大小，只是设置Label的相对位置关系，需要设置布局方式为BorderLayout
            // 如果希望在BorderLayout下设置Label的大小，可以设置偏好大小
            // label.setPreferredSize(new Dimension(500, 500));
            // 设置label中的内容相对位置关系
        frame.setLayout(new BorderLayout());
        frame.add(label);
        frame.setVisible(true);
    }
}
