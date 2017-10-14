package com.books.sf.chapter1.section3.linker;

public interface LinerInterface {

    abstract Node reverse(Node node);

    class Node<Item>{
        Item item;
        Node node;
    }
}
