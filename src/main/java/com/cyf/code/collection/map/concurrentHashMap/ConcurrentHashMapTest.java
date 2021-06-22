package com.cyf.code.collection.map.concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:13 2020/5/15
 * @Desc ：
 */
public class ConcurrentHashMapTest {


	public static void main(String[] args) {

		ConcurrentHashMap map = new ConcurrentHashMap();

		map.put(1, 1);

		System.out.println("==="+map.get(1));
	}
}
