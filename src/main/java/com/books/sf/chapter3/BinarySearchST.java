package com.books.sf.chapter3;

import com.books.sf.chapter1.section3.queue.Queue;

/**
 * 二分查找数组实现map(有序表)
 */

public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key){
        int lo = 0,hi = N -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int tmp = key.compareTo(keys[mid]);
            if(tmp < 0) hi = mid-1;
            else if(tmp > 0) lo = mid+1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key,Value value){
        int i = rank(key);
        //查找键，查到更新，否则常见新的元素
        if(i<N && keys[i].compareTo(key) == 0){
            vals[i] = value;
            return;
        }
        if(N == keys.length)
            resize(N*2);
        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    //调整大小
    public void resize(int size){
        Key[] tkeys = (Key[]) new Comparable[size];
        Value[] tvals = (Value[]) new Object[size];
        for(int i=0;i<N;i++){
            tkeys[i] = keys[i];
            tvals[i] = vals[i];
        }
        keys = tkeys;
        vals = tvals;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void delete(Key key){
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) != 0) return;
        for(int j = i; j<N-1 ;j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        N--;
        if(N < vals.length/4);
            resize(vals.length/2);
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<Key>();
        for (int i = rank(lo); i <= rank(hi); i++) {
            queue.enQueue(keys[i]);
        }
        if(contains(hi))
            queue.enQueue(keys[rank(hi)]);
        return queue;
    }

    private boolean contains(Key key){
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0) return true;
        return false;
    }
}
