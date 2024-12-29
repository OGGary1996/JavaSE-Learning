package swing;

import javax.swing.*;
import java.awt.*;

public class n_JComboBox {
    public static void main(String[] args){
        // crate a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("n_JComboBox Example");
        frame.setLayout(new BorderLayout());
        // crate panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridLayout(1,3));

        // create a combo box
        String[] lunch = {"Pizza", "Burger", "Hotdog"};
        JComboBox<String> lunchBox = new JComboBox<>(lunch);
        lunchBox.setPreferredSize(new Dimension(200, 100));
//        lunchBox.setEditable(true); // 设置是否可以输入选项
        lunchBox.setSelectedIndex(0); // 设置初始默认选项

        // add action listener
            // 通过点击button来进行操作
        JButton button = new JButton("Submit");
        JButton remove = new JButton("Remove Selected");
        JButton add = new JButton("Add Item");
            // 提交选项
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "You chose No. " + lunchBox.getSelectedIndex() + lunchBox.getSelectedItem(),
                    "Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
            // 移除选项
        remove.addActionListener(e -> {
            lunchBox.removeItem(lunchBox.getSelectedItem());
        });
            // 添加选项，通过识别输入的字符串
        add.addActionListener(e -> {
            String newItem = JOptionPane.showInputDialog(null,
                    "Enter the item you want to add",
                    "Add Item",
                    JOptionPane.PLAIN_MESSAGE);
            lunchBox.addItem(newItem);
        });

            //通过直接为lunchBox添加ItemListener来进行操作
//        lunchBox.addItemListener(e -> {
//            JOptionPane.showMessageDialog(null,
//                    "You chose No. " + lunchBox.getSelectedIndex() + lunchBox.getSelectedItem(),
//                    "Status",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });


        // add the button and combo box to the frame
        panel.add(button);
        panel.add(remove);
        panel.add(add);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(lunchBox, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
