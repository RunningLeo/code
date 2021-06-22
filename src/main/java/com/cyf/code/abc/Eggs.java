package com.cyf.code.abc;

import java.util.Scanner;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:50 2019-05-20
 * @Desc ：
 */
public class Eggs {


	public static StringBuilder getCount(int n, StringBuilder sb) {

		if (n == 0) {
			return sb;
		}

		if ((n & 1) == 1) {
			getCount((n - 1) / 2, sb);
			return sb.append("2");
		} else {
			getCount((n - 2) / 2, sb);
			return sb.append("3");
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = getCount(n, new StringBuilder());

		System.out.println("=====sb=" + sb.toString());

	}
}
