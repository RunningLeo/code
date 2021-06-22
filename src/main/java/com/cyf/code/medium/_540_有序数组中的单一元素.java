package com.cyf.code.medium;

/**
 * @desc:给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/23 下午5:25
 */
public class _540_有序数组中的单一元素 {

    public static int singleNonDuplicate(int[] nums) {

        int len = nums.length;

        int left = 0;
        int right = len - 1;


        while (left <= right){
            int mid = left + (right - left) / 2;

            boolean isSingle = isSingle(nums, mid);

            if(isSingle){
                return nums[mid];
            }else {

                if(mid == 0){
                    left = mid + 2;
                }else if(mid == len - 1){
                    right = mid - 2;
                }else {
                    if(nums[mid - 1] == nums[mid]){
                        if((mid - left + 1) % 2 == 0){
                            left  = mid +1;
                        }else {
                            right = mid - 2;
                        }
                    }else if(nums[mid + 1] == nums[mid]){
                        if((right - mid + 1) % 2 == 0){
                            right = mid - 1;
                        }else {
                            left = mid + 2;
                        }
                    }
                }
            }
        }

        return -1;


    }


    private static boolean isSingle(int[] nums, int index){

        int len = nums.length;

        if(len == 1){
            return true;
        }

        if(index == 0){
            return nums[index] != nums[index+1];
        }else if(index == len - 1){
            return nums[index] != nums[index - 1];
        }else {
            return nums[index] != nums[index+1] && nums[index] != nums[index - 1];
        }

    }


    public static void main(String[] args) {
        int [] nums = new int[]{3,10,10};
        int single = singleNonDuplicate(nums);

        System.out.println("===>single="+single);

    }
}
