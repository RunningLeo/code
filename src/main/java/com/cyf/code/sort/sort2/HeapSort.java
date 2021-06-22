package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:41 2019-04-26
 * @Desc ：
 */
public class HeapSort {

	public static void heapSort(int[] a) {

		if (a == null || a.length == 0 || a.length == 1) {
			return;
		}

		//首先构建一个大顶堆，找到第一个非叶子节点
		int n = a.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			adjustHeap(a, i, n);
		}


		//不断调整找到当前大顶堆的最大元素，并交换
		for (int i = n - 1; i > 0; i--) {

			swap(a, 0, i);
			adjustHeap(a, 0, i);

		}

	}

	/**
	 * 调整当前元素i及子孩子为大顶堆
	 *
	 * @param a
	 * @param i
	 * @param length
	 */
	public static void adjustHeap(int[] a, int i, int length) {

		int value = a[i];

		//当前元素为i, 则左孩子2 * i +1， 右孩子 2 * i + 2
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

			//如果存在右孩子，则比较左右孩子的大小
			if (k + 1 < length && a[k] < a[k + 1]) {
				k = k + 1;
			}

			if (value < a[k]) {
				swap(a, i, k);
				i = k;
			}

		}


	}


	/**
	 * 小顶堆
	 *
	 * @param a
	 */
	public static void heapSortSmall(int[] a) {
		if (a == null || a.length == 0 || a.length == 1) {
			return;
		}

		//首先构建一个小顶堆，找到第一个非叶子节点
		int n = a.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			adjustHeapSmall(a, i, n);
		}

		for (int i = n - 1; i > 0; i--) {

			swap(a, 0, i);

			adjustHeapSmall(a, 0, i);

		}


	}

	/**
	 * 小顶堆调整
	 *
	 * @param a
	 * @param i
	 * @param length
	 */
	public static void adjustHeapSmall(int[] a, int i, int length) {

		int value = a[i];

		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

			if (k + 1 < length && a[k + 1] < a[k]) {
				k = k + 1;
			}

			if (a[k] < value) {
				a[i] = a[k];
				i = k;
			}

		}
		a[i] = value;

	}


	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	public static void main(String[] args) {
		int[] a = {1, 6, 3, 1, 8, 2, 9, 7, 10, 15, 20};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		heapSort(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
