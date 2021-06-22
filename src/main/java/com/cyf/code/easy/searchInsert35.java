package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午12:00 2018/9/17
 * @Desc ：
 */
public class searchInsert35 {
	public static  int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int left = 0;
		int right = len - 1;
		//有序数组用二分法查找
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				if (mid + 1 == len) {
					return len;
				}
					if (nums[mid + 1] > target) {
						return mid + 1;
					}
					left = mid + 1;
				} else if (nums[mid] > target) {
					if (mid == 0) {
						return 0;
					}
					if (nums[mid - 1] < target) {
						return mid;
					}
					right = mid - 1;
				} else {
					return mid;
				}
			}
		return 0;

	}

	public static void main(String[] args) {
		int [] nums = new int[]{1,3,5,6};
		int target = 2;
		int res = searchInsert(nums, target);
		System.out.println("=======res="+res);
	}

}
