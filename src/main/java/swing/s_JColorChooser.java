package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class s_JColorChooser {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame("JColorChooser Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        // create a label
        JLabel label = new JLabel();
        label.setBounds(100, 100, 300, 100);
        label.setText("Hello, World!");
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        // create a button
        JButton button1 = new JButton("Set Background Color");
        button1.setBounds(25, 300, 200, 50);
        JButton button2 = new JButton("Set Foreground Color");
        button2.setBounds(250, 300, 200, 50);

        // add action listener to the button
        button1.addActionListener(e->{
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null,"Pick a color", Color.BLACK);
            label.setBackground(color);
        });
        button2.addActionListener(e->{
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null,"Pick a color", Color.BLACK);
            label.setForeground(color);
        });

        // add components to the frame
        frame.add(label, BorderLayout.CENTER);
        frame.add(button1, BorderLayout.EAST);
        frame.add(button2, BorderLayout.WEST);
        frame.setVisible(true);
    }
}
