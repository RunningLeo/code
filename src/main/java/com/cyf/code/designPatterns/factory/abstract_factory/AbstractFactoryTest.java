package com.cyf.code.designPatterns.factory.abstract_factory;

import com.cyf.code.designPatterns.factory.abstract_factory.product.AFruit;
import com.cyf.code.designPatterns.factory.abstract_factory.product.Food;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/10 上午11:21
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Factory factoryA = new AFactory();
        Factory factoryB = new BFactory();


        Food fruitA = factoryA.createFruit();
        Food cookieA = factoryA.createCookie();

        Food fruitB = factoryB.createFruit();
        Food cookieB = factoryB.createCookie();

        fruitA.printDetail();
        cookieA.printDetail();

        fruitB.printDetail();
        cookieB.printDetail();






    }
}
