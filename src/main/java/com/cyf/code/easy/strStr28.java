package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:18 2018/9/17
 * @Desc ：
 */
public class strStr28 {

	public static int strStr(String haystack, String needle) {
		if(needle == null || "".equals(needle)){
			return 0;
		}

		char [] needleArray = needle.toCharArray();
		char [] haystackArray = haystack.toCharArray();
		int length = needleArray.length;
		int hayLength = haystackArray.length;
		if(length > hayLength){
			return -1;
		}
		int index = 0;
		for (int i = 0; i < hayLength; i++) {
			char cur = needleArray[0];
			if(haystackArray[i] == cur){
				index = i;
				for (int j = 0; j <length ; j++) {
					if((i+j >= hayLength) || haystackArray[i+j] != needleArray[j]){
						index = -1;
						break;
					}
				}
				if(index != -1){
					return index;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String one = "mississippi";
		String second = "mississippi";
		int result = strStr(one, second);
		System.out.println("======result="+result);

	}
}
