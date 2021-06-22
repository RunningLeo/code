package com.cyf.code.sword_to_offer;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:23 2020-03-03
 * @Desc ：
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber03 {

	public static int findRepeatNumber(int[] nums) {


		for(int i = 0;i<nums.length;i++) {
			//每次交换至少让一个数字归位
			while(nums[i] != i) {
				int index = nums[i];
				if (index == nums[index]) {
					return nums[i];
				}

				//交换
				swap(nums, i, index);
			}

		}
		return -1;


//		int len = nums.length;
//
//		int [] array = new int[len];
//
//		for (int i = 0; i < len; i++) {
//
//			if(array[nums[i]] != 1){
//				array[nums[i]] = 1;
//				continue;
//			}
//
//			return nums[i];
//
//
//		}
//		return -1;
	}


	/**
	 * 交换元素
	 * @param nums
	 * @param a
	 * @param b
	 */
	private static void swap(int [] nums, int a, int b){
		int temp = nums[a] ;
		nums[a] = nums[b];
		nums[b] = temp;
	}



	public static void main(String[] args) {

		int [] nums = new int[]{2, 3, 1, 0, 5, 3};

		int num = findRepeatNumber(nums);

		System.out.printf("===="+num);

	}
}
