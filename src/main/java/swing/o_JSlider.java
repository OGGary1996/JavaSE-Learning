package swing;

import javax.swing.*;
import java.awt.*;

public class o_JSlider {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("o_JSlider Example");
        frame.setLayout(new BorderLayout());
        // create a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());
        // create a slider
        JSlider slider = new JSlider(0,100,24);
        slider.setMajorTickSpacing(20); // 设置主刻度
        slider.setMinorTickSpacing(5); // 设置次刻度
        slider.setPaintTicks(true); // 设置是否显示刻度
        slider.setPaintTrack(true); // 设置是否显示轨道
        slider.setPaintLabels(true); // 设置是否显示标签
        slider.setOrientation(SwingConstants.VERTICAL); // 设置方向
        slider.setFont(new Font("Arial", Font.PLAIN, 15));

        // create a Label
        JLabel label = new JLabel("Current value: " + slider.getValue());
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.GREEN);
        ImageIcon faceIcon = new ImageIcon("src/main/resources/HappyFace.png");
        label.setIcon(faceIcon);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        // add change listener
        slider.addChangeListener(e -> {
            int currentValue = slider.getValue();
            label.setText("Current value: " + currentValue);
            if (currentValue > 24 && currentValue < 60){
                ImageIcon panicIcon = new ImageIcon("src/main/resources/Panic.png");
                label.setIcon(panicIcon);
            }else if (currentValue >= 60 && currentValue <= 100) {
                ImageIcon BrainIcon = new ImageIcon("src/main/resources/BrainBoom.png");
                label.setIcon(BrainIcon);
            }
        });
        // add slider to panel
        panel.add(label, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(slider, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
