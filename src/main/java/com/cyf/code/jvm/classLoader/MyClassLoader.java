package com.cyf.code.jvm.classLoader;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:01 2019-09-04
 * @Desc ：自定义的classloader, 待加载类的路径要注意⚠️
 */
@Slf4j
public class MyClassLoader extends ClassLoader {

	/**
	 * Loads the class with the specified <a href="#name">binary name</a>.
	 * This method searches for classes in the same manner as the {@link
	 * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
	 * machine to resolve class references.  Invoking this method is equivalent
	 * to invoking {@link #loadClass(String, boolean) <tt>loadClass(name,
	 * false)</tt>}.
	 *
	 * @param name The <a href="#name">binary name</a> of the class
	 * @return The resulting <tt>Class</tt> object
	 * @throws ClassNotFoundException If the class was not found
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {

		try {
			String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

			final String property = System.getProperty("user.dir");
			System.out.println(property);

			Class<?> clazz = getClass();
	//		InputStream is0 = clazz.getResourceAsStream("EntryTest.class");
			InputStream is = getClass().getResourceAsStream(fileName);
	//		InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);


			if(is == null){
				log.info("=======1super loader");
				return super.loadClass(name);
			}

			byte [] b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);

		}catch (Exception e){
			throw new ClassNotFoundException(name);
		}
	}
}
