package com.cyf.code.hard;

import java.util.HashMap;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:19 2019-03-02
 * @Desc ：用hashMap和双向链表实现LRU, 具体的做法是：
 * put一个元素时，首先看一下Map中是否已经有了，如果有了，则删除链表中原来的节点，把新节点放在链表头部
 *
 *
 */
public class LRUCache146 {

	private HashMap<Integer, DoubleLinkedListNode> map
			= new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;

	public LRUCache146(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else {
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;

		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}

		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}

	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}

		head = node;
		if (end == null) {
			end = node;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode =
					new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}

				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}


	public static void main(String[] args) {

	}
}

class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int key, int value) {
		val = value;
		this.key = key;
	}
}
