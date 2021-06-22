package com.cyf.code.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:05 2020/5/28
 * @Desc ：
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 */
public class _120_三角形最小路径和 {

	public static int minimumTotal(List<List<Integer>> triangle) {

		//动态规划 dp[i][j] 表示 从 下一层 到 [i][j]的最小路径和

		int i = triangle.size();

		int [][] dp = new int[i][i];

		//初始化最底层
		for (int j = 0; j < i ; j++) {
			dp[i-1][j] = triangle.get(i-1).get(j);
		}

		for (int j = i-2; j >=0 ; j--) {

			List<Integer> curRow = triangle.get(j);

			for (int k = 0; k <= j ; k++) {

				int cur = curRow.get(k);

				dp[j][k] = cur + Math.min(dp[j+1][k], dp[j+1][k+1]);
			}

		}
		return dp[0][0];
	}


	public static void main(String[] args) {

		List<List<Integer>> triangle = Lists.newArrayList();
		triangle.add(Lists.newArrayList(2));
		triangle.add(Lists.newArrayList(3,4));
		triangle.add(Lists.newArrayList(6,5,7));
		triangle.add(Lists.newArrayList(4,1,8,3));


		int min = minimumTotal(triangle);

		System.out.println("===>min="+min);
	}
}
