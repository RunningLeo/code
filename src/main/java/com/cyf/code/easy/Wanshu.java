package com.cyf.code.easy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:17 2019-10-02
 * @Desc ：
 */
public class Wanshu {
	public static List<Integer> getNumbers(int n){

		List<Integer> result = Lists.newArrayList();

		//从2开始，是因为要找1，n的完数，但是1不是完数

		for (int i = 2; i< n; i++){
			boolean flag = isWanShu(i);
			if(flag){
				//是完数，存下来
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * 判断一个数是不是完数
	 * @param num
	 * @return
	 */
	public static boolean isWanShu(int num){

		int sum = 0;
		//Math.sqrt(num) 是一个数的平方根， 6的平方根取整是2
		for (int i = 1; i<= Math.sqrt(num); i++){
			if(num % i == 0){
				sum += i;
				if(i != 1){
					sum += (num / i);
				}
			}
			continue;
		}
		return num == sum;
	}


	public static void main(String[] args) {

		int n = 100;
		List<Integer> nums = getNumbers(n);
		//输出结果
		nums.stream().forEach(System.out::println);

	}
}
