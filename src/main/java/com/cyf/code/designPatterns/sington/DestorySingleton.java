package com.cyf.code.designPatterns.sington;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @author ：caoyafei
 * @Date ：Created in 20:46 2019-12-04
 * @Desc ：通过反射破坏单例模式
 */
@Slf4j
public class DestorySingleton {

	public static void main(String[] args) {

		try {
			Class<?> clazz = StaticInnerClass.class;

			Constructor [] constructors = clazz.getDeclaredConstructors();

			Constructor c = constructors[1];

			c.setAccessible(true);

			Object o1 = c.newInstance();

			Object o2 = c.newInstance();

			System.out.println("====o1=o2=" + (o1 == o2));

		} catch (Exception e) {
			log.info("=======exception=="+e.getCause());
		}


	}
}
