package com.cyf.code.jvm.deadLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:03 2020/5/12
 * @Desc ：
 */
public class Test {

	public static void main(String[] args) {
		while (true){
			System.out.println("===="+(1+1));
		}
	}
}
