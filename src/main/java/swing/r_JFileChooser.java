package swing;

import javax.swing.*;

public class r_JFileChooser {
    public static void main(String[] args){
        // create a frame
        JFrame frame = new JFrame("FileChooser Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // create JMenuBar
        JMenuBar menuBar = new JMenuBar();
            // create JMenu
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenu exit = new JMenu("Exit");
            // create JMenuItem
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveTo = new JMenuItem("Save to ...");
        JMenuItem about = new JMenuItem("About");

        // add action listener to the menu items
        open.addActionListener(e->{
            // create a file chooser
            JFileChooser fileChooser = new JFileChooser();
            // set the current directory to project directory
            fileChooser.setCurrentDirectory(new java.io.File("."));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(null,
                        "You have selected: " + fileChooser.getSelectedFile().getName(),
                        "File Selected",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        save.addActionListener(e->{
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(null,
                        "You have saved: " + fileChooser.getSelectedFile().getName(),
                        "File Saved",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        saveTo.addActionListener(e->{
            JFileChooser fileChooser = new JFileChooser();
            // set the choose mode to directories only
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(null,
                        "You have saved to: " + fileChooser.getSelectedFile().getName(),
                        "File Saved",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exit.addActionListener(e->{
            System.exit(0);
        });


        // add menu items to the menu
        file.add(open);
        file.add(save);
        file.add(saveTo);
        help.add(about);
        menuBar.add(file);
        menuBar.add(help);
        menuBar.add(exit);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);


    }
}
