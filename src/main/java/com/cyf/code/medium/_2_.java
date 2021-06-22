package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:27 2020/3/8
 * @Desc ：
 *
 * 5
 *  1 1 2 22 23
 */
public class _2_ {

	public static List<List<Integer>> getSubII(int [] a){

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> subList = new ArrayList<>();

	//	result.add(new ArrayList<>());

		tracing(result, subList, a, 0);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int [] a, int start){

		int sum = 0;
		for (int i = 0; i < subList.size() ; i++) {
			sum += subList.get(i);
		}
		if(sum == 24){
			result.add(new ArrayList<>(subList));
			if(start == a.length){
				return;
			}
		}

		int n = a.length;

		for (int i = start; i <n ; i++) {

			//跳过重复的元素
			if(i> start && a[i] == a[i -1]){
				continue;
			}
			subList.add(a[i]);

			tracing(result, subList, a, i+1);

			subList.remove(subList.size() -1);

		}
	}


	public static void main(String[] args) {
		int [] a = new int[]{1,1,2,22,23};

		List<List<Integer>> res = getSubII(a);

		System.out.println("====");
	}
}
