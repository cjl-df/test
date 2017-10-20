package com.books.sf.chapter3;

/**
 * 基于二叉树的符号表
 */
public class BST<Key extends Comparable<Key>,Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;      //以该节点为根的子树中的节点数

        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }


}
