package com.books.sf.chapter2.sort;

public class MasSort {

    public static void sort(Comparable[]a){
        int N = a.length-1;
        for(int k = N/2; k>=1;k--){    //初始化堆
            sink(a,k,N);
        }
        while(N>1){
            Example.exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private static void sink(Comparable[] a, int k, int N){
        while(k*2 <= N){
            int j= 2*k;
            if(j < N && Example.less(a[j],a[j+1])) j++;
            if(Example.less(a[j],a[k])) break;
            Example.exch(a,k,j);
            k=j;
        }
    }
}
