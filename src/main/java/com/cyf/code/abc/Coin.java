package com.cyf.code.abc;

import java.util.Scanner;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:18 2019-05-20
 * @Desc ：
 */
public class Coin {

	public static Integer getMaxCoin(int n) {

		int[] a = new int[]{64, 16, 4, 1};

		int len = a.length;

		int total = 1024 - n;

		int count = 0;

		for (int i = 0; i < len; i++) {

			int b = total / a[i];

			count += b;

			total = total - b * a[i];

			if (total <= 0) {
				break;
			}
			continue;
		}

		return count;


	}

	public static void main(String[] args) {

		System.out.println("=====请输入商品价格：");
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = getMaxCoin(n);

		System.out.println("======最小硬币数：" + count);

	}
}
