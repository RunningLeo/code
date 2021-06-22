package com.cyf.code.medium;

import java.util.Arrays;

/**
 * @desc: 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 * <p>
 * 返回这两个区间列表的交集。
 * <p>
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。
 * 两个闭区间的交集是一组实数，要么为空集，要么为闭区间。
 * 例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 * <p>
 * 示例：
 * <p>
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/21 下午7:33
 */
public class _986_区间列表的交集 {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        int i = 0;
        int j = 0;

        int[][] res = new int[A.length * 2][];
        int index = 0;

        while (i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];

            int b1 = B[j][0];
            int b2 = B[j][1];

            //两个区间存在交集
            if (a2 >= b1 && b2 >= a1) {
                res[index++] = new int[]{Math.max(a1, b1), Math.min(a2, b2)};
            }

            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }

        return Arrays.copyOf(res, index);

    }

    public static void main(String[] args) {
        int[][] A = new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}};
        int[][] B = new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}};

        int[][] ints = intervalIntersection(A, B);

        System.out.println("===" + Arrays.deepToString(ints));

    }
}
