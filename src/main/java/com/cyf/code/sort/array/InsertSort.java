package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:46 2019-02-11
 * @Desc ：
 */
public class InsertSort {

	public static void insertSort(int a[]) {

		for (int i = 1; i < a.length; i++) {

			int value = a[i];

			int j = i - 1;

			while (j >= 0 && a[j] > value) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = value;
		}

	}

	public static void insertSort2(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			while (j>=0 && a[j] > a[j+1]){
				//交换
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
				j--;
			}
		}

	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		insertSort2(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
