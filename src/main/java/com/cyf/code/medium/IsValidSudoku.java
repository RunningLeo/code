package com.cyf.code.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:48 2019-05-25
 * @Desc ：
 */
public class IsValidSudoku {

	public static boolean isValidSudoku(char[][] a) {

		for (int i = 0; i < 9; i++) {

			Set<Character> rows = new HashSet<>();
			Set<Character> col = new HashSet<>();

			for (int j = 0; j < 9; j++) {

				if (a[i][j] == '.') {
					continue;
				}
				if (rows.contains(a[i][j]) || col.contains(a[j][i])) {
					return false;
				}
				rows.add(a[i][j]);
				col.add(a[j][i]);
			}
		}

//		for (int j = 0; j < 9; j++) {
//
//			Set<Character> sets = new HashSet<>();
//
//			for (int i = 0; i < 9; i++) {
//
//				if (a[i][j] == '.') {
//					continue;
//				}
//				if (sets.contains(a[i][j])) {
//					return false;
//				}
//				sets.add(a[i][j]);
//			}
//		}

		for (int ik = 0; ik < 3; ik++) {


			for (int jk = 0; jk < 3; jk++) {

				Set<Character> sets = new HashSet<>();

				for (int i = ik * 3; i <= ik * 3 + 2; i++) {

					for (int j = jk * 3; j <= jk * 3 + 2; j++) {

						if (a[i][j] == '.') {
							continue;
						}
						if (sets.contains(a[i][j])) {
							return false;
						}
						sets.add(a[i][j]);
					}

				}

			}

		}

		return true;


	}


	public static void main(String[] args) {
		char[][] board = new char[][]{
				{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
				{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '3', '.', '.', '1'},
				{'8', '.', '.', '.', '.', '.', '.', '2', '3'},
				{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
				{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
				{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
				{'.', '.', '4', '.', '.', '.', '.', '.', '.'}
		};


		boolean res = isValidSudoku(board);

		System.out.println("==========" + res);
	}

}
