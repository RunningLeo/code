package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:20 2019-08-14
 * @Desc ：三路快排优化版
 */
public class ThreeWayQuickSort2 {

	public static void sort(int[] a, int left, int right) {

		if (left >= right) {
			return;
		}

		int pivot = a[left];

		int begin = left;
		int end = right;

		int i = left + 1;

		while (i <= end) {
			if (a[i] < pivot) {
				swap(a, begin, i);
				begin++;
				i++;
			} else if (a[i] > pivot) {
				swap(a, end, i);
				end--;
			} else {
				i++;
			}
		}

		sort(a, left, begin - 1);
		sort(a, end + 1, right);

	}


	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1, 1};
		sort(a, 0, a.length - 1);

		Arrays.stream(a).forEach(System.out::println);

	}
}
