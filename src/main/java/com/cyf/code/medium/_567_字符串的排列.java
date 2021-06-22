package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:25 2020/3/27
 * @Desc ：滑动窗口 解决，每次从s2拿出和s1一样长的字符串判断
 */
public class _567_字符串的排列 {

	public static boolean checkInclusion(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return false;
		}

		int[] book1 = new int[26];

		int[] book2 = new int[26];

		for (int i = 0; i < len1; i++) {
			book1[s1.charAt(i) - 'a']++;
			book2[s2.charAt(i) - 'a']++;
		}

		boolean res = checkSub(book1, book2);

		if (res) {
			return true;
		}

		int left = 0;
		int right = len1;

		while (right < len2) {
			book2[s2.charAt(left++) - 'a']--;
			book2[s2.charAt(right++) - 'a']++;

			res = checkSub(book1, book2);

			if (res) {
				return true;
			}

		}
		return false;

	}

	private static boolean checkSub(int[] book1, int[] book2) {
		int i = 0;
		int len = book1.length;
		while (i < len) {
			if (book1[i] != book2[i]) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidboaooo";
		boolean flag = checkInclusion(s1, s2);
		System.out.println("====" + flag);
	}
}

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
