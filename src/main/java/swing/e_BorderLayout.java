package swing;

import javax.swing.*;
import java.awt.*;

// 通过设置JFrame的布局方式为BorderLayout，可以将组件放置在窗口的五个位置：North, South, East, West, Center
public class e_BorderLayout {
    public static void main(String[] args){
        // Create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("e_BorderLayout Example");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10,10)); // 设置组件之间的间距为10

        // Create Panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.BLUE);
        panel3.setBackground(Color.GREEN);
        panel4.setBackground(Color.YELLOW);
        panel5.setBackground(Color.ORANGE);


        // 将panel添加到frame的不同位置
            // 在BorderLayout中，如果不设置组件的偏好大小，组件会根据内容自动调整大小，如果为空的组件会不显示
            // 所以我们需要设置组件的偏好大小，使得组件显示
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

            // 添加进frame
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.WEST);
        frame.add(panel3,BorderLayout.CENTER);
        frame.add(panel4,BorderLayout.EAST);
        frame.add(panel5,BorderLayout.SOUTH);

        frame.setVisible(true);


    }
}
