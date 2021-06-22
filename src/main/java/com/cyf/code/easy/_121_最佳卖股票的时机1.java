package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:55 2019-02-19
 * @Desc ：
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _121_最佳卖股票的时机1 {

	public static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPrice = prices[0];
		int len = prices.length;

		for (int i = 1; i < len; i++) {

			if(prices[i] < minPrice){
				minPrice = prices[i];
				continue;
			}

			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;

	}


	public static void main(String[] args) {
		int [] a = new int[]{1,9,45,23,89,34};
		int max = maxProfit(a);
		System.out.println("====最大利润："+max);

	}

}


