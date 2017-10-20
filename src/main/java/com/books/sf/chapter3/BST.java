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

    /**
     * 获取大小
     */
    public int size(){
        return size(root);
    }
    private int size(Node node){
        if(node == null) return 0;
        else return node.N;
    }

    /**
     * 查找遍历
     */
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node node,Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp< 0) return get(node.left,key);
        else if(cmp > 0) return get(node.right,key);
        else return node.value;
    }

    /**
     * 插入
     */
    public void put(Key key,Value value){
        root = put(root,key,value);
    }
    private Node put(Node node,Key key, Value value){
        if(node == null) return new Node(key,value,1);
        int cmp = key.compareTo(node.key);
        if(cmp<0) node.left = put(node.left,key,value);
        else if(cmp > 0) node.right = put(node.right,key,value);
        else node.value = value;
        node.N = size(node.left)+ size(node.right) +1;
        return node;
    }

    /**
     * 最小的
     */
    public Key min(){
        return min(root);
    }
    private Key min(Node node){
        if(node.left == null) return node.key;
        return min(node.left);
    }

    /**
     * 小于目标key的最大Key
     */
    public Key floor(Key key){
        Node x = floor(root,key);
        if( x== null) return null;
        else return x.key;
    }
    private Node floor(Node node,Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp < 0) return floor(node.left,key);
        Node t = floor(node.right,key);
        if(t!=null) return t;
        else return node;
    }

    /**
     * 返回排名为k的key
     */
    public Key select(int k){

    }
    private Node select(Node node, int k){
        if()
    }
}
