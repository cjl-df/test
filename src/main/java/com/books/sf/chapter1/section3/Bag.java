package com.books.sf.chapter1.section3;

public interface Bag<Item> extends Iterable<Item>{

    abstract void add(Item item);

    abstract boolean isEmpty();

    abstract int size();
}
