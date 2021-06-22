package com.cyf.code.sword_to_offer;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:39 2020/3/6
 * @Desc ：
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence57 {

	public static int [] [] findContinuousSequence(int target) {

		int begin = target >> 1;

		List<int []> result = new ArrayList<>();

		int end = begin + 1;

		while (begin >0 && begin <= end){

			int sum = 0;

			for (int i = begin; i <= end; i++) {
				sum+= i;
			}

			int remain = sum - target;

			if(remain == 0){

				int [] temp = new int[end - begin + 1];
				int k = 0;
				for (int i = begin; i <= end; i++) {
					temp[k++] = i;
				}
				result.add(temp);
				begin--;
				end--;
			}else if(remain < 0){
				begin--;
			}else {
				end--;
				if(remain >= 2){
					begin--;
				}

			}
		}

		int size = result.size();
		int [] [] res = new int[size][];
		int m = 0;

		for (int i = size-1; i >= 0 ; i--) {
			res[m++] = result.get(i);
		}

		return res;


	}


	public static void main(String[] args) {
		int target = 9;
		int [] [] result = findContinuousSequence(target);

		Arrays.stream(result).forEach( o -> Arrays.toString(o));

		System.out.println("====" + result.toString());


	}
}
