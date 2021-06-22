package com.cyf.code.hard;

/**
 * @author ：caoyafei
 * @Date ：Created in 20:47 2019-02-16
 * @Desc ：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *
 * 分析：
 * 将问题拆分，对于每一个数组元素来说，该元素所能存储的水量等于
 * 该元素左边的最大值与右边的最大值（包括该元素）的二者最小作为上限，与该元素的值（高度）的差；
 * 因此，处理每个元素的存水量，然后求和即为总的存水量
 */
public class TrappingRainWater {

	public static int computeCount(int[] a) {
		int counter = 0;
		int n = a.length;

		for (int i = 1; i < n-1; i++) {
			int leftMax = 0;
			int rightMax = 0;

			// 寻找i左边最大值
			for (int j = i; j >=0 ; j--) {
				leftMax = Math.max(leftMax, a[j]);
			}

			//寻找i右边最大值
			for (int j = i; j < n; j++) {
				rightMax = Math.max(rightMax, a[j]);
			}

			counter += Math.min(leftMax, rightMax) - a[i];

		}

		return counter;
	}

	public static int computeCount2(int[] a){

		int counter = 0;
		int n = a.length;
		int maxIndex = 0;

		//找到最大值的下标
		for (int i = 1; i < n; i++) {
			if(a[i] > a[maxIndex]){
				maxIndex = i;
			}
		}

		for (int i = 0, leftMax = 0; i < maxIndex ; i++) {
			if(a[i] == leftMax){
				continue;
			}else if(a[i] > leftMax){
				leftMax = a[i];
			}else {
				counter += leftMax - a[i];
			}
		}

		for (int i = n-1, rightMax = 0; i > maxIndex ; i--) {
			if(a[i] == rightMax){
				continue;
			}else if(a[i] > rightMax){
				rightMax = a[i];
			}else {
				counter += rightMax - a[i];
			}
		}

		return counter;
	}

	public static int computeCount3(int[] a) {

		int len = a.length;

		if(len < 3){
			return 0;
		}

		int count = 0;

		//a[i] 前面的最大值
		int[] dp = new int[len];

		dp[0] = a[0];


		//初始化dp
		for (int i = 1; i < len; i++) {
			dp[i] = a[i] > dp[i - 1] ? a[i] : dp[i - 1];
		}

		int max = 0;
		for (int i = len - 1; i >= 0; i--) {

			max = Math.max(max, a[i]);
			dp[i] = Math.min(dp[i], max);
		}


		for (int i = 1; i < len - 1; i++) {
			if(dp[i] > a[i]){
				count = count + dp[i] - a[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		//int[] a = new int[]{5,4,1,2};
		//int[] a = new int[]{4,2,0,3,2,5};

		int count = computeCount3(a);

		System.out.println("可以接水的单位树：" + count);
	}
}
