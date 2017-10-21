package com.books.sf.chapter3;

import com.books.sf.chapter1.section3.queue.Queue;

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
     * 最小的,最大的
     */
    public Key min(){
        return min(root).key;
    }
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }
    public Key max(){return max(root).key;}
    private Node max(Node node){
        if(node.right == null) return node;
        return max(node.right);
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
        return select(root,k).key;
    }
    private Node select(Node node, int k){
        if( node == null) return null;
        int t = size(node.left);
        if( t> k ) return  select(node.left,k);
        else if(t < k) return select(node.right,k-t-1);
        else return node;
    }

    /**
     * 返回小于key的节点的数量
     */
    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node node,Key key){
        if(node== null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp <0) return rank(node.left,key);
        else if (cmp >0) return 1+size(node.left)+rank(node.left,key);
        else return size(node.left);
    }

    /**
     * 删除操作
     */
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node node){
        if(node.left == null ) return node.right;
        else node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node node,Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        //由于是往下遍历，不会往回退，所以即使cmp永远不等于0,也不会来回震荡
        if(cmp < 0) node.left = delete(node.left,key);
        if(cmp > 0) node.right = delete(node.right,key);
        else{
            if(node.right == null) return node.left;
            if(node.left == null ) return node.right;
            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left)+ size(node.right)+1;
        return node;
    }

    /**
     * 返回keys集合
     */
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi){
        if(node == null) return ;
        int comlo = lo.compareTo(node.key);
        int comhi = hi.compareTo(node.key);
        if(comhi< 0) keys(node.left, queue, lo ,hi);
        if(comhi<=0 && comhi >= 0) queue.enQueue(node.key);
        if(comhi >0 ) keys(node.right,queue,lo,hi);
    }

}
