package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class q_JMenuBar {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame("JMenuBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // create a JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // create a JMenu
        JMenu file = new JMenu("File");
            // create a sub menu <save> of file
        JMenu save = new JMenu("Save");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        // create a JMenuItem
        JMenuItem open = new JMenuItem("Open");
            // create sub menu items of save
        JMenuItem saveAsPDF = new JMenuItem("Save As PDF");
        JMenuItem saveAsText = new JMenuItem("Save As Text");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem about = new JMenuItem("About");

        // create a shortcut key for the menu item
        file.setMnemonic(KeyEvent.VK_F); // Alt + F
        open.setMnemonic(KeyEvent.VK_O); // Alt + O
        save.setMnemonic(KeyEvent.VK_S); // Alt + S
        saveAsPDF.setMnemonic(KeyEvent.VK_P);  // Alt + P
        saveAsText.setMnemonic(KeyEvent.VK_T);
        edit.setMnemonic(KeyEvent.VK_E);
        copy.setMnemonic(KeyEvent.VK_C);
        paste.setMnemonic(KeyEvent.VK_P);
        help.setMnemonic(KeyEvent.VK_H);
        about.setMnemonic(KeyEvent.VK_A);

        // add action listener to the menu items
        saveAsPDF.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Save successfully",
                    "Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        saveAsText.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Save successfully",
                    "Status",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "This is a simple text editor",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // add menu items to the menu and sub menu
        file.add(open);
        file.add(save);
        save.add(saveAsPDF);
        save.add(saveAsText);
        edit.add(copy);
        edit.add(paste);
        help.add(about);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        // add menu bar to the frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);



    }
}
