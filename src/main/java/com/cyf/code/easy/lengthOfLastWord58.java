package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午7:39 2018/9/17
 * @Desc ：
 */
public class lengthOfLastWord58 {

	public int lengthOfLastWord(String s) {
        if(s == null || "".equals(s.trim())){
        	return 0;
		}

		String [] array = s.split(" ");
        int len = array.length;
        return array[len-1].length();
	}

	public static void main(String[] args) {
		lengthOfLastWord58 ll = new lengthOfLastWord58();
		String className = ll.getClass().getName();
		System.out.println("====className="+className);

		lengthOfLastWord58 l2 ;
		try {
			l2 = (lengthOfLastWord58) Class.forName(className).newInstance();
			int res = l2.lengthOfLastWord("123 ss");
			System.out.println("=====res="+res);
		}catch (Exception e){
			System.out.println("====not found class");
		}





	}
}
