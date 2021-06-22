package com.cyf.code.hard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午9:56 2020/5/11
 * @Desc ：由linkHashMap 实现LRU
 */
public class LRUByLinkHashMap<K,V> {

	private LinkedHashMap<K,V> linkedHashMap;

	private static volatile float hashLoadFactor = 0.75f;

	private int cacheSize ;

	/**
	 * .....constructor.....
	 * @param cacheSize
	 */
	public LRUByLinkHashMap(int cacheSize){

		this.cacheSize = cacheSize;
		int capital = (int)Math.ceil(cacheSize/hashLoadFactor) + 1;
		linkedHashMap = new LinkedHashMap(capital, hashLoadFactor, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				//大于cacheSize的时候开始移除最近最少使用的元素
				return size() > LRUByLinkHashMap.this.cacheSize;
			}
		};
	}


	public V get(K key){
		return linkedHashMap.get(key);
	}

	public V put(K key, V value){
		return linkedHashMap.put(key, value);
	}

	public void clear(){
		linkedHashMap.clear();
	}

	public int getUseSize(){
		return linkedHashMap.size();
	}

	public void print(){

		System.out.println();
		for (Map.Entry<K, V> entry : linkedHashMap.entrySet()){
			System.out.println("===>key="+entry.getKey()+"====>value="+entry.getValue());
		}
		System.out.println();
	}


	public static void main(String[] args) {
		LRUByLinkHashMap<Integer, Integer> map = new LRUByLinkHashMap(3);

		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);

		map.print();

		map.put(4, 4);

		map.print();

		map.put(5, 5);

		map.print();

	}




}
