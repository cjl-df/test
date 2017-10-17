package com.books.sf.chapter2.sort;

/**
 * Comparable
 */
public class Example {

    public static void sort(Comparable[] a){}

    public static boolean less(Comparable x,Comparable y){
        return x.compareTo(y)<0;
    }

    public static void exch(Comparable[]a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[]a){
        for (Comparable comparable : a) {
            System.out.print(comparable+"");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        //这是按照升序来测试是否有序
        for (int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Comparable[] a = {3,5,2,7,0,8};
//        Selection.sort(a);
//        Insertion.sort(a);
//        Shell.sort(a);
//        Merge.sort(a);
//        MergeBU.sort(a);
//        Quick.sort(a);
        MyQuick.sort(a);
        Example.show(a);
    }
}
