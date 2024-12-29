package swing;

import javax.swing.*;
import java.awt.*;
// 通过JButton中的ActionListener接口，可以实现点击按钮后打开新窗口
    // 本例中，直接在Main方法中创建两个frame，通过点击按钮控制frame的显示和关闭
    // 同样也可以单独创建frame类，通过按钮控制frame类的实例化，实现点击按钮后打开新窗口
public class c_JButtonOpenNewWindow {
    public static void main(String[] args) {
        // create main frame
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Main Menu");
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        // create a button
        JButton button = new JButton();
        button.setText("Open new window");
        button.setFont(new Font("Comic Sans", Font.BOLD, 10));
        button.setFocusable(false);
        button.setBounds(175, 200, 150, 50);
        // add button to frame
        mainFrame.add(button);
        mainFrame.setVisible(true);

        // create the new frame
        JFrame newFrame = new JFrame();
        newFrame.setTitle("New Window");
        newFrame.setSize(300, 300);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());
        // create the label of the new frame
        JLabel label = new JLabel();
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        label.setText("Bro, do you even code?");
        label.setFont(new Font("Comic Sans", Font.BOLD, 20));
        label.setForeground(Color.GREEN);
        ImageIcon image = new ImageIcon("src/main/resources/Panic.png");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        // add label to new frame
        newFrame.add(label);
        newFrame.setVisible(false);


        // add action listener to button
        button.addActionListener(e -> {
            //mainFrame.dispose();// 关闭主窗口
            button.setEnabled(false);// 设置按钮失效
            newFrame.setVisible(true);
        });





    }
}
