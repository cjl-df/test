package com.books.sf.chapter3;

import java.util.Iterator;

/**
 * 无序符号表
 * 以向下压栈的方式构造链表无符号链表
 */
public class SequentialSearchST<Key,Value> implements Iterable<Key>{
    private Node first;
    private int N = 0;

    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x!= null;x = x.next){
            if(key.equals(x.key))
                return x.value;   //命中
        }
        return null;
    }

    public void put(Key key,Value value){
        for(Node x = first; x!=null ; x = x.next){
            if(key.equals(x.key)){  //命中 更新
                x.value = value;
                return;
            }
        }
        N++;
        first = new Node(key,value,first);
    }

    public int size(){
        return N;
    }

    public void delete(Key key){
        if(key.equals(first.key))
            first = first.next;
        for(Node x = first; x.next!=null; x= x.next){
            if(key.equals(x.next.key)){
                x.next = x.next.next;
                return;
            }
        }
    }

    public void keys(){

    }

    public Iterator<Key> iterator() {
        return new KeyItar();
    }

    private class KeyItar implements Iterator{
        Node current = first;
        public boolean hasNext() {
            return current==null;
        }

        public Object next() {
            Key key = current.key;
            current = current.next;
            return key;
        }

        public void remove() {
        }
    }
}
