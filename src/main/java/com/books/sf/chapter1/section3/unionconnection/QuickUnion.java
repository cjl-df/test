package com.books.sf.chapter1.section3.unionconnection;

/**
 * 这个是快速连接的方法
 */
public class QuickUnion {

    private int[] id;
    private int count;

    public void UF(int N){
        //初始化id数组
        count = N;
        id = new int[N];
        for (int i =0;i< N; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    private int find(int p){
        while(p!= id[p])
            p = id[p];
        return p;
    }

    public void union(int p,int q){
        int proot = find(p);
        int qroot = find(q);
        if(proot == qroot) return;
        id[proot] = qroot;
        count--;
    }
}
