package com.testjava;

/**
 * 一些面试中见到的基本问题
 */
public class STest {
    int i =9;

    public static void main(String[] args) {
        /**
         * 1.null是什么那，它是一个对象，这个对象为null
         * 2.String str; str="hello"; //null就和hello室等价的。
         */
        System.out.println(null == null);

        /**
         *  1.modifyStr()这个函数接受的参数，是字符串常量,相当于基本数据类型int.
         *  2.modifyInt()这个函数接受的参数，是一个对象，或者说一个对象的地址，
         *    如果(这个对象)st.i,自然就是修改的st里面的属性。
         *  3,综上所述，java都是指传参，不存在引用传递
         */
        String str = "hello";
        modifyStr(str);
        System.out.println(str);
        System.out.println("===============");
        String ss = new String("hello");
        modifyStr(ss);
        System.out.println(ss);
        System.out.println("===============");
        STest st= new STest();
        modifyInt(st);
        System.out.println(st.i);
    }

    private static void modifyStr(String str){
//        String str = "sd";
        str += " world";
        System.out.println(str+"---");
    }
    private static void modifyInt(STest st){
        st.i++;
        System.out.println(st.i);
    }
}
