package com.cyf.code.collection.failFast_failSafe;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:43 2020/5/23
 * @Desc ：安全失败：遍历集合的时候，涉及到的修改都会在副本中修改
 *
 * fail-safe机制有两个问题
 *
 * （1）需要复制集合，产生大量的无效对象，开销大
 *
 * （2）无法保证读取的数据是目前原始数据结构中的数据。
 */
public class FailSafeTest {


	public static void main(String[] args) {


//		Map<String, String> map = Maps.newConcurrentMap();
//
//		map.put("a", "aa");
//		map.put("b", "bb");
//		map.put("c", "cc");
//
//		Iterator<String> iterator = map.keySet().iterator();
//
//		while (iterator.hasNext()){
//			System.out.println("===>"+map.get(iterator.next()));
//
//			map.put("d", "dd");
//		}


		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);

		for(Integer item : list){
			System.out.println("===>"+item);
	//		list.remove(0);
		}


	}
}
