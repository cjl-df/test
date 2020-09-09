package com.books.sf.chapter3.map.hash;

import com.books.sf.chapter3.map.SequentialSearchST;

public class SeparateChainHashST<Key, Value> {
    private int N; // 键值对总数
    private int M; // 三列表大小
    private SequentialSearchST<Key,Value>[] st;   //存放链表对象的数组

    public SeparateChainHashST(){
        this(997);       //最好为素数
    }

    public SeparateChainHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i =0; i< M ;i++)
            st[i] = new SequentialSearchST();
    }

    /**
     * 1.java的约定，每种数据类型都要实现散列函数，于是java令所有的数据类型都继承了一个能返回
     *   32位整数的hashcode()方法。
     * 2.下面的代码将32位正数变成31位非负整数，除余来计算下标
     */
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff ) % M;
    }

    public Value get(Key key){
        return (Value)(st[hash(key)].get(key));
    }

    public void put(Key key,Value value){
        st[hash(key)].put(key,value);
    }

    public Iterable<Key> keys(){
        return null;
    }
}
