package com.cyf.code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:58 2019-02-15
 * @Desc ：
 */
public class TwoSum1 {

	public static int[] twoSum(int[] nums, int target) {

		int [] res = new int[2];

		int len = nums.length;

		Map<Integer, Integer> map = new HashMap<>(2, 1);

		for (int i = 0; i < len ; i++) {

			map.put(nums[i], i);
		}

		for (int i = 0; i < len; i++) {

			int other = target - nums[i];

			if(map.containsKey(other) && map.get(other) > i){
				res[0] = map.get(nums[i]);
				res[1] = map.get(other);
				break;
			}

		}

		return res;
	}

	public static void main(String[] args) {
		int [] a = new int[]{3,3};
		int [] b = twoSum(a, 6);
		Arrays.stream(b).forEach(System.out::println);

	}
}
