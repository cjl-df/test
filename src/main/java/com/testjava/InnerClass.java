package com.testjava;

/**
 * 普通内部类属于外部类对象的一部分，就和其他变量一样
 * 所以外部类对象，对于该对象创建的所有内部类对象，都共享该外部类对象。
 */

public class InnerClass {
    int i =10;

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

        ic.changeI();
        ic.outI();

        inner.addI();
        inner.outInerI();

        Inner inner1 = ic.getInner();
        inner1.addI();

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
    }
}
