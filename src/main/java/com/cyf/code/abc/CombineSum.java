package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:48 2019-05-27
 * @Desc ：给你一个正数数组candidate[],一个目标值target，寻找里面所有的不重复组合，让其和等于target，给你[2,3,6,7] 2+2+3=7 ,7=7,所以可能组合为[2,2,3],[7]
 */
public class CombineSum {

	static List<List<Integer>> result = new ArrayList<>();

	public static List<List<Integer>> getCombine(int[] a, int target) {

		List<Integer> subList = new ArrayList<>();

		tracing(result, subList, a, target, 0);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int[] a, int target, int start) {

		int sum = subList.stream().reduce(0, (c, d) -> c + d);

		if (sum == target) {
			result.add(new ArrayList<>(subList));
			return;
		} else if (sum > target) {
			return;
		}

		for (int i = start; i < a.length; i++) {
			subList.add(a[i]);
			tracing(result, subList, a, target, i);
			subList.remove(subList.size() - 1);
		}

	}

	public static boolean isSolution(List<Integer> subList, int target) {

		int sum = subList.stream().reduce(0, (a, b) -> a + b);

		if (sum == target) {
			return true;
		}
		return false;

	}


	public static void main(String[] args) {

		int[] a = new int[]{2, 3, 6, 7};
		int target = 7;

		List<List<Integer>> result = getCombine(a, target);

		result.stream().forEach(System.out::println);

	}


}
