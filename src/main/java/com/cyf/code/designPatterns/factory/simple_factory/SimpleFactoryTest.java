package com.cyf.code.designPatterns.factory.simple_factory;

import com.cyf.code.designPatterns.factory.Fruit;

/**
 * @desc:
 * 简单工厂模式，
 * 优点：对外屏蔽了对象产生的细节，
 * 1、但是需要客户端知道每种类型对应的对象
 * 2、如果新增新的子类，需要在工厂类里增加代码，工厂类会有很多if-else、不符合开闭原则（对扩展开放，对修改关闭）
 *
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:19
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        Fruit fruit1 = FruitFactory.createFruit(1);

        Fruit fruit2 = FruitFactory.createFruit(2);

        fruit1.printDetail();

        fruit2.printDetail();

    }
}
