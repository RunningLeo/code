package com.cyf.code.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:30 2019-02-16
 * @Desc ：
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence128 {

	public static int computeLength(int[] a) {

		if (a == null || a.length == 0) {
			return 0;
		}

		Set<Integer> sets = new HashSet<>();

		for (int i : a) {
			sets.add(i);
		}


		int maxLen = 0;
		for (int i : sets){
			int len = 1;
			if(sets.contains(i-1)){
				continue;
			}
			while (sets.contains(++i)){
				len++;
			}
			maxLen = Math.max(maxLen, len);

		}

		return maxLen;

	}

	public static void main(String[] args) {
		int[] a = new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7};
		int len = computeLength(a);
		System.out.println("===最长连续: " + len);
	}

}
