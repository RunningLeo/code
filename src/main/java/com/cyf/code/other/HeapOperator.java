package com.cyf.code.other;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:26 2018/9/20
 * @Desc ：二叉堆操作
 */
public class HeapOperator {

	/**
	 * 上浮调整
	 */
	public static void upAdjust(int[] array) {
		int len = array.length;
		int childIndex = len - 1;
		int parentIndex = (childIndex - 1) / 2;
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}

	/**
	 * 下沉调整
	 *
	 * @param parentIndex 要下沉的父节点
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length) {
			//右孩子节点
			if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
				childIndex++;
			}

			//此时childIndex指向最小的孩子节点，如果父节点小于最小的孩子节点，则不需要移动
			if (temp <= array[childIndex]) {
				break;
			}

			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[parentIndex] = temp;

	}


	/**
	 * 构建小顶堆
	 */
	public static void buildHeap(int[] array) {
		int len = array.length;
		//从最后一个非叶子节点开始下沉调整
		for (int i = (len - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, len);
		}
	}

	/**
	 * 堆排序
	 */
	public static void heapSort(int[] array) {
		//先把无序数组构建成二叉堆
		buildHeap(array);

		int len = array.length;
		for (int i = len - 1; i > 0; i--) {
			//把第一个元素和最后一个元素交换
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			downAdjust(array, 0, i);
		}

	}


	public static void main(String[] args) {
		int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
		System.out.println("=======" + Arrays.toString(array));
		upAdjust(array);
		System.out.println("=======" + Arrays.toString(array));

		array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
		buildHeap(array);
		System.out.println("===build====" + Arrays.toString(array));

		array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6, 0};
		heapSort(array);
		System.out.println("=====heapSort==" + Arrays.toString(array));
	}
}
