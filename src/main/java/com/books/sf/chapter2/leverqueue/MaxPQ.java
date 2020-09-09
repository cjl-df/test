package com.books.sf.chapter2.leverqueue;

import com.books.sf.chapter2.sort.Example;

/**
 * 优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] a;
    private int N =0;  //存储 1....N

    public MaxPQ() {       // 创建一个优先队列
    }

    public MaxPQ(int max){   //创建一个最大为max的优先队列
        a = (Key[])new Comparable[max+1];
    }

    public MaxPQ(Key[]a){}     //

    void insert(Key key){
        if(N+1 == a.length) resize(a.length*2);
        a[++N] = key;
        swim(N);
    }

    Key delMax(){
        Key key = a[1];
        a[1] = a[N--];
        a[N+1] = null;
        sink(1);
        if(N <= (a.length-1)/4) resize((a.length-1)/2);
        return key;
    }

    private void resize(int t){
        Key[] tmp = (Key[])new Comparable[t];
        for (int i = 0; i <= N; i++) {
            tmp[i] = a[i];
        }
        a=tmp;
    }

    boolean isEmpty(){ return N==0 ; }

    int size(){ return N;}

    private void swim(int k){
        while(k>1 && Example.less(a[k/2],a[k])){
            Example.exch(a,k,k/2);
            k= k/2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && Example.less(a[j],a[j+1])) j++;     //字节点中最大的元素
            if(Example.less(a[j],a[k])) break;
            Example.exch(a,k,j);
            k=j;
        }
    }
}

