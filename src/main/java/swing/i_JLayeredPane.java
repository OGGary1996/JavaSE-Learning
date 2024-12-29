package swing;

import javax.swing.*;
import java.awt.*;

public class i_JLayeredPane {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JLayeredPane Example");
        frame.setSize(500,500);
        frame.setLayout(null);

        // create a label
        JLabel redLabel = new JLabel();
        redLabel.setBackground(Color.RED);
        redLabel.setOpaque(true);
        redLabel.setBounds(50,50,200,200);

        JLabel greenLabel = new JLabel();
        greenLabel.setBackground(Color.GREEN);
        greenLabel.setOpaque(true);
        greenLabel.setBounds(100,100,200,200);

        JLabel blueLabel = new JLabel();
        blueLabel.setBackground(Color.BLUE);
        blueLabel.setOpaque(true);
        blueLabel.setBounds(150,150,200,200);

        // create a layered pane
        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(50,25,400,400);
        // 与Label一样，修改背景色之后需要设置不透明，而Panel则不需要
        pane.setBackground(Color.BLACK);
        pane.setOpaque(true);
        pane.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        pane.setLayout(null);
        frame.add(pane);

        // add labels to the layered pane
            // 直接插入，按照顺序决定z坐标的高低
//        pane.add(redLabel);
//        pane.add(greenLabel);
//        pane.add(blueLabel);
            // 指定z坐标，越大越靠上，但是需要输入一个对象，所以需要一个Integer对象
        pane.add(redLabel, Integer.valueOf(5));
        pane.add(greenLabel,Integer.valueOf(6));
        pane.add(blueLabel,Integer.valueOf(7));

        frame.setVisible(true);

    }
}
