package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:59 2019-08-12
 * @Desc ：经典快排是当元素中有大量重复元素的时候，分组极不均衡，导致时间复杂度可能为 O(n^2)
 * 用三路快排可以解决，分为 小于，等于，大于三部分
 */
public class ThreeWayQuickSort {

	public static void threeWaySort(int [] a, int left, int right){

		if(left >= right){
			return;
		}

		int pivot = a[left];

		int begin = left;
		int end = right;
		int i = left + 1;

		while (i <= end){
			if(a[i] < pivot){
				swap(a, i, begin+1);
				i++;
				begin++;

			}else if(a[i] > pivot){
				swap(a, i, end);
				end--;

			}else {
				i++;
			}
		}

		swap(a, left, begin);
		threeWaySort(a, left, begin -1);
		threeWaySort(a, end+1, right);

	}

	public static void swap(int [] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	public static void main(String[] args) {

		int[] a = {6, 3, 8, 2, 9, 1, 1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		threeWaySort(a, 0, a.length-1);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);
	}
}
