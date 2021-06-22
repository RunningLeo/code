package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:15 2019-05-27
 * @Desc ：Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {


	public static List<List<Integer>> getSub(int [] a){

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> subList = new ArrayList<>();

		result.add(new ArrayList<>());

		tracing(result, subList, a, 0);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int [] a, int start){

		if(subList.size() > 0){
			result.add(new ArrayList<>(subList));
			if(start == a.length){
				return;
			}
		}


		int n = a.length;

		for (int i = start; i <n ; i++) {

			subList.add(a[i]);

			tracing(result, subList, a, i+1);

			subList.remove(subList.size() -1);

		}
	}


	public static void main(String[] args) {
		int [] a = new int[]{0};

		List<List<Integer>> result = getSub(a);

		result.stream().forEach(System.out::println);
	}
}
