package com.cyf.code.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:54 2018-12-22
 * @Desc ：
 */
public class YangHuiSanJIao118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		int i = 0;

		while (i< numRows){
			if(i == 0){
				List<Integer> first = new ArrayList<>();
				first.add(1);
				result.add(first);
				i++;
				continue;
			}else if(i == 1){
				List<Integer> sec = new ArrayList<>();
				sec.add(1);
				sec.add(1);
				result.add(sec);
				i++;
				continue;
			}
			List<Integer> pre = result.get(i-1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			int preSize = pre.size();
			for (int j = 0;j<preSize;j++){

				cur.add(pre.get(j)+pre.get(j+1));
				if(j == preSize -2){
					break;
				}
			}
			cur.add(1);
			result.add(cur);
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		YangHuiSanJIao118 y = new YangHuiSanJIao118();
		List<List<Integer>> result = y.generate(5);
		System.out.println("=======res="+result);
	}


}
