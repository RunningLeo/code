package com.cyf.code.sort.sort2;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:10 2019-08-07
 * @Desc ：
 */
public class RadixSort3 {

	public static void countSort(int[] a, int exp) {

		int[] temp = new int[a.length];
		int[] buckets = new int[10];

		//cache data
		for (int i = 0; i < a.length; i++) {
			buckets[(a[i] / exp) % 10]++;
		}

		//更改buckets,目的是让更改后的buckets[i]是该数据出现的位置
		for (int i = 1; i < 10; i++) {
			buckets[i] += buckets[i - 1];
		}

		for (int i = a.length - 1; i>=0; i--){
			temp[--buckets[(a[i] / exp) % 10]] = a[i];
		}

		for (int i = 0; i< a.length; i++){
			a[i] = temp[i];
		}

	}

	public static void radixSort(int[] a) {

		int exp;
		int max = getMax(a);

		for (exp = 1; max / exp > 0; exp = exp * 10) {
			countSort(a, exp);
		}

	}

	public static int getMax(int[] a) {

		int max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}


	public static void main(String[] args) {
		int[] a = {6, 31, 8, 2, 99, 1, 15, 0};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		radixSort(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);
	}
}
