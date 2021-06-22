package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:06 2019-02-12
 * @Desc ：堆排序 https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort {

	//升序用大顶堆，降序用小顶堆
	public static void heapSort(int[] a) {

		//第一次构建大顶堆，从下至上的第一个非叶子节点开始
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			adjustHeap(a, i, a.length);
		}

		//此时是大顶堆，最大的元素位于数组第一位

		//交换堆顶和末尾元素+调整结构
		for (int j = a.length - 1; j > 0; j--) {
			//始终拿当前的最大元素和最后一个元素交换，然后缩短需要排序的数组的长度
			swap(a, 0, j);
			//剩余元素构建大顶堆
			adjustHeap(a, 0, j);

		}

	}
	/**
	 * 调整堆的非叶子结点
	 */
	public static void adjustHeap(int[] a, int i, int length) {

		//先取出当前元素
		int temp = a[i];

		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

			//如果有右子节点并且右节点大于左节点，则子节点指向右节点
			if (k + 1 < length && a[k] < a[k + 1]) {
				k++;
			}

			if (a[k] > temp) {
				//子节点大于该节点
				a[i] = a[k];
				i = k;
			}
		}
		a[i] = temp;
	}

	/**
	 * 交换元素
	 */
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1, 1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		heapSort(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
