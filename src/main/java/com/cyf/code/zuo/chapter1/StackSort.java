package com.cyf.code.zuo.chapter1;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:16 2018/12/7
 * @Desc ：栈排序,从栈顶到栈底从大到小排序，可申请一个栈辅助
 */
public class StackSort {


	public static Stack<Integer> stackSort(Stack<Integer> stack) {

		if (stack.isEmpty()) {
			return stack;
		}

		Stack<Integer> help = new Stack<>();

		while (!stack.empty()){
			int cur = stack.pop();

			while (!help.empty() && help.peek() > cur){
				stack.push(help.pop());
			}

			help.push(cur);
		}


		return help;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(7);
		stack.push(1);
		stack.push(6);

		Stack<Integer> stackSort = stackSort(stack);

		while (!stackSort.isEmpty()) {
			System.out.println("======ele=" + stackSort.pop());
		}


	}
}
