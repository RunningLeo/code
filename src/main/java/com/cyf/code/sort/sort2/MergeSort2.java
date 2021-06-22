package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:20 2019-07-30
 * @Desc ：
 */
public class MergeSort2 {

	public static void divide(int[] a, int begin, int end) {

		if (begin >= end) {
			return;
		}

		int mid = (begin + end) / 2;

		//分
		divide(a, begin, mid);
		divide(a, mid+1, end);

		//合
		merge(a, begin, mid, end);

	}

	public static void merge(int [] a, int begin, int mid, int end){

		int [] temp = new int[end - begin +1];
		int i = begin;
		int j = mid + 1;
		int k = 0;

		while (i<=mid && j<= end){
			if(a[i] < a[j]){
				temp[k++] = a[i++];
			}else {
				temp[k++] = a[j++];
			}
		}

		while (i <= mid){
			temp[k++] = a[i++];
		}

		while (j <= end){
			temp[k++] = a[j++];
		}

		k = 0;
		while (begin <= end){
			a[begin++] = temp[k++];
		}
	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1, 1, 0};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		divide(a, 0, a.length - 1);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);
	}
}
