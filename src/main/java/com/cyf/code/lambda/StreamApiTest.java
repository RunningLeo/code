package com.cyf.code.lambda;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:27 2019-11-20
 * @Desc ：
 */
@Slf4j
public class StreamApiTest {

	public static void main(String[] args) {

		List<String> list = Lists.newArrayList("2","5","8","10");

		list.stream().mapToInt(Integer::valueOf).boxed();


		IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::valueOf));
		double ave = summaryStatistics.getAverage();
		int max = summaryStatistics.getMax();

		log.info("===ave={},max={}",ave, max);

	}

	//流转换
}
