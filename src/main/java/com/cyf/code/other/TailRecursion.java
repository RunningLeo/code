package com.cyf.code.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:39 2019-02-26
 * @Desc ：尾递归
 */
public class TailRecursion {

	/**
	 * 普通递归获取n的阶乘
	 *
	 * @param n
	 * @return
	 */
	public static long recursion(int n) {
		if (n <= 1) {
			return 1;
		}

		return recursion(n - 1) * n;
	}

	/**
	 * 尾递归获取n的阶乘
	 *
	 * @param n
	 * @param res
	 * @return
	 */
	public static long tail(int n, int res) {

		if (n <= 1) {
			return res;
		}

		return tail(n - 1, n * res);
	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= 1024) ? 1024 : n + 1;
	}


	public static void main(String[] args) {

		int cap = 7;
		int res = tableSizeFor(cap);

		Map map = new HashMap();

		int n = 5;
		long start1 = System.currentTimeMillis();

		//普通递归
		long res1 = recursion(n);
		long end1 = System.currentTimeMillis();
		long cost1 = end1 - start1;
		System.out.println("===res1=" + res1 + ", cost1=" + cost1);


		//尾递归
		long start2 = System.currentTimeMillis();
		long res2 = tail(n, 1);
		long end2 = System.currentTimeMillis();
		long cost2 = end2 - start2;
		System.out.println("===res2=" + res2 + ", cost2=" + cost2);
	}
}
