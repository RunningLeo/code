package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:38 2019-02-12
 * @Desc ：希尔排序
 */
public class ShellSort {

	//希尔移动
	public static void shellSort(int[] a) {

		int n = a.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int j = i - gap;
				int value = a[i];
				while (j >= 0 && a[j] > value) {
					a[j + gap] = a[j];
					j -= gap;
				}
				a[j + gap] = value;
			}
		}

	}

	//希尔交换排序
	public static void shellSort2(int[] a) {

		int n = a.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int j = i - gap;
				while (j >= 0 && a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}

		}

	}

	public static void main(String[] args) {
		int[] a = {6, 3, 8, 2, 9, 1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		shellSort(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

		int[] b = {6, 3, 8, 2, 9, 1};
		System.out.println("排序法2前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		shellSort2(b);
		System.out.println("排序法2后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
