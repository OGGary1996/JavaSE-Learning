package swing.AppExample;

import javax.swing.*;
import java.awt.*;

public class MyButton1 extends JButton {
    public MyButton1(){
        this.setFocusable(false);
        this.setText("Do you?");
        this.setFont(new Font("Arial" , Font.BOLD, 20));
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.GREEN);
        this.setBounds(100, 200, 100, 50);

        this.addActionListener(e -> {
            System.out.println("Poo!");
        });
    }
}
