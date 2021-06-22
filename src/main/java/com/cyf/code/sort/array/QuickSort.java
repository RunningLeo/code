package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:08 2019-02-11
 * @Desc ：
 */
public class QuickSort {

	public static void quickSort1(int a[], int begin, int end) {

		int i, j, pivot;
		i = begin;
		j = end;

		if (i >= j) {
			return;
		}

		pivot = a[i];

		while (i < j) {

			while (i < j && a[j] > pivot) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}

			while (i < j && a[i] < pivot) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}

		a[i] = pivot;
		quickSort1(a, begin, i - 1);
		quickSort1(a, i + 1, end);

	}


	public static void quickSort2(int a[], int begin, int end) {

		if (begin >= end) {
			return;
		}

		int left, right, pivot;
		left = begin;
		right = end;
		pivot = a[left];

		while (left < right) {
			if (a[left + 1] < pivot) {
				a[left] = a[left + 1];
				left++;
			} else {
				//交换a[left+1] 和a[right]
				if(left + 1 != right){
					int temp = a[left + 1];
					a[left + 1] = a[right];
					a[right] = temp;
				}
				right--;
			}
		}
		a[left] = pivot;
		quickSort2(a, begin, left - 1);
		quickSort2(a, left + 1, end);

	}

	public static void swap(int a[] , int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
	//	int[] a = {6, 3, 8, 2, 9, 1, 1};

		//当数组是有序时，将降序排成升序，时间复杂度会最坏，是O(n^2)
		int[] a = {6, 5, 4, 3, 2, 1, 0};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		quickSort2(a, 0, a.length - 1);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
