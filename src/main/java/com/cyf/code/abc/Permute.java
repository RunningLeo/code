package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:08 2019-05-27
 * @Desc ：
 */
public class Permute {

	public static List<List<Integer>> permute(int[] a) {

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> subList = new ArrayList<>();

		tracing(result, subList, a);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int[] a) {

		if (subList.size() == a.length) {
			result.add(new ArrayList<>(subList));
			return;
		}


		int n = a.length;

		for (int i = 0; i < n; i++) {

			if(subList.contains(a[i])){
				continue;
			}

			subList.add(a[i]);

			tracing(result, subList, a);

			subList.remove(subList.size() - 1);

		}
	}


	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3};

		List<List<Integer>> result = permute(a);

		result.stream().forEach(System.out::println);
	}
}
