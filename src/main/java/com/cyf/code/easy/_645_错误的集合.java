package com.cyf.code.easy;

import java.util.Arrays;

/**
 * @desc:
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/22 下午4:14
 */
public class _645_错误的集合 {

    public static int[] findErrorNums(int[] nums) {

        int len = nums.length;

        //将数组按照索引放到对应的位置上
        int index = 0;

        while (index < len){

            //当前索引对应的数字不匹配并且将要交换的位置的索引值也不匹配时，交换
            if(nums[index] != index + 1  && nums[nums[index] - 1] != nums[index]){
                swap(nums, index, nums[index] - 1);
            }else {
                index++;
            }
        }

        for (int i = 0; i <len ; i++) {
            if(nums[i] != i+1){
                return new int[]{nums[i], i+1};
            }
        }

        return new int[]{0, 0};

    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2,4,1,2};
        int[] errorNums = findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));

    }
}
