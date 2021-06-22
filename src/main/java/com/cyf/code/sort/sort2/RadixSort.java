package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:48 2019-04-26
 * https://www.cnblogs.com/skywang12345/p/3603669.html
 * @Desc ：
 */
public class RadixSort {


	static void countSort(int a[], int n, int exp){
		int [] temp = new int[n];

		int [] buckets = new int[10];

		for (int i = 0; i < n; i++) {
			buckets[(a[i]/exp)%10]++;
		}

		for (int i = 1; i < 10; i++) {
			buckets[i] += buckets[i-1];
		}

		for (int i = 0; i < n ; i++) {

			temp[buckets[(a[i]/exp)%10]-1] = a[i];
			buckets[(a[i]/exp)%10]--;
		}

		for (int i = 0; i < n; i++) {
			a[i] = temp[i];

		}

	}

	/*
	 * 基数排序
	 *
	 * 参数说明：
	 *     a -- 数组
	 *     n -- 数组长度
	 */
	static void radixSort(int a[], int n)
	{
		int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
		int max = getMax(a, n);    // 数组a中的最大值

		// 从个位开始，对数组a按"指数"进行排序
		for ( exp = 1; max/exp > 0 ; exp = exp*10) {
			countSort(a, n, exp);
		}

	}

	static int getMax(int a[], int n)
	{
		int i, max;

		max = a[0];
		for (i = 1; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = {6, 31, 8, 2, 99, 1, 15, 0};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		radixSort(a, 8);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
