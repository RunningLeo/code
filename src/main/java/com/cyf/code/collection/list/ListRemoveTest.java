package com.cyf.code.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @desc: List遍历时删除问题
 * @Author: caoyafei
 * @Date: 2020/8/18 下午5:17
 */
public class ListRemoveTest {

    /**
     *  错误删除1，结果打印1，2
     *  删除了2之后，modCount++,当进行下一次遍历时，modCount != expectCount, 抛出异常
     */
    public static void wrong1(){
        List<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);


        Iterator<Integer> iterator = users.iterator();
        while(iterator.hasNext()) {
            Integer data = iterator.next();
            if(data == 2) {
                users.remove(data);
            }
            System.out.println(data);
        }
    }

    /**
     *  错误删除2
     */
    public static void wrong2(){
        List<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);

        for (Integer data : users){
            if(data == 3){
                users.remove(data);
            }
            System.out.println(data);
        }
    }

    /**
     *  错误删除3
     *  结果不会报错，打印的结果是 1，2，3
     *  因为删除的是倒数第二个元素，foreach本质上也是iterator，
     *  在判断hasNext的时候，
     *          public boolean hasNext() {
     *             return cursor != size();
     *         }
     *  当删除了3之后，size -1 ,刚好 cursor == size，导致hasNext返回false, 最后一个元素被遗漏
     */
    public static void wrong3(){
        List<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);

        Iterator<Integer> iterator = users.iterator();
        while(iterator.hasNext()) {
            Integer data = iterator.next();
            if(data == 3){
                users.remove(data);
            }
            System.out.println(data);
        }
    }

    /**
     * 正确的遍历删除，用Iterator自己的remove,因为它在每一次remove之后，令expectCount = modCount，保证下次检查通过
     */
    public static void right(){
        List<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);

        Iterator<Integer> iterator = users.iterator();
        while(iterator.hasNext()) {
            Integer data = iterator.next();
            if(data == 3){
                iterator.remove();
            }
            System.out.println(data);
        }


        System.out.println("==remove======");

        for (Integer d : users){
            System.out.println(d);
        }

    }


    public static void main(String[] args) {

    //    wrong1();

        right();

    }
}
