package training.tutorial;

public class g_array1 {

	public static void main(String[] args) {

		// Array 数组 长度固定 同类型元素 基于index访问和修改
		// array中只能存储同一种数据类型
		
		//声明数组 1、直接给定初始化的值，2、给一个空的array，但需要指定长度
		int[] nums1 = {1,2,3,4,5,6,7};
		int[] nums2 = new int[4]; // 空的array 元素默认为0，但是长度固定为4，从0开始，0-3.
		// 访问 index从0开始
		System.out.println(nums1[0]);
		System.out.println(nums2[3]);
		// 修改
		nums1[1] = 3;
		System.out.println(nums1[1]);
		// 遍历 可在遍历数组时进行修改或访问
			// 随机生成elements 使用遍历插入elements
		for (int i = 0 ; i < 4 ; i++ ) {
			nums2[i] = (int)(Math.random() * 100);
			System.out.print(nums2[i] + " ");
		}
			//for
		for (int j = 0 ; j < nums1.length ; j++) { // 这里j代表了数组的索引，通过索引来查找
			System.out.println(nums1[j]);
		}
			// enhanced for
		for (int k : nums2) { // k 代表了nums2里面的元素,将元素赋值给k，直接输出的元素的值
			System.out.println(k);
		}
		
		
		// multiple dimensional array
		
		// 声明多维数组 使用[][],第一个[]表示行，第二个[]表示列
		int[][] nums4 = new int[3][4]; // 新声明一个3行4列的多维数组，0-2;0-3.
		
		// 访问
		System.out.println(nums4[2][3]);
		// 修改
		nums4[2][3] = 5;
		// 遍历 可在遍历时进行修改或访问
			// 随机插入elements 使用class math 中的 .random()方法
		for (int i = 0; i < 3 ; i++) {
			for (int j = 0 ; j < 4 ; j++) {
				nums4[i][j] = (int)(Math.random() * 100);
				System.out.print(nums4[i][j] + " ");
			}
			System.out.println();
		}
			// nested for
		for (int j = 0 ; j < 3 ; j++ ) {
			for (int k = 0 ; k < 4 ; k++) {
				System.out.print(nums4[j][k] + " "); //j k 代表了索引，结果通过索引来输出。
			}
			System.out.println();
		}
			// enhanced for
		for (int[] n : nums4) { // n[] 代表了提取一个多维数组中的一行数组
			for (int m : n) { // m 代表了 n数组 中的每一个elements
				System.out.print(m + " "); // m 表示元素本身，通过赋值给m，直接输出结果
			}
			System.out.println();
		}

		
		// 3D array
		// create 
		int[][][] nums5 = new int[3][4][4];
		System.out.println(nums5[0][1][2]);
		
		
		// jagged array 先不指定列
		// create 
		int[][] nums6 = new int[3][];
		nums6[0] = new int[3];
		nums6[1] = new int[4];
		nums6[2] = new int[2];
		// 随机赋值
		for (int i = 0 ; i < nums6.length ; i++ ) {
			for (int j = 0 ; j < nums6[i].length ; j++) {
				nums6[i][j] = (int)(Math.random()*100);
				System.out.print(nums6[i][j] + " ");
			}
			System.out.println();
		}
		// 遍历
		for (int[] n :nums6) {
			for (int m:n) {
				System.out.print(m + " ");
			}
			System.out.println();
		}
		
	}

}
