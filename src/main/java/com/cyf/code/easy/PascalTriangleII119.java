package com.cyf.code.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:07 2019-02-19
 * @Desc ：
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalTriangleII119 {

	public static List<Integer> getRow(int rowIndex) {

		List<List<Integer>> triangles = new ArrayList<>();

		if (rowIndex == 0) {
			return Arrays.asList(1);
		}

		triangles.add(Arrays.asList(1));

		for (int i = 1; i <= rowIndex; i++) {

			List<Integer> preList = triangles.get(i - 1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			int preSize = preList.size();
			for (int j = 0; j < preSize - 1; j++) {
				cur.add(preList.get(j) + preList.get(j + 1));
			}
			cur.add(1);
			triangles.add(cur);
		}

		return triangles.get(rowIndex);
	}


	public static void main(String[] args) {

		List<Integer> res = getRow(3);

		System.out.println("====res=" + res);

	}
}
