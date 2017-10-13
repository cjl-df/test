package com.books.sf.chapter1.section3;

public interface Queue<Item> extends Iterable<Item>{

    abstract void enQueue(Item item);

    abstract Item deQueue(Item item);

    abstract boolean isEmpty();

    abstract int size();

}
