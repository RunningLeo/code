package com.cyf.code.zuo.chapter1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午12:17 2020/4/16
 * @Desc ：由两个栈组成队列, 一个用来压入数据，一个用来弹出数据
 */
@Slf4j
public class TwoStackQueue {

	public Stack<Integer> pushStack;

	public Stack<Integer> popStack;

	public TwoStackQueue(){
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}


	private void pushToPop(){
		if(popStack.empty()){
			while (!pushStack.empty()){
				popStack.push(pushStack.pop());
			}
		}
	}


	/**
	 * 压入数据
	 * @param pushInt
	 */
	public void add(int pushInt){
		pushStack.push(pushInt);
		pushToPop();
	}

	public int pop() throws Exception{
		if(pushStack.empty() && popStack.empty()){
			throw new Exception("队列为空");
		}
		if(!popStack.empty()){
			return popStack.pop();
		}
		pushToPop();
		return popStack.pop();

	}

	public int peek() throws Exception{
		if(pushStack.empty() && popStack.empty()){
			throw new Exception("队列为空2");
		}
		if(!popStack.empty()){
			return popStack.peek();
		}
		pushToPop();
		return popStack.peek();
	}


	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();

		try {
			queue.add(3);
			queue.add(1);
			queue.add(2);
			queue.add(6);
			int r1=  queue.pop();
			int r2 = queue.pop();
			int r3 = queue.peek();
			int r4 = queue.pop();
			int r5 = queue.pop();

			int r6 = queue.pop();

			System.out.println("====r1="+r1);
			System.out.println("====r2="+r2);
			System.out.println("====r3="+r3);

			System.out.println("====r4="+r4);
			System.out.println("====r5="+r5);

			System.out.println("====r6="+r6);

		}catch (Exception e){
			log.info("======异常=====");
		}


	}





}
