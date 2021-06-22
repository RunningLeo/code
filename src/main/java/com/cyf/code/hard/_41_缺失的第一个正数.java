package com.cyf.code.hard;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:14 2020/3/24
 * @Desc ：
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _41_缺失的第一个正数 {


	public static int firstMissingPositive(int[] nums) {

		int len = nums.length;

		if (len == 0) {
			return 1;
		}

		//数组的长度len,如果有缺失，则一定是在【1,len】这个范围内
		//超过数组长度的数字直接舍弃

		for (int i = 0; i < len; i++) {

			int num = nums[i];
			if (num <= 0 || num > len) {
				nums[i] = 0;
				continue;
			}
			//判断num在不在自己应该的位置上，不在，则交换
			if (i != num - 1) {
				//待交换的位置如果已经是正确的了，则跳过
				if(num == nums[num - 1]){
					continue;
				}
				swap(nums, i, num - 1);
				i--;
			}

		}

		//找到第一个缺失的正数
		for (int j = 0; j < len; j++) {
			if (nums[j] != j + 1) {
				return j + 1;
			}
		}

		return len + 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {

		int[] nums = new int[]{3,4,-1,1};

		int res = firstMissingPositive(nums);

		System.out.println("=====res=" + res);

	}

}
