package training;

public class g_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Array 数组 长度固定 同类型元素 基于index访问和修改
		
		//声明数组 1、直接给定初始化的值，2、给一个空的array，但需要指定长度
		int nums1[] = {1,2,3,4,5,6,7};
		int nums2[] = new int[4]; // 空的array 元素默认为0，但是长度固定为4
		// 访问 index从0开始
		System.out.println(nums1[0]);
		System.out.println(nums2[3]);
		// 修改
		nums1[1] = 3;
		System.out.println(nums1[1]);
		// 遍历
			//for
		for (int i = 0 ; i < nums1.length ; i++) {
			System.out.println(nums1[i]);
		}
			// enhanced for
		for (int i:nums2) {
			System.out.println(nums2[i]);
		}
		
		
	}

}
