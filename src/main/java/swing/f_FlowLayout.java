package swing;

import javax.swing.*;
import java.awt.*;

// 通过在main方法中创建一个FlowLayout对象，来展示如何使用FlowLayout类，FlowLayout会将组件按照添加的顺序从左到右排列
public class f_FlowLayout {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("f_FlowLayout Example");
        frame.getContentPane().setBackground(Color.BLACK);
        // 将frame的布局方式设置为FlowLayout，并且设置组件之间的间距
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        // 创建Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        // 添加进入frame
            // 因为frame的layout为FlowLayout，所以panel的大小会根据内容自动调整，我们需要设置panel的偏好大小
        panel.setPreferredSize(new Dimension(200,200));
            // 添加进入frame
        frame.add(panel);

        // 创建Button同时添加进入Panel
            // 因为panel的layout为FlowLayout，所以button的大小会根据内容自动调整
            // 添加进入panel
        for (int i = 1 ; i <= 10 ; i++){
            panel.add(new JButton(Integer.toString(i)));
        }

        frame.setVisible(true);
    }
}
