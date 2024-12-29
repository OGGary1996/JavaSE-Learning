package swing;

import javax.swing.*;
import java.awt.*;

public class k_TextField {
    public static void main(String[] args){
        // create a frame
            // 本例中不设置frame的大小，frame的大小由组件决定，使用pack()方法，但必须保证组件大小已经设置并添加到frame中
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("k_TextField Example");
        frame.setLayout(new BorderLayout());

        // create a button
        JButton button = new JButton("Register");
        button.setPreferredSize(new Dimension(100, 50));

        // create a text field
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 50));
        textField.setBackground(Color.BLACK);
        textField.setFont(new Font("Consolas",Font.PLAIN, 30));
        textField.setForeground(Color.GREEN);
        textField.setCaretColor(Color.WHITE); // 设置光标的颜色
        // set default text
        textField.setText("Username:");
        // set the text alignment
        textField.setHorizontalAlignment(JTextField.CENTER);

        // add the button and text field to the frame
        frame.add(button,BorderLayout.SOUTH);
        frame.add(textField,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // add an action listener to the button and the text field
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Registered successfully!",
                    "Status",
                    JOptionPane.INFORMATION_MESSAGE);
            button.setEnabled(false); // 禁用按钮
            textField.setEditable(false); // 禁用文本框编辑
        });

        textField.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Registered successfully!",
                    "Status",
                    JOptionPane.INFORMATION_MESSAGE);
            button.setEnabled(false); // 禁用按钮
            textField.setEditable(false); // 禁用文本框编辑
        });
    }
}
