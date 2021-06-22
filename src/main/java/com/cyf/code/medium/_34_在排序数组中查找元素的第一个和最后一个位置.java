package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:12 2019-05-25
 * @Desc ：
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

	public static int[] searchRange(int[] a, int target) {

		int[] res = new int[]{-1, -1};

		if (a == null) {
			return res;
		}
		if (a.length == 1 && a[0] != target) {
			return res;
		}


		int n = a.length;
		int start = 0;
		int end = n - 1;

		int left = -1;
		int right = -1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if(a[mid] == target){
				left = mid;
				right = mid;

				while (left - 1 >=0 && a[left - 1] == target){
					left--;
				}

				while (right + 1 < n && a[right + 1] == target){
					right++;
				}

				res[0] = left;
				res[1] = right;
				return res;

			}else if(a[mid] > target){
				end = mid -1;
			}else {
				start = mid +1;
			}
		}

		return res;
	}


	public static int[] searchRange2(int[] a, int target) {

		int len = a.length;

		int begin = binarySearch(a, target);

		int last = binarySearch(a, target + 1) - 1;

		if(begin == len || a[begin] != target){
			return new int[]{-1,-1};
		}else {
			return new int[]{begin, Math.max(begin, last)};
		}


	}

	/**
	 * 找到大于等于tar出现的第一个位置，没有找到返回len
	 * @param a
	 * @param tar
	 * @return
	 */
	private static int binarySearch(int[] a, int tar){

		int len = a.length;

		int left = 0;
		int right = len;

		while (left < right){
			int mid = left + (right - left) / 2;

			if(a[mid] >= tar){
				right = mid;
			}else {
				left = mid + 1;
			}
		}

		return left;
	}





		public static void main(String[] args) {
		int[] a = new int[]{5,7,7,8,8,10};
		int target = 8;

		int[] index = searchRange2(a, target);

		System.out.println("=======" + index[0] + "====" + index[1]);
	}
}
