package com.books.sf.chapter2.sort;

/**
 * 快速排序
 */
public class Quick {

    public static void sort(Comparable[]a){
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[]a, int lo, int hi){
        if(lo>=hi)
            return;
        int persition = partition(a,lo,hi);
        sort(a,lo,persition-1);
        sort(a,persition+1,hi);
    }

    private static int partition(Comparable[] a, int lo ,int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        //要保证j指向最小的里面最大的一个
        while (true){
            while(Example.less(a[++i],v)) if(i == hi) break;
            while(Example.less(v,a[--j])) if(j == lo) break;
            if(i>=j)
                break;
            Example.exch(a,i,j);
        }
        Example.exch(a,lo , j );
        return j;
    }
}
