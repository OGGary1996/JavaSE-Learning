package swing.AppExample;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// 通过继承JLabel类，实现自定义标签
public class MyLabel extends JLabel {
    public MyLabel(){
        // set the text of the label
        this.setText("Bro, do you even code?");
        // set the icon of the label
        ImageIcon icon = new ImageIcon("src/main/resources/Panic.png");
        this.setIcon(icon);
        // set the horizontal text positions
        this.setHorizontalTextPosition(JLabel.CENTER);
        // set the vertical text position
        this.setVerticalTextPosition(JLabel.TOP);
        // set the icon text gap
        this.setIconTextGap(50);
        // set the text attributes
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setForeground(new Color(0X00FF00));
        // set the background color
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        // set the border of Label
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        this.setBorder(border);
        // set the alignment of the label
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        // set the size of the label
        this.setBounds(100, 100, 300, 300);
    }

}
