package com.books.sf.chapter1.section3.stack;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * 1.能够动态调整大小
 * 2.可以迭代
 * 3.具有范型
 * 4.数组实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    private Item[] a = (Item[]) new Object[1];
    private int N =0;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void resize(int max){         //没有判断是否越界
        Item[] tmp = (Item[])new Object[max];
        for(int i=0;i< N;i++)
            tmp[i] = a[i];
        a= tmp;
    }

    public void push(Item item){
        if(N == a.length)    //已经超过大小
            resize(2*a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;  //避免内存泄漏
        if(N>0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return i> 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove(){}
    }

}
