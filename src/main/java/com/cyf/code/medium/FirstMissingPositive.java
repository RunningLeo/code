package com.cyf.code.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：caoyafei
 * @Date ：Created in 21:03 2019-05-25
 * @Desc ：
 */
public class FirstMissingPositive {


	public static int firstMissingPositive(int [] a){

		if(a== null || a.length == 0){
			return 1;
		}

		int max = Integer.MIN_VALUE;

		int n = a.length;

		Set<Integer> sets = new HashSet<>(n);

		for (int i = 0; i <n ; i++) {

			if(max < a[i]){
				max = a[i];
			}
			if(!sets.contains(a[i])){
				sets.add(a[i]);
			}
		}

		if(max <= 0){
			return 1;
		}

		for (int i = 1; i < max; i++) {
			if(!sets.contains(i)){
				return i;
			}

		}

		return max + 1;



	}


	public static int firstMissingPositive2(int[] a) {
		if(a== null || a.length == 0){
			return 1;
		}

		int [] arr = new int [a.length];
		int max = 0;
		for (int num: a){
			if(num > max){
				max = num;
			}
			if (num <= 0 || num>arr.length){
				continue;
			}
			arr[num-1] = 1 ;
		}

		for (int i = 0 ; i<arr.length ; i++){
			if (arr[i]==0){
				return i+1;
			}
		}

		return max+1;
	}


	public static void main(String[] args) {
		int [] a = new int[]{1};

		int res = firstMissingPositive2(a);

		System.out.println("=====res="+res);

	}
}
