package com.cyf.code.abc;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:06 2019-05-21
 * @Desc ：
 */
public class Isolation {


	public static int getMaxCount(int [] a, int d){

		int maxCount = 0;
		int start = 0;
		int end = 0;

		int n = a.length;

		while (start < n-2){

			while (end < a.length && a[end] - a[start] <= d){
				end++;
			}

			end -= 1;

			if(end - start <= 1){
				start++;
				continue;
			}else {
				maxCount += c(end-start, 2);
				start++;

			}

		}
		return maxCount;

	}


	public static int c(int n, int k) {
		if (k > n) {
			return 0;
		}

		if (k > n / 2) {
			k = n - k;
		}

		int down = 1;

		int up = 1;

		for (int i = 0; i < k; i++) {
			down *= n;
			n = n - 1;
			up *= (k - i);
		}
		return down / up;
	}


	public static void main(String[] args) {

		int[] isolation = new int[]{1, 5, 6, 7, 8, 12, 13};
	//	int[] isolation = new int[]{1, 2, 3, 4};

		int d = 3;

		int maxCount = getMaxCount(isolation, d);

		System.out.println("=====max="+maxCount);



	}
}
