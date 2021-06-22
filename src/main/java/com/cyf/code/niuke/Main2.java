package com.cyf.code.niuke;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:26 2020-02-24
 * @Desc ：
 */

import java.util.*;

public class Main2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			String[] arrays = input.split(",");

			int len = arrays.length;

			int[] nums = new int[len];

			for (int i = 0; i < len; i++) {
				nums[i] = Integer.valueOf(arrays[i]);
			}

			//开始处理逻辑
			int maxProfit = 0;
			int minPrice = nums[0];

			for (int i = 0; i < len; i++) {

				if(minPrice > nums[i]){
					minPrice = nums[i];
				}


				maxProfit = Math.max(maxProfit, nums[i] - minPrice);
			}


			System.out.println(maxProfit);
		}

	}
}
