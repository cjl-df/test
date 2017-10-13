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
    }
}
