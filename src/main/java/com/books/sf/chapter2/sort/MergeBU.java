package com.books.sf.chapter2.sort;

/**
 * 自底向上的归并排需
 */
public class MergeBU {

    private static Comparable[] aux;

    public static void sort(Comparable[]a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N -sz; lo += sz+ sz) {
                merge(a,lo,lo+sz -1,Math.min(lo +sz +sz-1,N-1));
            }
        }
    }

    public static void merge(Comparable[]a,int lo,int mid, int hi){
        // 将a[lo .. mid] 和a[mid+1..hi]归并
        int i = lo;
        int j = mid+1;
        for(int k = lo; k<=hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if(i>mid) a[k] = aux[j++];    //说明a[lo..mid]已经都排进去了
            else if( j> hi) a[k] = aux[i++];
            else if( Example.less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
