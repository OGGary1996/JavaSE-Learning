package swing;

import javax.swing.*;
import java.awt.*;

public class h_ExampleUsing3Layout {
    public static void main(String[] args){
        //create a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.setTitle("Example Using 3 Layout");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout(20,20));

        // create panels
            // top panel and buttons
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.GREEN);
        topPanel.setPreferredSize(new Dimension(600,300));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.add(new JButton("1"));
        topPanel.add(new JButton("2"));
        topPanel.add(new JButton("3"));
            // bottom panel and buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.RED);
        bottomPanel.setPreferredSize(new Dimension(600,300));
        bottomPanel.setLayout(new GridLayout(0,3,10,10));
        for (int i = 4; i < 12 ; i++) {
            bottomPanel.add(new JButton(Integer.toString(i)));
        }

        // add panels to frame
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(bottomPanel,BorderLayout.SOUTH);

        frame.setVisible(true);



    }
}
