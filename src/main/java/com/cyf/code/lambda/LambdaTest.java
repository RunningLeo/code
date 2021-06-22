package com.cyf.code.lambda;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:36 2019-11-25
 * @Desc ：
 */
public class LambdaTest {

	public static void main(String[] args) {

		int age = 18;
		//	age = 20; lambda引用的是值， jdk1.8之前，变量必须使用final修饰
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("===age=" + age);
			}
		});

		int i = 10;
		i = 20;
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4);

		int sum1 = list.stream().reduce(-1, Integer::sum);

		System.out.println("===sum1=" + sum1);

		Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
		System.out.println("======sum2=" + sum2.get());


		int sum3 = list.stream().reduce(-5, (result, e) -> result * 2 + e, Integer::sum);

		System.out.println("====sum3=" + sum3);
		/**
		 * local variables referenced from a Lambda expression must be final or effectively final
		 * lambda表达式中的i 不允许改变
		 */
		//	list.stream().filter(o -> o.equals(i)).forEach(System.out::println);


		testMultiReduce();

		test();

	}


	private static void testMultiReduce() {
		ArrayList<List<String>> strings = new ArrayList<>();
		strings.add(Arrays.asList("1", "2", "3", "4"));
		strings.add(Arrays.asList("2", "3", "4", "5"));
		strings.add(Arrays.asList("3", "4", "5", "6"));

		// 非并行流
		Integer reduce1 = strings.stream().flatMap(e -> e.stream()).reduce(0,
				(acc, e) -> acc + Integer.valueOf(e), (u, t) -> {
					// 非并行流，不会执行第三个参数
					System.out.println("u----:" + u);
					// 这里的返回值并没有影响返回结果
					return null;
				});
		System.out.println("reduce1:" + reduce1);

		// 并行流
		Integer reduce2 = strings.parallelStream().flatMap(e -> e.stream()).reduce(0,
				(acc, e) -> acc + Integer.valueOf(e), (u, t) -> {
					// u，t分别为并行流每个子任务的结果
					System.out.println("u----:" + u);
					System.out.println("t----:" + t);
					return u + t;
				});
		System.out.println("reduce2:" + reduce2);


		List<Integer> list = Lists.newArrayList(1,2,3,4,2,3,4,5,3,4,5,6);

		int sum1 = list.stream().reduce(0, Integer::sum, (u,t) -> {
			// 非并行流，不会执行第三个参数
			System.out.println("u----:" + u);
			// 这里的返回值并没有影响返回结果
			return null;
		});

		int sum2 = list.parallelStream().reduce(0, Integer::sum, (u, t) -> {
			// u，t分别为并行流每个子任务的结果
			System.out.println("u----:" + u);
			System.out.println("t----:" + t);
			return u + t;
		});

		System.out.println("====sum1="+sum1);
		System.out.println("====sum2="+sum2);

	}

	private static void test(){
		List<Integer> list = Lists.newArrayList(1,2,3,4,2,3,4,5,3,4,5,6);

	//	list.stream().sorted(Comparator.comparing().thenComparing().reversed());

		String ss = list.stream().collect(Collectors.reducing("", String::valueOf, (a, b) -> a + b + ","));

		System.out.println("====ss="+ss);

		list.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::valueOf)));


	}

}
