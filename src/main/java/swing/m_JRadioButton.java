package swing;

import javax.swing.*;
import java.awt.*;

public class m_JRadioButton {
    public static void main(String[] args){
        // crate a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("m_JRadioButton Example");
        frame.setLayout(new BorderLayout());
        // crate panel
        JPanel option = new JPanel();
        option.setBackground(Color.LIGHT_GRAY);
        option.setLayout(new GridLayout(1, 3));

        // create group of radio buttons
        JRadioButton pizza = new JRadioButton("Pizza");
        JRadioButton burger = new JRadioButton("Burger");
        JRadioButton hotdog = new JRadioButton("Hotdog");
        pizza.setPreferredSize(new Dimension(200, 100));
        burger.setPreferredSize(new Dimension(200, 100));
        hotdog.setPreferredSize(new Dimension(200, 100));
        pizza.setFont(new Font("Consolas", Font.PLAIN, 20));
        burger.setFont(new Font("Consolas", Font.PLAIN, 20));
        hotdog.setFont(new Font("Consolas", Font.PLAIN, 20));
            // set icon of each button
        ImageIcon pizzaIcon = new ImageIcon("src/main/resources/pizza.png");
        ImageIcon burgerIcon = new ImageIcon("src/main/resources/burger.png");
        ImageIcon hotdogIcon = new ImageIcon("src/main/resources/hotdog.png");
        pizza.setIcon(pizzaIcon);
        burger.setIcon(burgerIcon);
        hotdog.setIcon(hotdogIcon);
            // group the radio buttons
        ButtonGroup lunchGroup = new ButtonGroup();
        lunchGroup.add(pizza);
        lunchGroup.add(burger);
        lunchGroup.add(hotdog);

        // add action listener
            // 通过点击button来判断是否选项
        JButton button = new JButton("Submit");
        button.addActionListener(e -> {
            if (pizza.isSelected()){
                JOptionPane.showMessageDialog(null,
                        "You chose " + pizza.getText(),
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE,
                        pizzaIcon);
            }else if (burger.isSelected()){
                JOptionPane.showMessageDialog(null,
                        "You chose " + burger.getText(),
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE,
                        burgerIcon);
            }else if (hotdog.isSelected()){
                JOptionPane.showMessageDialog(null,
                        "You chose " + hotdog.getText(),
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE,
                        hotdogIcon);
            }
        });

            // 直接为radio button添加ItemListener
//        pizza.addActionListener(e -> {
//            JOptionPane.showMessageDialog(null,
//                    "You chose " + pizza.getText(),
//                    "Status",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });
//        burger.addActionListener(e -> {
//            JOptionPane.showMessageDialog(null,
//                    "You chose " + burger.getText(),
//                    "Status",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });
//        hotdog.addActionListener(e -> {
//            JOptionPane.showMessageDialog(null,
//                    "You chose " + hotdog.getText(),
//                    "Status",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });

        // add the button and radio buttons to the frame
        option.add(pizza);
        option.add(burger);
        option.add(hotdog);
        frame.add(option, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
