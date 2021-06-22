package com.cyf.code.abc;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:21 2019-05-20
 * @Desc ：
 */
public class Hight {

	public static Object getStartE(int[] h) {


		int len = h.length;

		double[] dp = new double[len];

		for (int i = len - 1; i > 0; i--) {
			if(h[i] > dp[i-1]){
				dp[i-1] = h[i] / 2;
			}else {
				dp[i-1] = Math.max(0, dp[i] - h[i]);
			}

		}

		return dp[0];


	}

	public static void main(String[] args) {
		int h[] = new int[]{3,4,3,2,4};

		Object res = getStartE(h);

		System.out.println("=====最初最小能量:+" + res);


	}
}
