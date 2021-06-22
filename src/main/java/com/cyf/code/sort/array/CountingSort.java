package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:37 2019-04-26
 * @Desc ：计数排序
 */
public class CountingSort {

	/**
	 *计数排序
	 * @param a
	 * @param n
	 * @param max
	 */
	public static void countingSort(int[] a, int n, int max, int min) {

		int[] buckets = new int[max - min + 1];

		int base = min < 0 ? -min : 0;

		for (int i = 0; i < n; i++) {
			buckets[a[i]+base]++;
		}

		for (int i = 0, j = 0; i <= max-min ; i++) {

			while (buckets[i]>0){
				a[j++] = i-base;
				buckets[i]--;
			}
		}

	}

	public static void main(String[] args) {

		int[] b = {6, 3, 8, -2, 9, -1, 1};
		System.out.println("支持负数的排序前的数组：");
		Arrays.stream(b).forEach(System.out::println);
		countingSort(b, b.length, 9, -2);
		System.out.println("支持负数的排序后的数组：");
		Arrays.stream(b).forEach(System.out::println);

	}
}
