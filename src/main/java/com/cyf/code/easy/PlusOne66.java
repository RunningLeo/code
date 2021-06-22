package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午7:47 2018/9/17
 * @Desc ：
 */
public class PlusOne66 {
	public static int[] plusOne(int[] digits) {
		int len = digits.length;

		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			}
			digits[i] = 0;
		}
		int[] newArray = new int[len + 1];
		newArray[0] = 1;
		return newArray;

	}


	public static void main(String[] args) {
		int[] nums = new int[]{9};
		int[] res = plusOne(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println("=======" + res[i]);
		}

	}
}
