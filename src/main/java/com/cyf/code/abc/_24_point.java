package com.cyf.code.abc;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:34 2020/3/9
 * @Desc ：
 * 有n个1~23的整数，写一个算法，求出有多少个相互不同的子集合的和为24点。
 *
 * 输入描述:
 * 输入数据包含一组，每组占一行，包括n个整数 （1<=整数<=23）
 * 输出描述:
 * 对于每个测试实例，要求输出能组成24点的所有子集合的数量（子集合相互不同）。如果不存在，则输出0。每个测试实例的输出占一行。
 * 输入样例:
 * 4
 * 1  2  22  23
 * 输出样例:
 *
 * 2
 *
 * 作者：jdzhangxin
 * 链接：https://www.jianshu.com/p/ad65c2974b1d
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class _24_point {

	static List<List<Integer>> result = Lists.newArrayList();

	public static int compute(int [] nums){

		List<Integer> subList = Lists.newArrayList();

		tracingBack(result, subList, nums, 0);

		System.out.println("====res="+result);

		return result.size();

	}


	private static void tracingBack(List<List<Integer>> result, List<Integer> subList, int [] nums, int start){


		//设置返回条件
		int sum = 0;
		for (int i = 0; i < subList.size() ; i++) {
			sum += subList.get(i);
		}

		if(sum == 24){
			result.add(new ArrayList<>(subList));
			return;
		}

		int len = nums.length;

		if(start == len){
			return;
		}

		for (int i = start; i < len; i++) {

			subList.add(nums[i]);

			tracingBack(result, subList, nums, i+1);

			subList.remove(subList.size() - 1);
		}

	}


	public static void main(String[] args) {

		int [] nums = new int[]{1,2,22,23};

		int count = compute(nums);

		System.out.println("====count="+count);
	}
}
