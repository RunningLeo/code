package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:08 2019-02-11
 * @Desc ：
 */
public class QuickSort {

	public static void quickSort(int[] a, int begin, int end) {

		if (begin >= end) {
			return ;
		}

		int left = begin;
		int right = end;
		int temp = 0;

		int pivot = a[right];

		while (left < right){

			if(a[right-1] > pivot ){
				a[right] = a[right-1];
				right--;
			}else {
				temp = a[left];
				a[left] = a[right-1];
				a[right-1] = temp;
				left++;
			}
		}

		a[right] = pivot;

		quickSort(a, begin, right -1);
		quickSort(a, right+1, end);
	}


	public static void quickSort2(int[] a, int begin, int end) {

		if (begin >= end) {
			return ;
		}

		int left = begin;
		int right = end;
		int temp = 0;

		int pivot = a[left];

		while (left < right) {

			if (a[left + 1] < pivot) {
				a[left] = a[left + 1];
				left++;
			} else {
				temp = a[left + 1];
				a[left + 1] = a[right];
				a[right] = temp;
				right--;
			}
		}

		a[left] = pivot;
		quickSort2(a, begin, left - 1);
		quickSort2(a, left + 1, end);

	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1, 3};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		quickSort(a, 0, a.length - 1);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
