package com.cyf.code.zuo.chapter1;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午12:45 2020/4/16
 * @Desc ：用递归逆序一个栈
 */
public class ReverseStackByRecursive {

	/**
	 * 递归逆序一个栈
	 * @param stack
	 * @param <T>
	 * @return
	 */
	public static <T> void reverse(Stack<T> stack){

		if(stack.empty()){
			return;
		}

		//首先找到最后一个元素并将它移除出栈
		T last = findLastElementAndRemove(stack);

		//继续递归
		reverse(stack);

		stack.push(last);

	}


	private static <T> T findLastElementAndRemove(Stack<T> stack){
		T result = stack.pop();

		if(stack.empty()){
			return result;
		}

		T last = findLastElementAndRemove(stack);

		stack.push(result);

		return last;
	}


	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(3);
		stack.add(1);
		stack.add(8);
		stack.add(2);
		stack.add(6);
		reverse(stack);

		stack.stream().forEach(System.out::println);

	}
}
