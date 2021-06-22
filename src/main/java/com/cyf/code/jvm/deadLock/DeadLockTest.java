package com.cyf.code.jvm.deadLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:19 2020/5/12
 * @Desc ：验证死锁并且通过 命令行找出是哪个线程被死锁了
 */
public class DeadLockTest {

	public Object o1 = new Object();

	public Object o2 = new Object();


	public void A(){

		synchronized(o1){

	//		System.out.println("==>threadName="+Thread.currentThread().getName()+"===>尝试获取o2的锁");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			B();
		}

	}


	public void B(){

		synchronized(o2){

	//		System.out.println("==>threadName="+Thread.currentThread().getName()+"===>尝试获取o1的锁");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			A();
		}
	}


	public static void main(String[] args) {
		DeadLockTest tt1 = new DeadLockTest();
		DeadLockTest tt2 = new DeadLockTest();


		Thread t1 = new Thread(() -> {
			tt1.A();
		}, "t1");

		Thread t2 = new Thread(() -> {
			tt2.B();
		}, "t2");


		t1.start();
		t2.start();
	}
}
