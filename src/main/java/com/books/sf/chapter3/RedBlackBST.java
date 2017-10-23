package com.books.sf.chapter3;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left,right;
        int N;
        boolean color;

        Node(Key key,Value value,int N,boolean color){
            this.key = key;
            this.val = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size(){ return 0;}

    private int size(Node node){ return 0;}
}
