package com.cyf.code.lambda;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:31 2019-11-26
 * @Desc ：
 */
@FunctionalInterface
public interface CarAgeCheck<T> {

	boolean test(T t);
}
