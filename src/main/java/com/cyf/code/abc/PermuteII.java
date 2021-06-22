package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:17 2019-05-27
 * @Desc ：
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteII {

	public static List<List<Integer>> permuteUnique(int[] a) {

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> subList = new ArrayList<>();

		Arrays.sort(a);

		int [] used = new int[a.length];

		tracing(result, subList, a, used);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int[] a, int [] used) {

		if (subList.size() == a.length) {
			result.add(new ArrayList<>(subList));
			return;
		}


		int n = a.length;

		for (int i = 0; i < n; i++) {

			if(used[i] == 1 || (i > 0 && a[i] == a[i-1] && used[i-1] == 0)){
				continue;
			}


			subList.add(a[i]);
			used[i] = 1;

			tracing(result, subList, a, used);

			used[i] = 0;

			subList.remove(subList.size() - 1);

		}
	}


	public static void main(String[] args) {
		int[] a = new int[]{3,3,0,3};

		List<List<Integer>> result = permuteUnique(a);

		result.stream().forEach(System.out::println);
	}
}
