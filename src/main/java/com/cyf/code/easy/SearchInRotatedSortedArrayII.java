package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:08 2019-02-16
 * @Desc ：
 * Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII {

	public static boolean search(int[] a, int target) {

		int n = a.length;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (a[mid] == target) {
				return true;
			}

			if (a[start] == a[mid]) {
				if (a[mid] == a[end]) {
					end--;
				}
				start++;
			} else if (a[start] < a[mid]) {
				if (a[start] <= target && target < a[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (a[mid] < target && target <= a[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return false;

	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 3, 1, 1, 1, 1, 1, 1, 1, 1};
		int target = 3;
		boolean flag = search(a, target);
		System.out.println("target存在于数组中：" + flag);
	}
}
