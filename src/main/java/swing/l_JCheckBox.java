package swing;

import javax.swing.*;
import java.awt.*;

public class l_JCheckBox {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle("l_JCheckBox Example");
        frame.setLayout(new BorderLayout());

        // crate a checkbox
        JCheckBox check = new JCheckBox();
        check.setPreferredSize(new Dimension(100, 50));
        check.setText("R U a robot?");
        check.setFont(new Font("Consolas", Font.PLAIN, 20));
        ImageIcon blank = new ImageIcon("src/main/resources/Blank.png");
        ImageIcon checked = new ImageIcon("src/main/resources/Checked.png");
        check.setIcon(blank); // 设置未选中时的图标
        check.setSelectedIcon(checked); // 设置选中时的图标

        // add action listener
            // 通过点击button来判断是否选项
        JButton button = new JButton("Submit");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            if (check.isSelected()){
                JOptionPane.showMessageDialog(null,
                        "U R a robot!",
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null,
                        "U R not a robot!",
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
            // 直接为check添加ItemListener
//        check.addActionListener(e -> {
//            if (check.isSelected()){
//                JOptionPane.showMessageDialog(null,
//                    "U R a robot!",
//                    "Status",
//                    JOptionPane.INFORMATION_MESSAGE);
//            }else if (!check.isSelected()){
//                JOptionPane.showMessageDialog(null,
//                        "U R not a robot!",
//                        "Status",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//        });

        // add the button and check box to the frame
        frame.add(button, BorderLayout.SOUTH);
        frame.add(check, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
