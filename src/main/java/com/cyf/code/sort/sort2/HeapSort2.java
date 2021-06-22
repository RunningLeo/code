package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:53 2019-07-07
 * @Desc ：
 */
public class HeapSort2 {

	//降序排列，小顶堆
	public static void heapSortSmall(int[] a) {

		int len = a.length;

		//第一次构建小顶堆
		for (int i = len / 2 - 1; i >= 0; i--) {

			buildSmallHeap(a, i, len);
		}

		swap(a, 0, len - 1);

		for (int i = len - 1; i > 0; i--) {

			for (int j = i / 2 - 1; j >= 0; j--) {
				buildSmallHeap(a, j, i);
			}
			swap(a, 0, i - 1);
		}
	}

	public static void buildSmallHeap(int[] a, int i, int len) {

		//找到i节点的左子节点

		int min = i;

		for (int j = 2 * min + 1; j < len; j = 2 * j + 1) {

			//判断是否有右子节点

			if (j + 1 < len && a[j + 1] < a[j]) {
				j = j + 1;
			}

			if (a[j] < a[min]) {
				min = j;
			}
		}

		if (i != min) {
			swap(a, i, min);
		}
	}


	//*********************************************************

	//升序排，大顶堆
	public static void bigRootHeap(int[] a) {

		int len = a.length;

		//第一次构建大顶堆
		for (int i = len / 2 - 1; i >= 0; i--) {
			buildBigRootHeap(a, i, len);
		}

		for (int i = len - 1; i > 0; i--) {
			swap(a, 0, len - 1);
			buildBigRootHeap(a, 0, i);

		}


	}

	public static void buildBigRootHeap(int[] a, int i, int len) {

		int value = a[i];

		for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {

			//判读是否有右节点
			if (j + 1 < len && a[j + 1] > a[j]) {
				j = j + 1;
			}

			if (value < a[j]) {
				swap(a, i, j);
				i = j;
			}
		}
	}


	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	public static void main(String[] args) {
		int[] a = {1, 6, 3, 1, 8, 2, 9};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		//	heapSortSmall(a);
		bigRootHeap(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
