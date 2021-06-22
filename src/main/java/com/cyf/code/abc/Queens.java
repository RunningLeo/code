package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:32 2019-05-27
 * @Desc ：
 */
public class Queens {

	public static List<List<String>> solveNQueens(int n) {

		List<List<String>> result = new ArrayList<>();

		int [] [] sub = new int[n][n];

		tracing(result, sub, n, 0);

		return result;

	}


	public static void tracing(List<List<String>> result, int [] [] sub, int n, int row){

		if(n == 0){
			List<String> subList = new ArrayList<>();
			for (int i = 0; i <sub.length ; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j <sub.length ; j++) {
					if(sub[i][j] == 1){
						sb.append("Q");
					}else {
						sb.append(".");
					}

				}
				subList.add(sb.toString());
			}
			result.add(subList);
			return;
		}

		for (int i = row; i < sub.length ; i++) {
			for (int j = 0; j < sub.length ; j++) {

				if(!isOk(i,j,sub)){
					continue;
				}
				//同行，同列，同斜线不能放
				sub[i][j] = 1;

				tracing(result, sub, n-1, i+1);

				sub[i][j] = 0;

			}
		}

	}

	/**
	 * 判断a[i][j]能不能放
	 * @param i
	 * @param j
	 * @param sub
	 * @return
	 */
	public static boolean isOk(int i, int j, int [] [] sub){

		int n = sub.length;

		for (int k = 0; k <n ; k++) {

			if(sub[i][k] == 1 || sub[k][j] == 1){
				return false;
			}

			if(k == 0){
				continue;
			}

			if(i + k < n && j + k < n){
				if(sub[i+k][j+k] == 1){
					return false;
				}
			}

			if(i - k >=0 && j-k >= 0){
				if(sub[i-k][j-k] == 1){
					return false;
				}
			}

			if(i-k >= 0 && j+k <n){
				if(sub[i-k][j+k] == 1){
					return false;
				}
			}

			if(i+k < n && j-k >= 0){
				if(sub[i+k][j-k] == 1){
					return false;
				}
			}

		}

		return true;



	}


	public static void main(String[] args) {

		int n = 4;
		List<List<String>> result = solveNQueens(n);

		System.out.println("======n="+n+"=的N皇后问题的解法数一共有："+result.size());

		result.stream().forEach(System.out::println);


	}
























	/**
	 *  * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
	 *  * 上图为 8 皇后问题的一种解法。
	 *  *
	 *  * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
	 *  *
	 *  * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
	 *  *
	 *  * 输入: 4
	 *  * 输出: [
	 *  *  [".Q..",  // 解法 1
	 *  *   "...Q",
	 *  *   "Q...",
	 *  *   "..Q."],
	 *  *
	 *  *  ["..Q.",  // 解法 2
	 *  *   "Q...",
	 *  *   "...Q",
	 *  *   ".Q.."]
	 *  * ]
	 *  * 解释: 4 皇后问题存在两个不同的解法。
	 */
}
