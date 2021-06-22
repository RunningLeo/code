package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:23 2019-02-16
 * @Desc ：
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1. You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

	public static int search(int[] a, int target) {

		//二分法
		int n = a.length;
		int start = 0;
		int end = n - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;

			if (a[mid] == target) {
				return mid;
			}

			if (a[start] <= a[mid]) {
				if (a[start] <= target && target <= a[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}

			} else {
				if (a[mid] <= target && target <= a[end]) {
					start = mid;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;

	}


	public static void main(String[] args) {
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};

		int target = 0;

		int index = search(a, target);

		System.out.println("====index=" + index);
	}

}
