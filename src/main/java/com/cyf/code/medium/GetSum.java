package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:41 2019-05-26
 * @Desc ：
 */
public class GetSum {

	public static int getSum(int a, int b){

		int sum, carry;
		sum = a ^ b;
		/**异或这里可看做是相加但是不显现进位，比如5 ^ 3
                 /*0 1 0 1
                   0 0 1 1
                 ------------
                   0 1 1 0
              上面的如果看成传统的加法，不就是1+1=2，进1得0，但是这里没有显示进位出来，仅是相加，0+1或者是1+0都不用进位*/

		carry = (a & b) << 1;

		/**相与为了让进位显现出来，比如5 & 3
                /* 0 1 0 1
                   0 0 1 1
                 ------------
                   0 0 0 1
              上面的最低位1和1相与得1，而在二进制加法中，这里1+1也应该是要进位的，所以刚好吻合，但是这个进位1应该要再往前一位，所以左移一位*/

		//经过上面这两步，如果进位不等于0，那么就是说还要把进位给加上去，所以用了尾递归，一直递归到进位是0。
		if(carry != 0)
		{
			return getSum(sum, carry);
		}
		return sum;
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int c = getSum(a, b);
		System.out.println("====c="+c);
	}
}
