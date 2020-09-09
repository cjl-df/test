package com.books.sf.chapter1.section3.bag;

import java.util.Iterator;

public class Bag<Item>  implements Iterable<Item>{

    private Node first;
    private class Node{
        Item item;
        Node node;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.node = oldFirst;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private  class ListIterator<Item> implements Iterator<Item>{
        Node current = first;

        public boolean hasNext() {
            return first != null;
        }

        public Item next(){
            Item item = (Item) current.item;
            current = current.node;
            return item;
        }

        public void remove(){}
    }
}
