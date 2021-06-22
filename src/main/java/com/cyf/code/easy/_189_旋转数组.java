package com.cyf.code.easy;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:01 2020/3/6
 * @Desc ：
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class _189_旋转数组 {

	public static void rotate(int[] nums, int k) {

		int len = nums.length;

		if(k >= len){
			k %= len;
		}

		if(k == 0){
			return;
		}

		reverse(nums, 0, len-1);
		reverse(nums, 0, k - 1);

		reverse(nums, k, len - 1);

	}


	private static void reverse(int[] nums, int begin, int end) {

		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-1,-100,3,99};
		int k = 2;

		rotate(nums, k);

		Arrays.stream(nums).forEach(System.out::println);
	}
}
