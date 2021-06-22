package com.cyf.code.jdk8.date;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @desc:
 * LocalDate、LocalTime、LocalDateTime、Instant为不可变对象，修改这些对象对象会返回一个副本
 * @Author: caoyafei
 * @Date: 2020/10/16 上午11:18
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2019,10,16);
        LocalTime localTime = LocalTime.of(12,8,16);


        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);

        System.out.println("===>"+localDateTime2);
        System.out.println("===>"+localDateTime3);
        System.out.println("===>"+localDateTime4);


        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalTime localTime2 = localDateTime.toLocalTime();

        System.out.println("===>"+localDate2);
        System.out.println("===>"+localTime2);

        System.out.println("==================================================");

        Instant instant = Instant.now();
        long currentSecond = instant.getEpochSecond();
        long currentMilli = instant.toEpochMilli();

        System.out.println("=====>"+currentMilli);
        System.out.println("=====>"+System.currentTimeMillis());


        LocalDate localDate3 = LocalDate.now();
        LocalDate localDate1 = localDate3.with(lastDayOfMonth());
        System.out.println("===>"+localDate1);


        System.out.println("==================================================");


        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);

        String s4 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String s5 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);


        System.out.println("=====>"+s1);
        System.out.println("=====>"+s2);
        System.out.println("=====>"+s3);
        System.out.println("=====>"+s4);
        System.out.println("=====>"+s5);


        System.out.println("==================================================");


        LocalDate localDate4 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate5 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDateTime localDate6 = LocalDateTime.parse("2019-09-10T10:12:51", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        LocalDateTime localDate7 = LocalDateTime.parse("2019-09-10 10:12:51", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("=====>"+localDate4);
        System.out.println("=====>"+localDate5);
        System.out.println("=====>"+localDate6);
        System.out.println("=====>"+localDate7);
    }
}
