package com.books.sf.chapter2.sort;

/**
 * 对于重复较多的数据，该算法效率更高
 */
public class Quick3Way {

    public static void sort(Comparable[]a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, i = lo +1,gt = hi;
        while(i<=gt){
            if (Example.less(a[i],a[lo]))
                Example.exch(a,lo++,i++);
            else if (Example.less(a[lo],a[i]))
                Example.exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void sort(Comparable[]a){
        sort(a,0,a.length-1);
    }
}
