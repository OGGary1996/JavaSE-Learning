package swing;

import javax.swing.*;
import java.awt.*;

// 通过在main方法中创建一个JButton对象，来展示如何使用JButton类
public class c_JButton {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("c_JButton Example");
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.BLACK);

        // 创建一个Label，但是初始状态不可见，只有在点击按钮后才会显示
        JLabel label = new JLabel();
        label.setBounds(150, 200, 200, 200);
        label.setText("Hello!");
        ImageIcon image = new ImageIcon("src/main/resources/HappyFace.png");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
        label.setVisible(false);

        // create a button
        JButton button = new JButton();
        // set button attributes
        button.setBounds(150, 100, 200, 100);
        button.setText("Click me!");
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);

        // add a icon to button
        ImageIcon icon = new ImageIcon("src/main/resources/Pony.png");
        button.setIcon(icon);
        // 调整icon和文字的相对位置
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        // 设置icon和文字的间距
        button.setIconTextGap(10);

        // add action listener to button
            // lambda表达式
        button.addActionListener(e->{
            System.out.println("Button clicked!");
            button.setEnabled(false); // 设置按钮失效
            label.setVisible(true);
        });
            // 完整的写法
//        ActionListener action = new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                System.out.println("Button clicked!");
//            }
//        };
//        button.addActionListener(action);

        // add button to frame
        frame.add(label);
        frame.add(button);

        frame.setVisible(true);

    }
}
