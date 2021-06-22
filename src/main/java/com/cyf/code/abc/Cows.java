package com.cyf.code.abc;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:53 2019-05-21
 * @Desc ：
 * 母牛从3~7岁初每年会生产1头小母牛，10岁后死亡（10岁任然存活），假设初始有一头刚出生的母牛，请问第n年有多少头母牛？（年从第一年开始计数）
 * <p>
 * 注：第三年初会出生 第一头母牛，故第三年有两头母牛。
 * <p>
 * 第五年初，第三年出生的母牛会生产，故第五年有五头母牛。
 * <p>
 * 岁数是虚数
 * 示例：
 * <p>
 * 输入	输出
 * 2	1
 * 3	2
 * 4	3
 * 5	5
 * 12	123
 */
public class Cows {

	public static int getNums(int n) {


		int[] total = new int[n];
		int sum = 0;

		total[0] = 1;
		total[1] = 1;

		for (int i = 2; i <n ; i++) {

			if(i>=2 && i<7){
				sum += total[i-2];
				total[i] = sum + 1;
			}else if(i>=7 && i<10){
				sum = sum - total[i-7] + total[i-2];
				total[i] = sum + 1;
			}else {
				sum = sum - total[i-7] + total[i-2];
				total[i] = sum;
			}
		}

		return total[n-1];


	}


	public static void main(String[] args) {
		int n = 12;
		int count = getNums(n);
		System.out.println("=====res=" + count);
	}

}
