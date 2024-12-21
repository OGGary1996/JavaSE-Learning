package swing;

import javax.swing.*;
import java.awt.*;

// 通过在main方法中创建一个GridLayout对象，来展示如何使用GridLayout类
public class g_GridLayout {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("g_GridLayout Example");
        frame.getContentPane().setBackground(java.awt.Color.BLACK);
        // 将frame的布局方式设置为GridLayout，并且设置行数和列数
        //frame.setLayout(new GridLayout(3,3,5,5));
        //如果行数或列数设置为 0，则 GridLayout 会动态调整布局：
        //	•	当列数为 0：行数固定，列数根据组件数量计算。
        //	•	当行数为 0：列数固定，行数根据组件数量计算。
        frame.setLayout(new GridLayout(0,3,5,5));


        // 创建并添加Button
        for (int i = 1 ; i <= 16 ; i++){
            frame.add(new JButton(Integer.toString(i)));
        }

        frame.setVisible(true);
    }
}
