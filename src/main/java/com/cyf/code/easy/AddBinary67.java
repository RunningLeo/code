package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:54 2018/9/18
 * @Desc ：
 */
public class AddBinary67 {

	public String addBinary(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		int n = (lenA >= lenB) ? lenA : lenB;
		boolean flag = false;
		int[] resA = new int[n + 1];
		int[] resB = new int[n + 1];

		for (int i = 0, j=0 ; i<lenA&& j<lenB ; i++, j++) {
			if(i<lenA) {
				resA[n - i] = a.charAt(lenA-1-i) - '0';
			}
			if(j<lenB){
				resB[n - j] = b.charAt(lenB-1-j) - '0';
			}
		}
//
//		for (int i = 0; i < lenB; i++) {
//			resB[n - i] = b.charAt(lenB-1-i) - '0';
//		}

		for (int i = n; i >= 0; i--) {
			if (flag) {
				if (resA[i] + resB[i] < 1) {
					resA[i] += resB[i] + 1;
					flag = false;
				} else {
					resA[i] = (resA[i]+ resB[i]+1)%2;
					flag = true;
				}

			} else {
				if (resA[i] + resB[i] < 2) {
					resA[i] += resB[i];
					flag = false;
				} else {
					resA[i] = 0;
					flag = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <=n ; i++) {
			if(i == 0 && resA[0] == 0){
				continue;
			}
			sb.append(resA[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		AddBinary67 addBinary = new AddBinary67();
		System.out.println("====add=" + addBinary.addBinary(a, b));
	}
}
