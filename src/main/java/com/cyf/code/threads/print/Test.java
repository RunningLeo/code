package com.cyf.code.threads.print;

import java.util.concurrent.Semaphore;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:48 2019-08-30
 * @Desc ：
 */
public class Test {


	public static void main(String[] args) {
		Semaphore A = new Semaphore(0);

		A.release(10);


		System.out.println("======="+A.availablePermits());

	}
}
