package com.cyf.code.medium;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午9:36 2020/3/28
 * @Desc ：
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _93_复原IP地址 {

	private static List<String> res = new ArrayList<>();

	public static List<String> restoreIpAddresses(String s) {

		//超过12位或者小于4位，或者以0开头
		if (s.length() > 12 || s.length() < 4) {
			return res;
		}

		//回溯算法，不断的尝试
		tracingBack(new ArrayList<>(), s, 0);

		return res;
	}


	private static void tracingBack(List<String> temp, String s, int start) {

		int len = s.length();

		int size = temp.size();

		//完成条件
		if (temp.size() == 4 && start >= len) {
			// 拼接处结果
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				if (i != 0) {
					sb.append(".");
				}
				sb.append(temp.get(i));
			}
			res.add(sb.toString());
			return;
		}

		for (int i = start + 1; i <= start + 3 && i <= len; i++) {

			String sub = s.substring(start, i);

			if (!isSubIp(sub)) {
				continue;
			}

			temp.add(sub);
			tracingBack(temp, s, i);
			temp.remove(temp.size() - 1);

		}


	}


	/**
	 * 判断字符串能不能构成子ip
	 *
	 * @param sub
	 * @return
	 */
	private static boolean isSubIp(String sub) {

		if (sub == null || sub.length() == 0) {
			return false;
		}

		int len = sub.length();
		if (len > 1 && sub.charAt(0) == '0') {
			return false;
		}

		if (Integer.parseInt(sub) > 255) {
			return false;
		}

		return true;
	}


	public static void main(String[] args) {
		String s = "0000";
		List<String> res = restoreIpAddresses(s);

		System.out.println(res.toString());
	}
}
