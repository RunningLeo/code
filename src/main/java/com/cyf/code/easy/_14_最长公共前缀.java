package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:02 2020/3/27
 * @Desc ：
 */
public class _14_最长公共前缀 {

	public static String longestCommonPrefix(String[] strs) {

		int len = strs.length;

		if(len == 0){
			return "";
		}

		String first = strs[0];

		int fl = first.length();

		if(fl == 0){
			return "";
		}

		int index = 0;

		StringBuilder common = new StringBuilder();

		while (index < fl){

			char cur = first.charAt(index);

			for (int i = 1; i < len; i++) {

				if(strs[i].length() <= index || strs[i].charAt(index) != cur){
					return common.toString();
				}

			}
			common.append(cur);
			index++;
		}

		return common.toString();
	}

	public static void main(String[] args) {

		String [] strs = new String[]{"aa", "a"};
		String common = longestCommonPrefix(strs);

		System.out.println("====common="+common);
	}
}



/**
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-prefix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/