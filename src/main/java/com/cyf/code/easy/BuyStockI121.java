package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:30 2019-12-26
 * @Desc ：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：最大的利润只需要在卖出的那天，找到在此天之前的最小价格，差值就是当天卖出时获取的最大利润。
 *      遍历每一天，获得每天卖出时的利润，从而找到最大利润
 */
public class BuyStockI121 {

	public static int maxProfit(int [] prices){

		if(prices.length == 0){
			return 0;
		}

		int minPrice = prices[0];
		int maxProfit = 0;
		int len = prices.length;

		for (int i = 1; i< len; i++){

			if(prices[i] < minPrice){
				minPrice = prices[i];
			}

			maxProfit = Math.max(maxProfit, prices[i] - minPrice);

		}

		return maxProfit;
	}





	public static void main(String[] args) {

		int [] price = new int[]{7,1,5,3,6,4};
		int maxProfit = maxProfit(price);
		System.out.printf("====maxProfit="+maxProfit);

	}
}
