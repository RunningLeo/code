package com.cyf.code.designPatterns.Proxy;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:28 2019-08-12
 * @Desc ：
 */
public class TestClient {

	public static void main(String[] args) {

		TestProxy testProxy = new TestProxy();

		Test test = (Test) testProxy.newProxyInstance(new TestImpl());

		test.doTest();
	}
}
