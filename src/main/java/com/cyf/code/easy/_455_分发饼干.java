package com.cyf.code.easy;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:56 2020-02-20
 * @Desc ：https://leetcode-cn.com/problems/assign-cookies/
 */
public class _455_分发饼干 {


	public static int findContentChildren(int[] g, int[] s) {

		//数组从小到大排列
		Arrays.sort(g);
		Arrays.sort(s);

		//孩子指针
		int i = 0;
		//饼干指针
		int j = 0;

		while (i < g.length && j< s.length){

			if(g[i] <= s[j]){
				i++;
			}

			j++;
		}

		return i;

	}


	public static void main(String[] args) {
		int [] children = new int[]{3,2,1};
		int [] cookies = new int[]{1,2};

		int count = findContentChildren(children, cookies);

		System.out.println("===满足的孩子数："+count);
	}
}
