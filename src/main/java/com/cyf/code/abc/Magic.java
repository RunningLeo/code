package com.cyf.code.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:10 2019-05-27
 * @Desc ：从一个3×4的方格中的一个顶点A到对顶顶点B的最短路线有几条？
 */
public class Magic {

	public static List<List<Integer>> magic(int row, int col){

		List<List<Integer>> result = new ArrayList<>();

		tracing(result, new ArrayList<>(), row, col);

		return result;

	}

	public static void tracing(List<List<Integer>> result, List<Integer> subList, int row, int col ){

		if(row == 0 && col == 0){
			result.add(new ArrayList<>(subList));
			return;
		}

		if(row > 0){
			//竖着走
			subList.add(1);
			tracing(result, subList, row-1, col);
			subList.remove(subList.size() -1);
		}

		if(col > 0){
			//横着走
			subList.add(2);
			tracing(result, subList, row, col-1);
			subList.remove(subList.size() -1);
		}

	}


	public static void main(String[] args) {
		int row = 3;
		int col = 4;

		List<List<Integer>> result = magic(row, col);

		System.out.println("=====row="+row+",col="+col+",的路径条数："+result.size());
		result.stream().forEach(System.out::println);
	}
}
