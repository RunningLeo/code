package com.cyf.code.jvm.oom;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:39 2020/5/29
 * @Desc ：
 */
public class OomTest {

	public static void main(String[] args) {

		/**
		 * -Xmx10m -Xms10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/leo/Desktop/
		 */
		List<Integer> list = new ArrayList<>();

		while (true){
			list.add(RandomUtils.nextInt());
		}
	}
}
