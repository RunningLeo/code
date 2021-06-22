package com.cyf.code.abc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:55 2019-05-20
 * @Desc ：
 */
public class Awards {

	public static Integer getMinAwards(int n, List<Integer> scores) {

		int[] awards = new int[scores.size()];
		for (int i = 0; i < awards.length; i++) {
			awards[i] = 1;
		}

		int minScore = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < scores.size() ; i++) {
			if(scores.get(i) < minScore){
				minScore = scores.get(i);
				minIndex = i;
			}
		}

		int leftIndex = minIndex -1;
		int rightIndex = minIndex+1;

		while (leftIndex >=0){
			if(scores.get(leftIndex) > scores.get(leftIndex + 1)){
				awards[leftIndex] = awards[leftIndex+1] +1;
			}
			leftIndex--;
		}

		while (rightIndex < n){
			if(scores.get(rightIndex) > scores.get(rightIndex - 1)){
				awards[rightIndex] = awards[rightIndex-1] +1;
			}
			rightIndex++;
		}

		if(scores.get(0) > scores.get(n-1)){
			awards[0] = Math.max(awards[0], awards[n-1]+1);
		}else {
			awards[n-1] = Math.max(awards[n-1], awards[0]+1);
		}

		int sum = Arrays.stream(awards).sum();

		return sum;
	}

	public static Integer getNextIndex(int i, int len) {

		return i < len - 1 ? i + 1 : 0;
	}

	public static Integer getPreIndex(int i, int len) {

		return i > 0 ? i - 1 : len - 1;
	}

	public static void main(String[] args) {
		System.out.println("====请输入人数：");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("====请输入分数：");
		Scanner sc1 = new Scanner(System.in);
		String scores = sc1.nextLine();

		String[] scoresS = scores.split(" ");

		List<Integer> scoreList = Arrays.stream(scoresS).map(Integer::valueOf).collect(Collectors.toList());

		Integer count = getMinAwards(n, scoreList);

		System.out.println("=====最少奖品：" + count);
	}
}
