package puzzleGame.test;

public class Test {
    public static void main(String[] args) {
        // 把一位数组中的数据0-15顺序打乱，然后按照4个一组放入二维数组中
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // 打乱数组
        for (int i = 0 ; i < tempArr.length ; i++){
            // 生成随机数索引
            int randomIndex = (int) (Math.random() * tempArr.length);
            // 交换位置
            int temp = tempArr[i];
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        // 遍历数组进行验证
        for (int i = 0 ; i < tempArr.length ; i++){
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();

        // 添加到二维数组中
        int[][] matrix = new int[4][4];
        for (int i = 0 ; i < tempArr.length ; i++){
            int row = i / 4;
            int col = i % 4; // 因为定义为int类型，所以会自动向下取整
            matrix[row][col] = tempArr[i];
        }
        // 遍历二维数组进行验证
        for (int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
