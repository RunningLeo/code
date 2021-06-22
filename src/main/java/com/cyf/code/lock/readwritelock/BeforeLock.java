package com.cyf.code.lock.readwritelock;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:20 2020-01-11
 * @Desc ： 没有读写锁的情况， 读写都没有锁，不能保证写的原子性
 */
@Slf4j
public class BeforeLock {

	public static void main(String[] args) {

		MyCache myCache = new MyCache();

		for (int i = 0; i < 5; i++) {
			final int temp = i;
			new Thread(() -> {
				myCache.put(temp + "", temp + "");
			}, temp + "").start();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}


		for (int i = 0; i < 5; i++) {
			final int temp = i;
			new Thread(() -> {
				myCache.get(temp + "");
			}, temp + "").start();
		}

	}


}

@Slf4j
class MyCache {


	private Map<String, String> cache = Maps.newHashMap();

	public void put(String key, String value) {
		Thread thread = Thread.currentThread();
		log.info("===={},开始存数据, key={}", thread.getName(), key);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

		}
		cache.put(key, value);
		log.info("===={},存储完成", thread.getName());
	}


	public void get(String key) {
		Thread thread = Thread.currentThread();
		log.info("===={},开始取数据, key={}", thread.getName(), key);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

		}
		String result = cache.get(key);
		log.info("===={},取完成:{}", thread.getName(), result);
	}


	/**运行结果
	 * /Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/lib/tools.jar:/Users/leo/work/code/target/classes:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.1.6.RELEASE/spring-boot-starter-web-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-starter/2.1.6.RELEASE/spring-boot-starter-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot/2.1.6.RELEASE/spring-boot-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.1.6.RELEASE/spring-boot-autoconfigure-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.1.6.RELEASE/spring-boot-starter-logging-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/leo/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/leo/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.11.2/log4j-to-slf4j-2.11.2.jar:/Users/leo/.m2/repository/org/apache/logging/log4j/log4j-api/2.11.2/log4j-api-2.11.2.jar:/Users/leo/.m2/repository/org/slf4j/jul-to-slf4j/1.7.26/jul-to-slf4j-1.7.26.jar:/Users/leo/.m2/repository/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar:/Users/leo/.m2/repository/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.1.6.RELEASE/spring-boot-starter-json-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9/jackson-databind-2.9.9.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.9/jackson-datatype-jdk8-2.9.9.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar:/Users/leo/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.9.9/jackson-module-parameter-names-2.9.9.jar:/Users/leo/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.1.6.RELEASE/spring-boot-starter-tomcat-2.1.6.RELEASE.jar:/Users/leo/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.21/tomcat-embed-core-9.0.21.jar:/Users/leo/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.21/tomcat-embed-el-9.0.21.jar:/Users/leo/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.21/tomcat-embed-websocket-9.0.21.jar:/Users/leo/.m2/repository/org/hibernate/validator/hibernate-validator/6.0.17.Final/hibernate-validator-6.0.17.Final.jar:/Users/leo/.m2/repository/javax/validation/validation-api/2.0.1.Final/validation-api-2.0.1.Final.jar:/Users/leo/.m2/repository/org/jboss/logging/jboss-logging/3.3.2.Final/jboss-logging-3.3.2.Final.jar:/Users/leo/.m2/repository/com/fasterxml/classmate/1.4.0/classmate-1.4.0.jar:/Users/leo/.m2/repository/org/springframework/spring-web/5.1.8.RELEASE/spring-web-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-beans/5.1.8.RELEASE/spring-beans-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-webmvc/5.1.8.RELEASE/spring-webmvc-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-aop/5.1.8.RELEASE/spring-aop-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-context/5.1.8.RELEASE/spring-context-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-expression/5.1.8.RELEASE/spring-expression-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar:/Users/leo/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/Users/leo/.m2/repository/org/hamcrest/hamcrest-library/1.3/hamcrest-library-1.3.jar:/Users/leo/.m2/repository/org/springframework/spring-core/5.1.8.RELEASE/spring-core-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/org/springframework/spring-jcl/5.1.8.RELEASE/spring-jcl-5.1.8.RELEASE.jar:/Users/leo/.m2/repository/com/google/guava/guava/28.0-jre/guava-28.0-jre.jar:/Users/leo/.m2/repository/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar:/Users/leo/.m2/repository/com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:/Users/leo/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar:/Users/leo/.m2/repository/org/checkerframework/checker-qual/2.8.1/checker-qual-2.8.1.jar:/Users/leo/.m2/repository/com/google/errorprone/error_prone_annotations/2.3.2/error_prone_annotations-2.3.2.jar:/Users/leo/.m2/repository/com/google/j2objc/j2objc-annotations/1.3/j2objc-annotations-1.3.jar:/Users/leo/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.17/animal-sniffer-annotations-1.17.jar:/Users/leo/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar:/Users/leo/.m2/repository/org/jmock/jmock-junit4/2.5.1/jmock-junit4-2.5.1.jar:/Users/leo/.m2/repository/org/jmock/jmock/2.5.1/jmock-2.5.1.jar:/Users/leo/.m2/repository/org/openjdk/jol/jol-core/0.9/jol-core-0.9.jar com.cyf.code.lock.readwritelock.BeforeLock
	 * 11:53:34.936 [1] INFO com.cyf.code.lock.readwritelock.MyCache - ====1,开始存数据, key=1
	 * 11:53:34.936 [3] INFO com.cyf.code.lock.readwritelock.MyCache - ====3,开始存数据, key=3
	 * 11:53:34.936 [2] INFO com.cyf.code.lock.readwritelock.MyCache - ====2,开始存数据, key=2
	 * 11:53:34.936 [0] INFO com.cyf.code.lock.readwritelock.MyCache - ====0,开始存数据, key=0
	 * 11:53:34.936 [4] INFO com.cyf.code.lock.readwritelock.MyCache - ====4,开始存数据, key=4
	 * 11:53:35.244 [1] INFO com.cyf.code.lock.readwritelock.MyCache - ====1,存储完成
	 * 11:53:35.244 [3] INFO com.cyf.code.lock.readwritelock.MyCache - ====3,存储完成
	 * 11:53:35.245 [0] INFO com.cyf.code.lock.readwritelock.MyCache - ====0,存储完成
	 * 11:53:35.245 [4] INFO com.cyf.code.lock.readwritelock.MyCache - ====4,存储完成
	 * 11:53:35.244 [2] INFO com.cyf.code.lock.readwritelock.MyCache - ====2,存储完成
	 * 11:53:36.936 [0] INFO com.cyf.code.lock.readwritelock.MyCache - ====0,开始取数据, key=0
	 * 11:53:36.937 [2] INFO com.cyf.code.lock.readwritelock.MyCache - ====2,开始取数据, key=2
	 * 11:53:36.937 [3] INFO com.cyf.code.lock.readwritelock.MyCache - ====3,开始取数据, key=3
	 * 11:53:36.937 [4] INFO com.cyf.code.lock.readwritelock.MyCache - ====4,开始取数据, key=4
	 * 11:53:36.936 [1] INFO com.cyf.code.lock.readwritelock.MyCache - ====1,开始取数据, key=1
	 * 11:53:37.238 [3] INFO com.cyf.code.lock.readwritelock.MyCache - ====3,取完成:null
	 * 11:53:37.239 [0] INFO com.cyf.code.lock.readwritelock.MyCache - ====0,取完成:0
	 * 11:53:37.239 [1] INFO com.cyf.code.lock.readwritelock.MyCache - ====1,取完成:1
	 * 11:53:37.239 [4] INFO com.cyf.code.lock.readwritelock.MyCache - ====4,取完成:4
	 * 11:53:37.238 [2] INFO com.cyf.code.lock.readwritelock.MyCache - ====2,取完成:null
	 */
}
