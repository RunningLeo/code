package com.cyf.code.niuke;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:22 2020-02-24
 * @Desc ：
 */
import java.util.*;

public class Main{

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String s = input.nextLine();
			String[] t = s.split(" ");
			int[] p = new int[t.length];

			for (int i = 0; i < t.length; i++) {
				p[i] = Integer.valueOf(t[i]);
			}

			int minPrice = p[0];
			int profit = 0;
			for (int i = 1; i < p.length; i++) {

				if(minPrice > p[i]){
					minPrice = p[i];
				}

				profit = Math.max(profit, p[i] - minPrice);

			}
			System.out.println(profit);
		}
	}
}
