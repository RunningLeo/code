package com.cyf.code.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:46 2018-12-22
 * @Desc ：快乐数
 */
public class HappyNumber {

	public boolean isHappy(int n) {

		if(n <= 0){
			return false;
		}

		Set<Integer> numSet = new HashSet<>();
		numSet.add(n);

		while (n != 1) {
			n = dealNumber(n);
			if (n == 1) {
				return true;
			}

			if (numSet.contains(n)) {
				return false;
			}
			numSet.add(n);

		}

		return true;

	}


	private int dealNumber(int n) {
		int sum = 0;
		while (n > 0) {
			int a = n % 10;
			sum += a * a;
			n /= 10;
		}
		return sum;
	}


	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		boolean res = h.isHappy(2);
		System.out.println("====res=" + res);
	}


}
