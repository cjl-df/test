package com.books.sf.chapter1.section3.stack;

import java.util.Iterator;

/**
 * 这是链表实现栈
 */
public class LinkerStack<Item> implements Iterable<Item> {

    private Node first;   //栈顶元素
    private int N; //数量
    private class Node{
        Item item;
        Node node;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.node = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.node;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private class LinerStackIterator<Item> implements Iterator<Item>{

        public boolean hasNext() {
            return false;
        }

        public Item next() {
            return null;
        }
    }
}
