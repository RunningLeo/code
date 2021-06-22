package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:25 2019-02-11
 * @Desc ：
 */
public class SelectSort {

	public static void selectSort(int [] a){

		for (int i = 0; i < a.length -1 ; i++) {

			int maxIndex = i;

			for (int j = i+1; j < a.length ; j++) {
				if(a[maxIndex] < a[j]){
					maxIndex = j;
				}
			}

			//交换
			if(i != maxIndex){
				int temp = a[maxIndex];
				a[maxIndex] = a[i];
				a[i] = temp;
			}
		}

	}

	public static void main(String[] args) {
		int [] a = {6,3,8,2,9,1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);
		selectSort(a);
		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
