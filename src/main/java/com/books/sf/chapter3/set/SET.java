package com.books.sf.chapter3.set;

public interface SET<Key>{

    void add(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    String toString();
}
