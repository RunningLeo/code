package com.cyf.code.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:11 2019-03-28
 * @Desc ：滑动窗口最大值数组
 */
public class MaxWindowShow {

	public static int[] windowShow(int[] a, int w) {


		if (a == null || a.length  == 0) {
			return new int[0];

		}

		ArrayDeque<Integer> queue = new ArrayDeque();


		int len = a.length;
		int[] res = new int[len - w + 1];
		int index = 0;
		for (int i = 0; i < len; i++) {

			while (!queue.isEmpty() && a[queue.peekLast()] < a[i]) {
				queue.pollLast();
			}
			queue.addLast(i);

			if (queue.peekFirst() <= i - w) {
				queue.pollFirst();
			}

			if (i - w + 1 >= 0) {
				res[index++] = a[queue.peekFirst()];
			}


		}

		return res;


	}


	public static void main(String[] args) {
		int[] a = new int[]{9, 3, 6, 1, 3, 5, 10};
		int w = 3;

		int[] res = windowShow(a, w);

		Arrays.stream(res).forEach(System.out::println);
	}
}
