package com.cyf.code.jvm;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:40 2019-09-04
 * @Desc ：子类接口初始化，父类接口未必初始化，只有到引用到父类接口的时候才会初始化
 */
public class InterfaceInit {

	interface Parent{

		int A = 1;

		Thread t1 = new Thread(){
			{
				System.out.println("======parent init");
			}
		};
	}

	interface Sub{
		int B = 2;
		Thread t2 = new Thread(){
			{
				System.out.println("======sub init");
			}
		};

	}


	public static void main(String[] args) {
		System.out.println("===="+Sub.t2);
		System.out.println("===="+Parent.A);

	}
}
