package com.cyf.code.designPatterns.factory.factory_method;

import com.cyf.code.designPatterns.factory.Fruit;

/**
 * @desc: 工厂方法模式
 * 优点：相比于简单工厂模式，新增子类不需要在工厂类中增加if-else逻辑，客户端也无需传递参数，想实例什么对象，只需调用对应的工厂子类即可
 * 缺点：1、需要新增工厂子类，如果子类过多，每个子类都要一个工厂
 * 2、一个工厂只能生产一种产品，不能生产别的产品，扩展性差
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:38
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        FruitFactory appleFactory = new AppleFactory();
        FruitFactory bananaFactory = new BananaFactory();

        Fruit fruit1 = appleFactory.createFruit();
        Fruit fruit2 = bananaFactory.createFruit();

        fruit1.printDetail();
        fruit2.printDetail();


    }
}
