package swing;

import javax.swing.*;
import java.awt.*;

// 通过在main方法中创建一个JPanel对象，来展示如何使用JPanel类
public class d_JPanel {
    public static void main(String[] args){
        // Create JFrame
        JFrame frame = new JFrame();
        frame.setTitle("d_JPanel Example");
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        // Create Panel
        JPanel redPanel = new JPanel();
        JPanel bluePanel = new JPanel();
        JPanel greenPanel = new JPanel();
        // Set the panel background color
        redPanel.setBackground(Color.RED);
        bluePanel.setBackground(Color.BLUE);
        greenPanel.setBackground(Color.GREEN);
        // Set the panel size
        redPanel.setBounds(0,0,250,250);
        bluePanel.setBounds(250,0,250,250);
        greenPanel.setBounds(0,250,500,250);
        // Add the panel to the frame
            // 需要设置frame的布局方式
        frame.setLayout(null);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);

        // Create components like labels
        JLabel label = new JLabel();
        label.setText("Oh, hi there!");
        ImageIcon icon = new ImageIcon("src/main/resources/BrainBoom.png");
        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        // add the label to the panel
        // 需要设置布局方式
            // 如果希望手动控制Label大小，需要设置布局方式为null（禁用布局管理器）
            // 设置label的大小，默认情况是占据整个panel，然后设置Label中的内容相对位置
        label.setBounds(50,100,200,200);
        greenPanel.setLayout(null);
        greenPanel.add(label);

            // 如果希望自动调整Label大小，只是设置Label的相对位置关系，需要设置布局方式为BorderLayout
            // 设置label中的内容相对位置关系
//        greenPanel.setLayout(new BorderLayout());
//        greenPanel.add(label);

        frame.setVisible(true);

    }
}
