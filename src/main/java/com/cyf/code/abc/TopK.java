package com.cyf.code.abc;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:20 2019-05-21
 * @Desc ：
 */
public class TopK {

	public static int[] getTopK(int[] a, int k) {

		int [] top = new int[k];

		int n = a.length;

		//第一次大顶堆
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			adjustDeap(a, i, a.length);
		}

		for (int j = a.length - 1; j > a.length - 1 - k; j--) {
			//始终拿当前的最大元素和最后一个元素交换，然后缩短需要排序的数组的长度
			swap(a, 0, j);
			//剩余元素构建大顶堆
			adjustDeap(a, 0, j);

		}


		for (int i = 0; i <k ; i++) {

			top[i] = a[n-1-i];

		}

		return top;
	}

	public static void swap(int [] a, int s, int b){

		int temp = a[s];
		a[s] = a[b];
		a[b] = temp;
	}


	public static int [] adjustDeap(int [] a, int i, int len){

		//调整非叶子节点
		int value = a[i];


		for (int j = 2*i+1; j < len ; j = 2 * j + 1) {

			if(j+1 < len && a[j+1] > a[j]){
				j = j+1;
			}

			if(a[j] > value){
				a[i] = a[j];
				i = j;
			}

		}
		a[i] = value;
		return a;
	}

	public static void main(String[] args) {
		int[] a = new int[]{3, 1, 5, 8, 10, -1,20};

		int k = 3;

		int [] top = getTopK(a, k);

		System.out.println("=========");

		Arrays.stream(top).forEach(System.out::println);


	}
}
