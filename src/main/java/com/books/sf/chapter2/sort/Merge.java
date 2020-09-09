package com.books.sf.chapter2.sort;

/**
 * 自上而下的归并排序
 */
public class Merge {

    private static Comparable[] aux;

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

    public static void sort(Comparable[]a,int lo,int hi){
        if( lo >= hi) return;
        int mid = (lo + hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void sort(Comparable[]a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
}
