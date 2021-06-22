package com.cyf.code.sort.array;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:12 2019-03-14
 * @Desc ：字符串低位优先，适合于字符串长度相等的情况，不等长用MSD高位优先排序
 */
public class LSDSort {

	public static void LSD(String[] a) {

		if (Objects.isNull(a) || a.length == 1) {
			return;
		}


		int n = a.length;

		int w = a[0].length();

		String[] res = new String[n];

		int R = 256;

		int[] count = new int[R + 1];

		for (int i = w - 1; i >= 0; i--) {

			//初始化数组
			for (int j = 0; j < R+1; j++) {
				count[j] = 0;
			}

			//计算位置i上的字符频数
			for (int j = 0; j < n; j++) {
				int v = a[j].toCharArray()[i];
				count[v + 1]++;
			}

			//将频数转化为索引
			for (int j = 0; j < R; j++) {
				count[j + 1] += count[j];
			}

			//将元素分类
			for (int j = 0; j < n; j++) {
				int v = a[j].toCharArray()[i];
				res[count[v]++] = a[j];
			}

			//回写
			for (int j = 0; j < n; j++) {
				a[j] = res[j];
			}
		}
	}


	public static void main(String[] args) {
		String[] a = new String[]{"wsaca", "csdce", "tesba"};
		System.out.printf("before:\n");
		Arrays.stream(a).forEach(System.out::println);
		LSD(a);
		System.out.printf("\nafter:\n");
		Arrays.stream(a).forEach(System.out::println);


	}


}

