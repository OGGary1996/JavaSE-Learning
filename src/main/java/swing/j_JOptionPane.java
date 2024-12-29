package swing;

import javax.swing.*;

public class j_JOptionPane {
    public static void main(String[] args) {
        // 创建基础的信息显示类型: showMessageDialog(),无返回值，按钮的类型默认为JOptionPane.DEFAULT_OPTION
            // 信息类型为JOptionPane.INFORMATION_MESSAGE
        JOptionPane.showMessageDialog(null, "This is a useless message", "Message Title", JOptionPane.INFORMATION_MESSAGE);
            // 消息类型为JOptionPane.WARNING_MESSAGE
        JOptionPane.showMessageDialog(null,"Warning Message","Title",JOptionPane.WARNING_MESSAGE);
            // 消息类型为JOptionPane.ERROR_MESSAGE
        JOptionPane.showMessageDialog(null,"Error Message","Title",JOptionPane.ERROR_MESSAGE);
            // 消息类型为JOptionPane.QUESTION_MESSAGE
        JOptionPane.showMessageDialog(null,"Do you code?","Title",JOptionPane.QUESTION_MESSAGE);


        // 创建需要用户确认的信息显示类型: showConfirmDialog()，返回值为用户点击的按钮，信息类型默认为JOptionPane.PLAIN_MESSAGE
            // 选项类型为JOptionPane.DEFAULT_OPTION （只有OK选项
        JOptionPane.showConfirmDialog(null,"Continue?","Title",JOptionPane.DEFAULT_OPTION);
            // 选项类型为JOptionPane.YES_NO_OPTION
        JOptionPane.showConfirmDialog(null,"Understood?","Title",JOptionPane.YES_NO_OPTION);
            // 选项类型为JOptionPane.YES_NO_CANCEL_OPTION
        JOptionPane.showConfirmDialog(null,"Do you want to exit?","Title",JOptionPane.YES_NO_CANCEL_OPTION);
            // 选项类型为JOptionPane.OK_CANCEL_OPTION
        JOptionPane.showConfirmDialog(null,"Do you want to exit?","Title",JOptionPane.OK_CANCEL_OPTION);


        // 创建需要用户输入的信息显示类型: showInputDialog(),返回值为用户输入的字符串，按钮类型为默认的JOptionPane.OK_CANCEL_OPTION
            // 输入类型为JOptionPane.PLAIN_MESSAGE
        JOptionPane.showInputDialog(null,"Enter your name","Title",JOptionPane.PLAIN_MESSAGE);
            // 输入类型为JOptionPane.INFORMATION_MESSAGE
        JOptionPane.showInputDialog(null,"Enter your name","Title",JOptionPane.INFORMATION_MESSAGE);


        // 创建完全自定义的的信息显示类型: showOptionDialog()
        // 完全自定义的对话框，可以自定义按钮，信息类型，选项类型，图标等
            // 创建图标
        ImageIcon icon = new ImageIcon("src/main/resources/Pony.png");
            // 按钮的Option
        String[] responses = {"No, you're awesome!","Thanks!","*blush*"};
            // 创建完全自定义的对话框
        JOptionPane.showOptionDialog(null,
                "You're awesome?",
                "Title",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                responses, // 自定义按钮的内容
                null);
    }
}
