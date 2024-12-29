package swing;

import javax.swing.*;
import java.awt.*;

public class p_JProgressBar {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame("JProgressBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // create a JProgressBar
        JProgressBar progress = new JProgressBar();
        progress.setOrientation(SwingConstants.HORIZONTAL);// 设置方向,默认是水平方向
        progress.setMinimum(0); // 设置最小值
        progress.setMaximum(100); // 设置最大值
        progress.setValue(0); // 设置初始的值
        progress.setStringPainted(true); // 设置是否显示进度百分比
        progress.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // 设置字体
        progress.setForeground(Color.RED); // 设置前景色
        progress.setBackground(Color.BLACK); // 设置背景色
        progress.setPreferredSize(new Dimension(400,150)); // 设置大小

        // 将进度条设置为递增
            // 通过按钮模拟进度条的增长
        JButton button = new JButton("increase");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            int value = progress.getValue();
            if (value < 100 ){
                progress.setValue(value + 10);
            }else{
                button.setEnabled(false); // 当进度条到达100时，按钮不可用
                progress.setString("We are done!"); // 设置进度条的文本
            }
        });
            // 通过线程模拟进度条的增长
        Runnable thread = () -> {
            int value = progress.getValue();
            while(value < 100){
                value += 5;
                progress.setValue(value);
                try{
                    Thread.sleep(250);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if (value == 100){
                progress.setString("We are done!");
            }
        };
        Thread t = new Thread(thread);

        JButton threadButton = new JButton("StartThread");
        threadButton.setPreferredSize(new Dimension(100, 50));
        threadButton.addActionListener(e -> {
            t.start();
        });

        // add progress bar to frame
        frame.add(progress,BorderLayout.CENTER);
        frame.add(button, BorderLayout.EAST);
        frame.add(threadButton, BorderLayout.WEST);
        frame.setVisible(true);

    }
}
