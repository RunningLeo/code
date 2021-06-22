package com.cyf.code.jdk8.date;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/10/16 上午11:08
 */
public class LocalDateTest {


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020,2,29);

        //返回一个新的copy对象，如果改了年之后，天数在那个月不合法，则将天数改成那个月的最后一个合法值
        LocalDate date1 = localDate.withYear(2019);

        System.out.println(date1.toString());

        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);

        System.out.println("===>"+year+"===>"+year1);

    }
}
