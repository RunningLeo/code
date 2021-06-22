package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:27 2019-05-27
 * @Desc ：给你两个整数 n和k，从1-n中选择k个数字的组合。比如n=4，k=2, 那么从1,2,3,4中选取2个数字的组合
 */
public class Combine {

	static List<List<Integer>> result = new ArrayList<>();



	public static List<List<Integer>> getCombine(int n, int k){

		List<Integer> subList = new ArrayList<>();

		tracing(result, subList, 1, n, k);


		return result;

	}


	public static void tracing(List<List<Integer>> result, List<Integer> subList, int start, int n, int k){

		if(k == 0){
			List<Integer> temp = new ArrayList<>(subList);
			result.add(temp);
			return;
		}

		for (int i = start; i <= n ; i++) {

			subList.add(i);
			tracing(result, subList, i+1, n, k-1);
			subList.remove(subList.size()-1);

		}

	}


	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> result = getCombine(n, k);

		result.stream().forEach(System.out::println);
	}
}
