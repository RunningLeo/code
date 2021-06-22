package com.cyf.code.abc;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:00 2019-05-23
 * @Desc ：
 */
public class Transfer {

	public static List<List<Integer>> trans(String [] a){

		if(a == null || a.length == 0){
			return new ArrayList<>();
		}

		int len = a.length;

		int n = 0;

		while (len != 0){
			len = len >> 1;
			n++;
		}

		List<List<Integer>> resultList = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {

			double startIndex = Math.pow(2, i) - 1;
			double endIndex = Math.pow(2, i+1) - 1;

			List<Integer> list = new ArrayList<>((int)Math.pow(2, i));

			for (int j = (int)startIndex; j <(int)endIndex; j++) {

				if(a[j] != "#"){
					list.add(Integer.valueOf(a[j]));
				}
			}

			if(list.size()>0){
				resultList.add(list);
			}
		}

		return resultList;
	}


	public static void main(String[] args) {
		String [] a = new String[]{"3", "9", "20", "#", "#", "15", "7", "#", "#"};
		List<List<Integer>> list = trans(a);

		System.out.println("========"+list);
	}
}
