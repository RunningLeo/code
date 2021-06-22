package com.cyf.code.jvm;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:32 2019-09-04
 * @Desc ：
 */
public class InitTest {

	static class Parent{
		public static int A = 1;

		static {
			A = 2;
		}
	}

	static class Sub extends Parent{
		public static int B = A;
	}

	public static void main(String[] args) {
		System.out.println("====="+Sub.B);
	}
}
