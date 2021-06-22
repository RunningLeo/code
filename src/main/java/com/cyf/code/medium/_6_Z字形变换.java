package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:18 2020/3/25
 * @Desc ：
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class _6_Z字形变换 {

	public static String convert(String s, int numRows) {

		if (s == null || s.length() == 0) {
			return "";
		}

		if (numRows == 1) {
			return s;
		}

		int len = s.length();


		int cells = (len & 1) == 0 ? len >> 1 : (len >> 1) + 1;

		char[][] arrays = new char[numRows][cells];

		int range = 2 * numRows - 2;

		//块
		//	int buck = len % range == 0 ? len / range : ( len / range ) + 1;


		for (int i = 0; i < len; i++) {

			//计算坐标

			int buck = i / range;

			int remain = i % range;

			int y = remain < numRows ? 0 : remain - numRows + 1;
			y = y + (numRows - 1) * buck;


			int x = remain < numRows ? remain : 2 * numRows - remain - 2;

			arrays[x][y] = s.charAt(i);
		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < cells; j++) {
				if (arrays[i][j] != '\u0000') {
					sb.append(arrays[i][j]);
				}
			}
		}

		return sb.toString();

	}


	public static String convert2(String s, int numRows) {

		if(numRows == 1){
			return s;
		}

		int len = s.length();

		char [] chars = s.toCharArray();

		char [] arrays = new char[len];

		int currentRow = 0;

		int arraysIndex = 0;

		int step = (numRows - 1) << 1;

		int index = 0;

		//处理第一行
		while (index < len){
			arrays[arraysIndex++] = chars[index];

			index += step;
		}

		// 处理中间行
		for (int i = 1; i <numRows - 1 ; i++) {

			int current = i;

			while (current < len){

				arrays[arraysIndex++] = chars[current];

				int temp = current + step - 2 * i;

				if(temp < len){
					arrays[arraysIndex++] = chars[temp];
				}

				current += step;
			}
		}

		//处理最后一行
		currentRow = numRows - 1;
		while (currentRow < len){
			arrays[arraysIndex++] = chars[currentRow];
			currentRow += step;
		}

		return new String(arrays);
}


	public static void main(String[] args) {

		String s = "LEETCODEISHIRING";
		int rows = 4;
		String res = convert2(s, rows);

		System.out.println("sss=" + s);
		System.out.print("res=" + res);


	}
}
