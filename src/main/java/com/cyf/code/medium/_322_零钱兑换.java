package com.cyf.code.medium;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:54 2020/3/8
 * @Desc ：
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _322_零钱兑换 {

	public static int coinChange(int[] coins, int amount) {

		//排序
		Arrays.sort(coins);

		int[] coinsNew = new int[coins.length];

		for (int i = coins.length - 1; i >= 0; i--) {
			coinsNew[coins.length - 1 - i] = coins[i];
		}

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> subList = new ArrayList<>();

		tracing(result, subList, coinsNew, amount);


		System.out.println("=====res=" + result.toString());

		return result.size() > 0 ? result.get(0).size() : 0;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int[] a, int amount) {

		long sum = 0;
		for (int i = 0; i < subList.size(); i++) {
			sum += subList.get(i);
		}
		if (sum == amount) {
			result.add(new ArrayList<>(subList));
		}

		int n = a.length;

		if (sum > amount) {
			return;
		}

		for (int i = 0; i < n; i++) {

			//跳过重复的元素
//			if (i > 0 && a[i] == a[i - 1]) {
//				continue;
//			}
			subList.add(a[i]);

			tracing(result, subList, a, amount);

			if (result.size() > 0) {
				return;
			}

			subList.remove(subList.size() - 1);

		}


	}


	public static int coinChange2(int[] coins, int amount) {

		int len = coins.length;
		int[] dp = new int[amount + 1];
		for (int i = 0; i < amount + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[amount] = 0;

		for (int i = 0; i < len; i++) {
			for (int j = amount - coins[i]; j >= 0; --j)
				if (dp[j + coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min((dp[j + coins[i]] + 1), dp[j]);
				}
		}
		return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
	}


	public static void main(String[] args) {

		int[] coins = new int[]{5,3,1};
		int amount = 11;

		int count = coinChange2(coins, amount);


		System.out.println("=====count=" + count);

	}
}
