package com.cyf.code.hard;

/**
 * @desc:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 * 示例 1：

 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/22 下午3:24
 */
public class _42_接雨水 {

    public static int trap(int[] height) {

        int len = height.length;

        if(len <= 2){
            return 0;
        }

        int res = 0;

        int left = 1;
        int right = len - 2;

        int leftMax = height[0];
        int rightMax = height[len-1];

        while (left <= right){

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int [] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        int res = trap(height);

        System.out.println("=="+res);
    }
}
