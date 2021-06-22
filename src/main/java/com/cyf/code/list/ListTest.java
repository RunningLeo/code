package com.cyf.code.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:20 2020-01-09
 * @Desc ：
 */
public class ListTest {

	public static void main(String[] args) {
		List<String> lists = new ArrayList<>();

		for (int i = 0; i< 3;i++){
			new Thread(() -> {
				String ss = UUID.randomUUID().toString().substring(0, 8);
			//	System.out.println(Thread.currentThread().getName()+"---->"+ss);
				lists.add(ss);
				System.out.println(Thread.currentThread().getName()+"---->"+lists);
			}).start();
		}

		/**
		 * 线程安全的list
		 * Vector
		 * Collections.synchronizedList();
		 * CopyOnWriteArrayList();
		 */


	}
}
