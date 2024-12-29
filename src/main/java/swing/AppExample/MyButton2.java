package swing.AppExample;

import javax.swing.*;

public class MyButton2 extends JButton {
    public MyButton2(){
        this.setFocusable(false);
        this.setText("Exit");
        this.setFont(new java.awt.Font("Arial" , java.awt.Font.BOLD, 20));
        this.setBackground(java.awt.Color.DARK_GRAY);
        this.setForeground(java.awt.Color.GREEN);
        this.setBounds(200, 200, 100, 50);

        this.addActionListener(e -> {
            System.exit(0);
        });
    }
}
