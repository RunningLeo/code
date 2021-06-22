package com.cyf.code.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @desc: 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *  
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/21 下午5:33
 */
public class _1288_删除被覆盖区间 {

    public static int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;

        if(n == 0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[][] res = new int[n][];

        res[0] = intervals[0];

        int index = 0;

        for (int i = 1; i < n; i++) {

            if (intervals[i][1] > res[index][1]) {
                if(intervals[i][0] == res[index][0]){
                    res[index] = intervals[i];
                }else {
                    res[++index] = intervals[i];
                }
            }
        }

        return index + 1;

    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{1, 4}, new int[]{3, 4}};

        int count = removeCoveredIntervals(intervals);

        System.out.println("===" + count);
    }
}
