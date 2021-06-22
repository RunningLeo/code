package com.cyf.code.sort.link;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:24 2019-03-30
 * @Desc ：链表快排序
 */
public class QuickSort {

	static class Node{
		private int value;
		private Node next;

		Node(int value){
			this.value = value;
		}
	}

	static class DoubleNode{
		private int value;
		private DoubleNode next;
		private DoubleNode pre;

		DoubleNode(int value){
			this.value = value;
		}

	}


	/**
	 * 单链表快速排序
	 * @param begin
	 * @param end
	 */
	public static void quickSort(Node begin, Node end){

		if(begin == null || end == null || begin == end){
			return;
		}

		int pivot = begin.value;
		Node first = begin;
		Node second = begin.next;                  //用来遍历的指针

		while( second != end.next){
			if( second.value < pivot){      //对于小于轴的元素放在左边
				first.value = second.value;
				first = second;
			}
			second = second.next;
		}
		first.value = pivot;
		quickSort(begin, first);
		quickSort(first.next, end);

	}

	/**
	 * 双向链表快速排序
	 */
	public static  void  doubleQuickSort(DoubleNode begin, DoubleNode end){

		if(begin == null || end == null || begin == end){
			return;
		}

		DoubleNode left = begin;
		DoubleNode right = end;

		int pivot = begin.value;

		while (left != right){
			if(left.next.value < pivot){
				left.value = left.next.value;
				left = left.next;
			}else {
				int temp = left.next.value;
				left.next.value = right.value;
				right.value = temp;
				right = right.pre;
			}
		}
		left.value = pivot;
		doubleQuickSort(begin, left.pre);
		doubleQuickSort(left.next, end);


	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(1);
		Node n3 = new Node(5);

		Node n4 = new Node(0);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		quickSort(n1, n4);
		Node head = n1;

		while (head != null){
			System.out.println("=====val="+head.value);
			head = head.next;
		}


		/**
		 * 双向链表
		 */

		DoubleNode n11 = new DoubleNode(3);
		DoubleNode n22 = new DoubleNode(1);
		DoubleNode n33 = new DoubleNode(5);


		n11.next = n22;
		n22.pre = n11;


		n22.next = n33;
		n33.pre = n22;

		n33.next = null;

		doubleQuickSort(n11, n33);

		DoubleNode doubleHead = n11;

		while (doubleHead != null){
			System.out.println("==double===val="+doubleHead.value);
			doubleHead = doubleHead.next;
		}




	}
}
