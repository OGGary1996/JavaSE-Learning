package puzzleGame.ui;

import javax.swing.*;

public class GameFrame extends JFrame {
    // 定义用于打乱图片的二维数组
    int[][] matrix = new int[4][4];

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
        this.setSize(800,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置界面在最上层
        this.setAlwaysOnTop(true);
        // 设置界面居中显示
        this.setLocationRelativeTo(null);
        // 取消默认的布局方式
        this.setLayout(null);
    }

    private void initJMenuBar() {
        // 设置JMenuBar
        JMenuBar menuBar = new JMenuBar();
        // 设置JMenu
        JMenu function = new JMenu("Function->");
        JMenu aboutUs = new JMenu("About Us->");
        // 设置JMenuItem
        JMenuItem changePic = new JMenuItem("Change Picture");
        JMenuItem restart = new JMenuItem("Restart");
        JMenuItem reLogin = new JMenuItem("Re-login");
        JMenuItem close = new JMenuItem("Close");
        JMenuItem author = new JMenuItem("Author");
        // 设置层级添加
        function.add(changePic);
        function.add(restart);
        function.add(reLogin);
        function.add(close);
        aboutUs.add(author);
        menuBar.add(function);
        menuBar.add(aboutUs);

        this.setJMenuBar(menuBar);
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
            int row = i / 4;
            int col = i % 4; // 因为定义为int类型，所以会自动向下取整
            matrix[row][col] = tempArr[i];
        }
    }


    private void initImage() {
        // 使用循环来创建16个ImageIcon并且添加到JLabel中,将matrix的值作为图片的路径名称
        for (int i = 0 ; i < matrix.length ; i++){ // 在此也可以使用单循环
            for(int j = 0 ; j < matrix[0].length ; j++){
                // 创建ImageIcon对象
                ImageIcon imageIcon = new ImageIcon("src/main/resources/puzzleGame/animal/animal1/" + matrix[i][j] +".jpg");
                // 创建JLabel对象
                JLabel imageLabel = new JLabel(imageIcon);
                // 设置JLabel的位置和大小
                imageLabel.setBounds(j * 105,i * 105 , 105,105);
                // 添加JLabel到JFrame中
                this.getContentPane().add(imageLabel);
            }

        }
    }
}
