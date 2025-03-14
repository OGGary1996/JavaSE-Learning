package puzzleGame.ui;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener, ActionListener {
    // 设置JMenuItem
    JMenuItem changePic = new JMenuItem("Change Picture");
    JMenuItem restart = new JMenuItem("Restart");
    JMenuItem reLogin = new JMenuItem("Re-login");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem author = new JMenuItem("Author");

    // 定义用于打乱图片的数组
    int[][] matrix = new int[4][4];
    // 定义用于判定胜利与否的数组，如果matrix中的值与这个数组相同，则表示胜利
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    // x，y坐标用于记录空白的图片在matrix中的位置，当一位数组转换为二维数组时，读取到的值
    int x;
    int y;
    // 定义图像的路径
    String imagePath = "src/main/resources/puzzleGame/animal/animal1/";
    // 计步器
    int step = 0;


    // 初始化游戏界面
    public GameFrame(){
        // 初始化界面
        initJFrame();
        // 初始化菜单栏
        initJMenuBar();
        // 初始化二维数组为打乱图片做准备
        initData();
        // 初始化游戏面板，并打乱图片
        initImage();


        this.setVisible(true);
    }

    private void initJFrame() {
        // 设置界面的标题、大小、是否可调整大小、是否可见、关闭操作
        this.setTitle("Puzzle Game V1.0");
        this.setSize(603,680);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置界面在最上层
        this.setAlwaysOnTop(true);
        // 设置界面居中显示
        this.setLocationRelativeTo(null);
        // 取消默认的布局方式
        this.setLayout(null);

        // 在全局设置键盘监听器
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        // 设置JMenuBar
        JMenuBar menuBar = new JMenuBar();
        // 设置JMenu
        JMenu function = new JMenu("Function->");
        JMenu aboutUs = new JMenu("About Us->");

        // 设置层级添加
        function.add(changePic);
        function.add(restart);
        function.add(reLogin);
        function.add(close);
        aboutUs.add(author);
        menuBar.add(function);
        menuBar.add(aboutUs);

        this.setJMenuBar(menuBar);

        // 添加监听器
        changePic.addActionListener(this);
        restart.addActionListener(this);
        reLogin.addActionListener(this);
        close.addActionListener(this);
        author.addActionListener(this);

    }

    private void initData() {
        // 把一位数组中的数据0-15顺序打乱，然后按照4个一组放入二维数组中
        int[] tempArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        // 打乱数组
        for (int i = 0 ; i < tempArr.length ; i++){
            // 生成随机数索引
            int randomIndex = (int) (Math.random() * tempArr.length);
            // 交换位置
            int temp = tempArr[i];
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        // 添加到二维数组中
        matrix = new int[4][4];
        for (int i = 0 ; i < tempArr.length ; i++){
            if(tempArr[i] == 16) { // 如果是空白的图片，则记录下图片的坐标
                x = i / 4;
                y = i % 4;
            }
            int row = i / 4;
            int col = i % 4; // 因为定义为int类型，所以会自动向下取整
            matrix[row][col] = tempArr[i];
        }
    }


    private void initImage() {
        // 刷新界面时，先清空界面，因为后续操作需要更新整个界面，如果不先清除，则会放在最下方的图层
        this.getContentPane().removeAll();

        // 在每次调用initImage()方法时，先检查是否已经胜利，
        if (isWin()) {
            JLabel winImageLabel = new JLabel(new ImageIcon("src/main/resources/puzzleGame/win.png"));
            winImageLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winImageLabel);
        }
        // 添加计步器
        JLabel stepLabel = new JLabel("Step: " + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);


        // 图层添加顺序：先添加的图层在上层，后添加的图层在下层。
        // 使用循环来创建16个ImageIcon并且添加到JLabel中,将matrix的值作为图片的路径名称
        for (int i = 0 ; i < matrix.length ; i++){ // 在此也可以使用单循环
            for(int j = 0 ; j < matrix[0].length ; j++){
                // 创建ImageIcon对象
                ImageIcon imageIcon = new ImageIcon(imagePath + matrix[i][j] +".jpg");
                // 创建JLabel对象
                JLabel imageLabel = new JLabel(imageIcon);
                // 设置JLabel的位置和大小
                imageLabel.setBounds(j * 105 + 83,i * 105 + 134, 105,105);
                imageLabel.setBorder(new BevelBorder(BevelBorder.RAISED)); // set border as raised type using bevel border
                // 添加JLabel到JFrame中
                this.getContentPane().add(imageLabel);
            }
        }
        // 设置背景图片
        JLabel bgLabel = new JLabel(new ImageIcon("src/main/resources/puzzleGame/background.png"));
        bgLabel.setBounds(40,40,508,560);
        this.getContentPane().add(bgLabel);

        // 刷新界面
        this.getContentPane().repaint();
    }

    private void showAll(){ // 显示完整的图片
        // 删除现有的图片
        this.getContentPane().removeAll();
        // 添加计步器
        JLabel stepLabel = new JLabel("Step: " + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);
        // 将完整的图片放置在JFrame中覆盖现有的图片。
        JLabel completeImageLabel = new JLabel(new ImageIcon(imagePath + "all.jpg"));
        completeImageLabel.setBounds(83,134,420,420);
        completeImageLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.getContentPane().add(completeImageLabel);
        // 设置背景图片
        JLabel bgLabel = new JLabel(new ImageIcon("src/main/resources/puzzleGame/background.png"));
        bgLabel.setBounds(40,40,508,560);
        this.getContentPane().add(bgLabel);
        // 刷新界面
        this.getContentPane().repaint();
    }

    private boolean isWin(){
        for (int i = 0 ; i < matrix.length ; i ++){
            for (int j = 0 ; j < matrix[0].length ;j++){
                if (matrix[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // 通过这个监听事件来实现按下按键时显示完整的图片。
        // 按下A键时，显示完整的图片
        int code = e.getKeyCode();
        if (code == 65 || code == 97) { // 65是A的ASCII码，97是a的ASCII码
            showAll();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // 在这个方法中进行上下左右键盘录入的逻辑判断，是图片移动的主要逻辑
        // 如果此时判定为胜利，则不允许进行任何操作，直接return出去
        if (isWin()) {
            return;
        }

        int code = e.getKeyCode(); // 上：37， 下：38， 左：39， 右：40
        switch (code) {
            case KeyEvent.VK_UP: // 向上移动时，本质上是将空白的图片与其上面的图片进行交换，其上面的图片在matrix中的坐标为x-1,y
                if(x - 1 > -1){
                    //在matrix中交换位置16索引(x,y)和x-1,y的值
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[x - 1][y];
                    matrix[x - 1][y] = temp;
                    // 更新x,y坐标
                    x--;
                    // 更新计步器
                    step++;
                    // 刷新界面
                    initImage();
                }else{
                    System.out.println("Reach the border!");
                }
            break;
            case KeyEvent.VK_DOWN: // 向下移动时，本质上是将空白的图片与其下面的图片进行交换，其下面的图片在matrix中的坐标为x+1,y
                if(x + 1 < 4) {
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[x + 1][y];
                    matrix[x + 1][y] = temp;
                    x++;
                    step++;
                    initImage();
                }else{
                    System.out.println("Reach the border!");
                }
            break;
            case KeyEvent.VK_LEFT:// 向左移动时，本质上是将空白的图片与其左边的图片进行交换，其左边的图片在matrix中的坐标为x,y-1
                if (y - 1 > -1){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[x][y - 1];
                    matrix[x][y - 1] = temp;
                    y--;
                    step++;
                    initImage();
                }
            break;
            case KeyEvent.VK_RIGHT: // 向右移动时，本质上是将空白的图片与其右边的图片进行交换，其右边的图片在matrix中的坐标为x,y+1
                if (y + 1 < 4){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[x][y + 1];
                    matrix[x][y + 1] = temp;
                    y++;
                    step++;
                    initImage();
                }else{
                    System.out.println("Reach the border!");
                }
            break;
            case 65: // 按下A键时，显示完整的图片,但是释放A键时，完整的图片会消失并且重新显示打乱的图片
                initImage();
            break;
            case 97:
                initImage();
            break;
            case 87: // 按下W键时，直接将图片按顺序摆放,只需要将matrix中的值按顺序排列即可
                matrix = win;
                initImage();
            break;
            default:
                System.out.println("Invalid key pressed!\nPlease press A key to show all images!\nPress W to get answer!");
            break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == changePic) { // 询问用户更换到第几组图片 1-6
            String[] options = {"1", "2", "3", "4", "5", "6"};
            JComboBox<String> comboBox = new JComboBox<>(options);

            int result = JOptionPane.showConfirmDialog(this, comboBox,
                    "Please choose a picture group:", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                int selected = comboBox.getSelectedIndex();
                imagePath = "src/main/resources/puzzleGame/animal/animal" + (selected + 1) + "/";
                // Reset steps and reinitialize
                step = 0;
                initData();
                initImage();
            }
        }else if (source == restart) {
            step = 0;
            initData();
            initImage();
        } else if (source == reLogin) {
            new LoginFrame();
            this.setVisible(false);
        } else if (source == close) {
            System.exit(0);
        } else if (source == author) {
            JOptionPane.showMessageDialog(this, "Author: zhangke218659@Gmail.com");
        }

    }
}
