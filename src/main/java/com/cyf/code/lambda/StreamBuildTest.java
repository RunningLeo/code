package com.cyf.code.lambda;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:49 2019-11-20
 * @Desc ：
 */
public class StreamBuildTest {


	public Stream build1(int [] source){
		return Stream.of(source);
	}

	public IntStream build2(int [] source){
		return Arrays.stream(source);
	}

	public static void main(String[] args) {

		int [] source = new int[]{3,2,6,7};

		IntStream stream1 = IntStream.of(source);

		int sum = stream1.reduce(-1, (a,b) -> a + b);
		System.out.println("====sum1="+sum);

		IntStream stream2 = Arrays.stream(source);

		//前闭后开
		IntStream stream3 = Arrays.stream(source, 0, 2);

		//创建一个空的
		Stream empty = Stream.empty();

		Stream echos = Stream.generate(() -> "echos");
		Stream random = Stream.generate(Math::random);

		Supplier<StreamBuildTest> supplier = StreamBuildTest::new;
		//调用get会执行构造方法
		supplier.get();


		//无限的stream
		Stream<BigInteger> stream4 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));


		//stream 调用close时，底层的文件也会被关闭，最好使用try-with-resources, 这样正常结束或者异常都会关闭
		Path path = Paths.get("/Users/leo/Desktop");
		try(Stream<String> line = Files.lines(path)){
			line.forEach(System.out::println);
		}catch (IOException io){

		}
	}
}
