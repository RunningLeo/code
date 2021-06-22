package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:35 2019-04-26
 * @Desc ：
 */
public class MergeSort {


	public static void mergeSort(int[] a, int begin, int end) {

		if (begin == end) {
			return;
		}

		//归并排序就是分治法的应用，先分解，后合并

		int mid = (begin + end) / 2;

		//分
		mergeSort(a, begin, mid);
		mergeSort(a, mid + 1, end);

		//治
		merge(a, begin, mid, end);

	}

	public static void merge(int[] a, int begin, int mid, int end) {

		int[] temp = new int[end - begin + 1];

		//i,j分别为归并的首位元素
		int i = begin;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = a[i++];
		}

		while (j <= end) {
			temp[k++] = a[j++];
		}

		//拷贝到原数组

		k = 0;
		while (begin <= end) {
			a[begin++] = temp[k++];
		}

	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1, 1, 0};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		mergeSort(a, 0, a.length - 1);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);
	}
}
