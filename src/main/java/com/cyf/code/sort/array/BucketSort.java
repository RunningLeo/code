package com.cyf.code.sort.array;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:58 2019-04-26
 * @Desc ：桶排序
 */
public class BucketSort {

	/**
	 * 有点像计数排序，桶太多了
	 * @param a
	 * @param n
	 * @param max
	 */
	public static void bucketSort(int[] a, int n, int max) {

		if (a == null || a.length == 0 || a.length == 1 || max < 1) {
			return;
		}

		int[] buckets = new int[max + 1];

		for (int i = 0; i < n; i++) {
			buckets[a[i]]++;
		}

		for (int i = 0, j = 0; i <= max; i++) {
			while (buckets[i] > 0) {
				a[j++] = i;
				buckets[i]--;
			}
		}
	}

	/**
	 * 桶排序
	 * @param a
	 */
	public static void bucketSort2(int[] a) {

		int len = a.length;

		if(a == null || len == 0){
			return;
		}

		//找到最大值和最小值
		int min = a[0];
		int max = a[0];

		for (int i = 1; i <len ; i++) {
			if(a[i] > max){
				max = a[i];
			}

			if(a[i] < min){
				min = a[i];
			}
		}

		//桶的个数等于数组的长度
		int bucketNum = len;

		int d = max - min;

		List<LinkedList<Integer>> res = Lists.newArrayListWithExpectedSize(bucketNum);

		for (int i = 0; i < bucketNum ; i++) {
			res.add(new LinkedList<>());
		}

		//遍历原始数据，放入
		for (int i = 0; i < len; i++) {

			//计算在第几个桶内
			int index = (a[i] - min) * (bucketNum - 1) / d;
			res.get(index).add(a[i]);
		}

		//桶内各自排序
		for (int i = 0; i < bucketNum; i++) {
			LinkedList<Integer> cur = res.get(i);
			Collections.sort(cur);
		}

		int index = 0;

		for (int i = 0; i <bucketNum ; i++) {
			LinkedList<Integer> cur = res.get(i);
			if(cur.size() == 0){
				continue;
			}

			for (int j = 0; j <cur.size() ; j++) {
				a[index++] = cur.get(j);
			}

		}
	}





		public static void main(String[] args) {

		int[] a = {6, 3, 8, 2, 9, 1, 1};
		System.out.println("支持负数的排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		bucketSort2(a);
		//bucketSort(a, a.length, 9);
		System.out.println("支持负数的排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
