package com.books.sf.chapter4;

import com.books.sf.chapter1.section3.bag.Bag;

import java.util.Iterator;
import java.util.Scanner;

public class Graph {

    private final int V; //顶点数
    private int E;       //边的数目
    private Bag<Integer>[] adj;    //连接表
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v <  V; v++) {
             adj[v] = new Bag<Integer>();
        }
    }

    public Graph(Scanner scanner){
        this(scanner.nextInt());
        int E = scanner.nextInt();
        for(int i = 0 ;i < E ; i++ ){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){ return V;}

    public int E(){ return E;}

    public Iterable<Integer> adj(int v){
        return adj[v];
    }


}
