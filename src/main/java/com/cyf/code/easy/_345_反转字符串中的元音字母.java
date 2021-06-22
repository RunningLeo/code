package com.cyf.code.easy;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _345_反转字符串中的元音字母 {


    /**
     * 元音字母 a、e、i、o、u
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {

        if(s == null || s.length() <= 1){
            return s;
        }

        char [] arr = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right){

            if(!isVowels(arr[left])){
                left++;
                continue;
            }

            if(!isVowels(arr[right])){
                right--;
                continue;
            }

            //交换
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    private static boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {

        String s = "leetcode";

        String res = reverseVowels(s);

        System.out.println("===>res="+res);
    }
}
