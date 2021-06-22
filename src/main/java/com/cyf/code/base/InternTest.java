package com.cyf.code.base;

/**
 * @desc: String.intern()探究
 * @Author: caoyafei
 * @Date: 2020/7/27 下午3:34
 */
public class InternTest {

    /**
     * intern 方法
     /**
     * Returns a canonical representation for the string object.
     * <p>
     * A pool of strings, initially empty, is maintained privately by the
     * class {@code String}.
     * <p>
     * When the intern method is invoked, if the pool already contains a
     * string equal to this {@code String} object as determined by
     * the {@link #equals(Object)} method, then the string from the pool is
     * returned. Otherwise, this {@code String} object is added to the
     * pool and a reference to this {@code String} object is returned.
     * <p>
     * It follows that for any two strings {@code s} and {@code t},
     * {@code s.intern() == t.intern()} is {@code true}
     * if and only if {@code s.equals(t)} is {@code true}.
     * <p>
     * All literal strings and string-valued constant expressions are
     * interned. String literals are defined in section 3.10.5 of the
     * <cite>The Java&trade; Language Specification</cite>.
     *
     * @return  a string that has the same contents as this string, but is
     *          guaranteed to be from a pool of unique strings.
     */


    /**
     * 大体上说，intern这个方法主要是 提高字符串的复用率，主要应用于new出来的字符串上，因为常量池的字符串已经在池子里了
     * String a = new String("123")
     * jdk1.6的时候，常量池在方法去，执行intern这个方法，如果常量池里没有，则先在常量池生成字符串，然后返回常量池的字符串引用，如果已经有了，直接返回常量池的引用
     * jdk1.7开始，因为常量池被放到了堆里，执行intern这个方法，如果常量池里没有，则将堆里的引用放到常量池中，如果常量池有了，则返回池子里的引用
     * @param args
     */


    public static void main(String[] args) {

        //【1】jdk1.8, 下面执行是true, s3.intern()执行后常量池中已经包含了堆的常量引用，s4指向了s3的引用
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        //【2】jdk1.8, 下面执行是false, 因为  String s4 = "11" 先于 s3.intern()执行，这样 s3和s4 是不同的引用
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);
//
//        //如果改成下面的，则为true
//        s3 = s3.intern();
//        System.out.println(s3 == s4);

        //【3】 str1 = "SEUCalvin", str1.intern()将字符串常量池的对象指向了str1
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);// true
        System.out.println(str1 == "SEUCalvin");// true

    }
}
