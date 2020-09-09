package com.books.sf.chapter1.section3.queue;

import java.util.Iterator;

/**
 * 队列的链表实现
 */
public class Queue<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node node;
    }

    public boolean isEmpty(){
        return first == null;  //或者N==0
    }

    public int size(){ return N; }

    public void enQueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) first = last;
        else oldlast.node = last;
        N++;
    }

    public Item deQueue(){
        //这儿是否需要判断是不是空对列
        Item item = first.item;
        first = first.node;
        if(isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() {
            return current !=null;
        }

        public Item next() {
            Item item = current.item;
            current = current.node;
            return item;
        }

        public void remove(){}
    }
}
