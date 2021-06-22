package com.cyf.code.other;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:20 2019-08-12
 * @Desc ：
 */
public class DeadLock {

	private static DeadLock a = new DeadLock();

	private static DeadLock b = new DeadLock();


	public void methodA(){
		synchronized (a){
			System.out.println(Thread.currentThread().getName()+"======在A方法获得了a的锁");
			try {
				Thread.sleep(1000);
			}catch (Exception e){
				System.out.println(Thread.currentThread().getName()+"======A睡眠失败");
			}

			System.out.println(Thread.currentThread().getName()+"=====尝试在A方法拿到了b的锁");
			synchronized (b){
				System.out.println(Thread.currentThread().getName()+"=====在A方法拿到了b的锁");
			}

		}
	}

	public void methodB(){
		synchronized (b){
			System.out.println(Thread.currentThread().getName()+"=======在B方法获得b的锁");

			try {
				Thread.sleep(1000);
			}catch (Exception e){
				System.out.println(Thread.currentThread().getName()+"=====B睡眠失败");
			}

			System.out.println(Thread.currentThread().getName()+"====尝试在B方法获得a的锁");
			synchronized (a){
				System.out.println(Thread.currentThread().getName()+"========在B方法拿到了a的锁");
			}
		}

	}


	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				a.methodA();
			}
		});
		t1.setName("aaa");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				b.methodB();
			}
		});
		t2.setName("bbb");

		t1.start();
		t2.start();
	}
}
