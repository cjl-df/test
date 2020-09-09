package com.books.sf.chapter1.section3.linker;

/**
 * 单向链表，倒置
 * 1,正常倒置
 * 2.递归倒置  还是不太明白
 */

public class LinkerInterfaceImpl implements LinerInterface {

    public Node reverse(Node x) {   //反转链表
        Node first = x;
        Node reverse = null;
        while(first!=null){
            Node second = first.node;
            first.node=reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node reverseDG(Node first){
        if(first == null)
            return null;
        if(first.node == null) return first;
        Node second = first.node;
        Node rest = reverseDG(second);
        second.node = first;
        first.node = null;
        return rest;
    }
}
