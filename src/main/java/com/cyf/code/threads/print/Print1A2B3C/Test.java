package com.cyf.code.threads.print.Print1A2B3C;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author ：caoyafei
 * @Date ：Created in 20:38 2019-12-24
 * @Desc ：
 */
public class Test extends WeakReference<ThreadLocal<?>> {

	String value;
	/**
	 * Creates a new weak reference that refers to the given object.  The new
	 * reference is not registered with any queue.
	 *
	 * @param referent object the new weak reference will refer to
	 */
	public Test(ThreadLocal<?> referent, String value) {
		super(referent);
		this.value = value;
	}
}
