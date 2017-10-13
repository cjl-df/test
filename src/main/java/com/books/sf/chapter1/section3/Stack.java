package com.books.sf.chapter1.section3;

public interface Stack<Item> extends Iterable<Item>{

    abstract void push(Item item);

    abstract Item pop();

    abstract boolean isEmpty();

    abstract int size();
}
