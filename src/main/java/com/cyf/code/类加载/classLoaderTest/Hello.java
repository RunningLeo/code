package com.cyf.code.类加载.classLoaderTest;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:36 2020-02-28
 * @Desc ：
 */
public class Hello {
	static {
		System.out.println("----hello--static-----");
	}

	public static void main(String[] args) {
		System.out.println("----hello---");
	}
}
