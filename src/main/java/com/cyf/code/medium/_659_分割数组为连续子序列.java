package com.cyf.code.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午9:57 2020/5/19
 * @Desc ：输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _659_分割数组为连续子序列 {

	public static boolean isPossible0(int[] nums) {

		Map<Integer, Integer> map = new HashMap();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

		}


		for (int i : nums){

			int next = i;

			int subLen = 0;

			int count = 1;

			//贪心结束的条件是某个元素的个数 要 >= 该元素 - 1的个数
			while (map.getOrDefault(next, 0) >= count){
				count = map.get(next);

				map.put(next, map.get(next) - 1);

				subLen++;

				next++;
			}

			if(subLen > 0 && subLen < 3){
				return false;
			}

		}

		return true;
	}


	public static void main(String[] args) {

		int[] a = new int[]{1, 2, 3, 3, 4, 5};

		boolean flag = isPossible0(a);

		System.out.println("===>" + flag);

	}
}
