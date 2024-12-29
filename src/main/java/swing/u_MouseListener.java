package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class u_MouseListener {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame("MouseListener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new BorderLayout());

        // create a label
        JLabel faceLabel = new JLabel();
        faceLabel.setPreferredSize(new Dimension(800,800));
        ImageIcon face = new ImageIcon("src/main/resources/happy.png");
        faceLabel.setIcon(face);
        faceLabel.setHorizontalAlignment(JLabel.CENTER);
        faceLabel.setVerticalAlignment(JLabel.CENTER);

        // add the mouse listener to the label
        faceLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                faceLabel.setIcon(new ImageIcon("src/main/resources/enjoy.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                faceLabel.setIcon(new ImageIcon("src/main/resources/cry.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                faceLabel.setIcon(new ImageIcon("src/main/resources/happy.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                faceLabel.setIcon(new ImageIcon("src/main/resources/shock.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                faceLabel.setIcon(new ImageIcon("src/main/resources/happy.png"));
            }
        });

        // add label to the frame
        frame.add(faceLabel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
