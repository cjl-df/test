package com.testjava;

/**
 * 普通内部类属于外部类对象的一部分，就和其他变量一样
 * 所以外部类对象，对于该对象创建的所有内部类对象，都共享该外部类对象。
 */

public class InnerClass {
    int i =10;
    Test test = new Test();

    public void outI(){
        System.out.println(i);
    }

    public void changeI(){
        i--;
    }

    public Inner getInner(){
        return new Inner();
    }

    private class Inner{

        Test dd = test;

        public void addI(){
            i=i+10;
        }

        public void outInerI(){
            System.out.println(i);
        }

        /**
         * 内部类自己定义的变量，内部类的对象之是相互不知道的
         */
        String innerStr = "only Inner define";

        public void changeInnerStr(){
            innerStr = innerStr+",have bin changed!";
        }
    }

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        Inner inner = ic.getInner();
        Inner inner1 = ic.getInner();
        /**
         * 外部类的变量，对于内部类是共享的
         */
        ic.changeI();
        inner.addI();
        inner1.addI();
        ic.outI();
        inner1.outInerI();
        inner.outInerI();

        System.out.println("---------------");
        /**
         * 上面的说明普通内部类对象 共享外部类的对象
         * 下面说明外部类对象 不公想内部类对象
         * 下面的还说明 内部类的各个对象，不共享，并且不可见内部类内部自己定义的变量 比如
         */
        inner.changeInnerStr();
        System.out.println(inner.innerStr);
        System.out.println(inner1.innerStr);

        System.out.println("----------------");
        /**
         * 可以这样操作外部类对象，也可以直接用
         */
        ic.test.add();
        System.out.println(ic.test.j);
        System.out.println(inner.dd.j);
        System.out.println(inner1.dd.j);
    }
}


class Test{
    int j = 0;

    public void add(){
        j++;
    }
}