package com.cyf.code.sword_to_offer;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:19 2020-03-03
 * @Desc ：
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class findNumberIn2DArray04 {


	public static boolean findNumberIn2DArray(int[][] matrix, int target) {

		if(matrix.length == 0 || matrix[0].length == 0){
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = m-1; i >= 0; i--){

			if(target < matrix[i][0]){
				continue;
			}

			for (int j = 0; j < n ; j++) {

				if(target > matrix[i][n-1] || target < matrix[i][0]){
					break;
				}

				if(target == matrix[i][j]){
					return true;
				}

			}
		}

		return false;

	}


	public static void main(String[] args) {
		int[][] matrix = new int[][]{
//				{1, 4, 7, 11, 15},
//				{2, 5, 8, 12, 19},
//				{3, 6, 9, 16, 22},
//				{10, 13, 14, 17, 24},
//				{18, 21, 23, 26, 30}};
				{-5}};

		int target = -5;

		boolean flag = findNumberIn2DArray(matrix, target);

		System.out.printf("====="+flag);
	}
}
