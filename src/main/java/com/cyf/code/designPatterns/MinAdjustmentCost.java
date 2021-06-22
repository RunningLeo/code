package com.cyf.code.designPatterns;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:54 2019-03-15
 * @Desc ：字符串A编辑成字符串B可有三种操作： 插入、删除、修改，对应的代价为i，d，r，
 * 给出字符串A和字符串B以及各自长度m、n，返回字符串A编辑成字符串B的最小代价。
 */
public class MinAdjustmentCost {

	public static int minCost(String a, String b, int i, int d, int r) {

		if (a == null || b == null) {
			return 0;
		}

		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();

		int m = a.length();
		int n = b.length();

		int[][] dp = new int[m + 1][n + 1];

		//dp[i][j] 表示 a[0...i-1] 到 b[0....j-1]的最小代价

		//如果a为空字符串
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j * i;
		}

		//如果b为空串
		for (int j = 1; j <= m; j++) {
			dp[j][0] = j * d;
		}

		for (int j = 1; j <= m; j++) {

			for (int k = 1; k <= n; k++) {

				if(aa[j-1] == bb[k-1]){
					dp[j][k] = dp[j-1][k-1];
				}else {
					dp[j][k] = dp[j-1][k-1] + r;
				}

				dp[j][k] = Math.min(dp[j][k], dp[j][k-1] + i);
				dp[j][k] = Math.min(dp[j][k], dp[j-1][k] + d);

			}

		}
		return dp[m][n];


	}

	public static void main(String[] args) {
		String a = "sdsf";
		String b = "";
		int i = 5;
		int d = 2;
		int r = 3;

		int minCost = minCost(a, b, i, d, r);

		System.out.printf("最小代价：" + minCost);
	}
}
