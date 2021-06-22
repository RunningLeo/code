package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @desc:
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/28 上午9:38
 */
public class _56_合并区间 {

    public static int[][] merge(int[][] intervals) {

        int len = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int [][] res = new int[len][];

        int index = -1;

        for (int i = 0; i < len; i++) {

            //不能合并
            if(index == -1 || intervals[i][0] > res[index][1]){
                res[++index] = intervals[i];
            }else {
                res[index][1] = Math.max(intervals[i][1], res[index][1]);
            }
        }

        return Arrays.copyOf(res, index+1);
    }

    public static void main(String[] args) {
        int [] [] intervals = new int[][]{new int[]{1,4}, new int[]{5,5}, new int[]{6,7}};

        int [] [] res = merge(intervals);

        System.out.println(Arrays.deepToString(res));
    }
}
