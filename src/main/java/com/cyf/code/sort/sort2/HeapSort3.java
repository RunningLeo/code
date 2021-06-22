package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:28 2019-07-30
 * @Desc ：
 */
public class HeapSort3 {

	/**
	 * 构建大顶堆
	 *
	 * @param a
	 */
	public static void bigRootHeap(int[] a) {

		int len = a.length;

		//获取非叶子节点
		int k = len / 2 - 1;

		//第一次构建
		while (k >= 0) {
			adjustHeap(a, k, len);
			k--;
		}

		for (int i = len -1 ; i>=0 ;i--){
			swap(a, 0, i);
			adjustHeap(a, 0, i);
		}



	}

	public static void adjustHeap(int[] a, int i, int len) {

		for (int j = 2 * i + 1; j < len ; j++) {

			if(j+1 < len && a[j] < a[j+1]){
				j = j+1;
			}

			if(a[j] > a[i]){
				swap(a, i, j);
				i = j;
			}

		}
	}


	public static void swap(int [] a, int i, int j){
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
