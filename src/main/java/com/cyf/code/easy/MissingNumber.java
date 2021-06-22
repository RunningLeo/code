package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:29 2019-05-26
 * @Desc ：
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class MissingNumber {

	public static int missingNumber(int [] a){

		int n = a.length;

		int [] counts = new int[n+1];


		for (int i = 0; i <n ; i++) {
			counts[a[i]] = 1;
		}

		for (int i = 0; i <=n ; i++) {
			if(counts[i] != 1){
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int [] a = new int[]{9,6,4,2,3,5,7,0,1};
		int res = missingNumber(a);

		System.out.println("======res="+res);
	}
}
