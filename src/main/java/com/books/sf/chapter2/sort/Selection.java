package com.books.sf.chapter2.sort;

/**
 * 选择排序
 * --从无需去选择一个最小的放到有序去
 */

public class Selection {

    public static void sort(Comparable[]a){
        for (int i = 0; i < a.length-1; i++) {
            int min =i;
            for(int j =i+1; j <a.length;j++){
                if(Example.less(a[j],a[min])) min = j;
            }
            Example.exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {3,5,2,7,0,8};
        sort(a);
        Example.show(a);
    }
}
