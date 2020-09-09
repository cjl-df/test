package com.books.sf.chapter2.sort;

/**
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[]a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h +1;
        while(h>=1){
            //讲数组变为h有序
            for (int i = h; i < N; i++) {  //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...
                for (int j = i; j >=h && Example.less(a[j],a[j-h]); j -=h ) {
                    Example.exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
}

