package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:27 2019-09-05
 * @Desc ：
 */
public class ArrangeCoins441 {

	public static int arrangeCoins(int n) {

		if(n <= 0){
			return 0;
		}

		int num = 1;

		int temp = 0;

		while (temp <= n - num){
			temp += num;
			num++;
		}

		return num - 1;

	}


	public static void main(String[] args) {
		int n = 2147483647;
		int res = arrangeCoins(n);

		System.out.println("=====res="+res);
		System.out.println("======"+Integer.MAX_VALUE);
	}
}
