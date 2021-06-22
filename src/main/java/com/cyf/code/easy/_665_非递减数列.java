package com.cyf.code.easy;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 4,5,3 因为 3<5 且 3< 4， 则改成 4，5，6
 * 4，6，5因为5< 6但是 5 > 4，则改成 4，6，6
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _665_非递减数列 {

    public static boolean checkPossibility(int[] nums) {

        int len = nums.length;

        if(len <= 2){
            return true;
        }

        int count = 0;

        for (int i = 1; i < len; i++) {

            if(nums[i-1] > nums[i]){
                count++;

                if(i >= 2 && nums[i-2] > nums[i]){
                    nums[i] = nums[i-1];
                }else {
                    nums[i-1] = nums[i];
                }
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{3,4,2,3};

        boolean flag = checkPossibility(nums);

        System.out.println("===>"+flag);

    }
}
