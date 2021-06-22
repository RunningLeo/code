package com.cyf.code.designPatterns.sington;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:43 2019-08-12
 * @Desc ：静态内部类的单例模式, 外部类加载的时候，内部类不会加载，只有在需要的时候才会加载
 */
public class StaticInnerClass {

	private StaticInnerClass (){

		if(InnerClass.INSTANCE != null){
			throw new RuntimeException("不允许多个实例");
		}
	}


	public static StaticInnerClass getInstanceMain(){
		return InnerClass.INSTANCE;
	}



	private static class InnerClass{

		private final static StaticInnerClass INSTANCE = new StaticInnerClass();

	}


	public static void main(String[] args) {
		StaticInnerClass inner1 = StaticInnerClass.getInstanceMain();
		StaticInnerClass inner2 = StaticInnerClass.getInstanceMain();
		System.out.println("=====inner1 hashcode="+inner1.hashCode());
		System.out.println("=====inner2 hashcode="+inner2.hashCode());
		System.out.println("=====inner1 == inner2 ? "+(inner1 == inner2));
	}
}
