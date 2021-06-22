package com.cyf.code.abc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:14 2019-05-24
 * @Desc ：
 */
public class MaxInteger {

	public static String getMaxString(int [] a){

		if(a == null){
			return "";
		}

		int len = a.length;

		if(len == 1){
			return String.valueOf(a[0]);
		}

		for (int i = 0; i < len ; i++) {

			String num1 = a[i] + "";

			for (int j = i+1; j < len ; j++) {

				String num2 = a[j]+"";

				if((num1+num2).compareTo(num2+num1) < 0){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}

			}

		}

		String res = "";
		for (int i = 0; i < len; i++) {
			res += a[i];
		}

		return res;
	}


	public static String getMaxString2(Integer [] a){
		int len = a.length;

		Arrays.sort(a, new MyComparator());

		String res = "";
		for (int i = 0; i < len; i++) {
			res += a[i];
		}

		return res;

	}


	public static void main(String[] args) {
		Integer [] a = new Integer[]{46, 121, 33};

		String res = getMaxString2(a);

		System.out.println("====res="+res
		);
	}


	static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return (String.valueOf(o2)+ o1 ).compareTo(String.valueOf(o1)+o2);
		}
	}

	static class MyComparator2 implements Comparable{

		@Override
		public int compareTo(Object o) {
			return 0;
		}
	}
}
