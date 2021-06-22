package com.cyf.code.zuo.chapter1;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:18 2018/12/6
 * @Desc ：实现一个特殊的栈，可以返回栈中最小的元素，pop,push,getMin时间复杂度都是o(1)
 */
public class StackGetMin {

	private Stack<Integer> stackData;

	private Stack<Integer> stackMin;

	public StackGetMin(Stack<Integer> stackData, Stack<Integer> stackMin){
		this.stackData = stackData;
		this.stackMin = stackMin;
	}

	/**
	 * push
	 */
	public void push(int number){
		if(stackMin.isEmpty()){
			stackMin.push(number);
		}else if(number <= stackMin.peek()) {
			stackMin.push(number);
		}
		stackData.push(number);
	}

	/**
	 * pop
	 */
	public Integer pop(){
		if(stackData.isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		int value = stackData.pop();
		if(value <= stackMin.peek()){
			stackMin.pop();
		}

		return value;
	}

	/**
	 * getMin
	 */
	public Integer getMin(){
		if(stackMin.isEmpty()){
			throw new RuntimeException(" no min number");
		}else {
			return stackMin.peek();
		}
	}


}
