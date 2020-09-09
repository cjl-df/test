package com.books.sf.chapter2.sort;

/**
 * 插入排序
 * --从无序曲选择一个插入到有序去
 */
public class Insertion {

    public static void sort(Comparable[]a){
        for (int i = 1; i < a.length; i++) {
            Comparable comparable = a[i];
            for (int j = i; j > 0; j--) {
                if(Example.less(a[j],a[j-1]))
                    Example.exch(a,j,j-1);
                else break;
            }
            System.out.println("---");
        }
    }
}
