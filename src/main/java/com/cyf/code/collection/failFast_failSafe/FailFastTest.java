package com.cyf.code.collection.failFast_failSafe;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:38 2020/5/23
 * @Desc ：
 * 快速失败：在遍历集合的时候，集合发生了修改，则立刻抛出异常java.util.ConcurrentModificationException
 */
public class FailFastTest {

	public static void main(String[] args) {


		Map<String, String> map = Maps.newHashMap();

		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()){
			System.out.println("===>"+map.get(iterator.next()));

			map.put("d", "dd");
		}


	}
}
