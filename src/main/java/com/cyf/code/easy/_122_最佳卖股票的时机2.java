package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:14 2019-02-19
 * @Desc ：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _122_最佳卖股票的时机2 {

	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int n = prices.length;
		int in = prices[0];
		int max = 0;
		int total = 0;

		for (int i = 1; i < n; i++) {

			if (prices[i] < in) {
				in = prices[i];
			} else {
				if (prices[i] - in > max) {
					if (i < n - 1 && prices[i] <= prices[i + 1]) {
						continue;
					}
					max = prices[i] - in;
					total += max;
					max = 0;
					if (i < n - 1) {
						in = prices[i + 1];
					}

				}
			}

		}

		return total;

	}


	public static int maxProfit2(int[] prices) {

		if(prices.length == 0){
			return 0;
		}

		int profit = 0;

		int min = prices[0];

		int len = prices.length;

		for (int i = 1; i < len; i++) {

			if(prices[i] < min){
				min = prices[i];
			}else {
				while (i < len - 1 && prices[i] < prices[i+1]){
					i++;
				}

				profit += prices[i] - min;
				min = prices[i];
			}
		}

		return profit;
	}


	public static int maxProfit3(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int profit = 0;


		for (int i = 1; i < prices.length; i++){

			int tempProfit = prices[i] - prices[i-1];
			if( tempProfit> 0){
				profit += tempProfit;
			}
		}


		return profit;


	}




	public static void main(String[] args) {
		int[] a = new int[]{7,1,5,3,6,4};
		int max = maxProfit3(a);
		System.out.println("====最大利润：" + max);

	}
}
