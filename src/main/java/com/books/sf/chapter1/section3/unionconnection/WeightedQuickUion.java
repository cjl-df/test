package com.books.sf.chapter1.section3.unionconnection;

/**
 * 加权路径，优化连接算法
 */
public class WeightedQuickUion {

    private int ids[];
    private int size[];
    private int count;

    public WeightedQuickUion(int N){
        count = N;
        ids = new int[count];
        for(int i = 0;i < size.length; i++)
            ids[i] = i;
        size = new int[count];
        for(int i=0; i< size.length; i++ )
            size[i] = 1;
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while(p != ids[p]) p= ids[p];
        return p;
    }

    public boolean connect(int p,int q) {
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if( i == j ) return;
        if(size[i] < size[j]){
            ids[i] = j;
            size[i] += size[j];
        }else {
            ids[j] = i;
            size[j] += size[i];
        }
        count--;
    }
}
