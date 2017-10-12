package com.books.sf.chapter1;

/**
 * 二分查找算法
 */
public class BinarySearch {
    public static int rank(int key,int[]a){
        //数组必须是有序的
        int i = 0,j = a.length-1;
        while(i<=j){
            int tmp = i+(j-i)/2;
            if(key < a[tmp])
                j=tmp - 1;
            else if(key > a[tmp])
                i = tmp + 1;
            else
                return tmp;
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] a = new int[15];
        for (int i = 0; i< a.length; i++)
            a[i]=i;
        for (int i:a) {
            System.out.println(i);
        }
        System.out.println(rank(5,whiteList)+"");
    }
}
