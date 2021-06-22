package com.cyf.code.lock.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:30 2020/5/10
 * @Desc ：实现一个独占锁
 */
public class MyExclusiveLock implements Lock {

	private final Sync sync = new Sync();


	/**
	 * 覆盖同步器方法
	 */
	private static class Sync extends AbstractQueuedSynchronizer{

		protected Sync() {
			super();
		}

		@Override
		protected boolean tryAcquire(int arg) {
			//暂不支持可重用
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			if(getState() == 0){
				throw new UnsupportedOperationException("===>Lock 无法释放, "+Thread.currentThread().getName());
			}
			//此时已经拿到锁，不需要考虑原子性
			setState(0);
			setExclusiveOwnerThread(null);
			return true;
		}

		//因为要实现独占锁，所以共享锁的方法不需要实现
//		@Override
//		protected int tryAcquireShared(int arg) {
//			return super.tryAcquireShared(arg);
//		}
//
//		@Override
//		protected boolean tryReleaseShared(int arg) {
//			return super.tryReleaseShared(arg);
//		}

		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		Condition newCondition(){
			return new ConditionObject();
		}
	}


	@Override
	public void lock() {
		sync.acquire(1);

	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);

	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}


	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}


	@Override
	public void unlock() {
		sync.tryRelease(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}
}
