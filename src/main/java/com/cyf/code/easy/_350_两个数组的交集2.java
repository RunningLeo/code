package com.cyf.code.easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午9:22 2020/5/16
 * @Desc ：
 */
public class _350_两个数组的交集2 {

	public static int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int [] arr = new int[Math.max(nums1.length, nums2.length)];
		int index = 0;
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				arr[index++] = nums1[i];
				i++;
				j++;
			}
		}

		return Arrays.copyOf(arr, index);

	}

	public static void main(String[] args) {

		int [] nums1 = new int[]{4,9,5};

		int [] nums2 = new int[]{9,4,9,8,4};

		int [] nums = intersect(nums1, nums2);

		Arrays.stream(nums).forEach(System.out::println);

	}
}
