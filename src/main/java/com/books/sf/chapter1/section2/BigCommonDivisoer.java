package com.books.sf.chapter1.section2;

/**
 * 用来计算最大公约数
 */
public class BigCommonDivisoer {

    public static int gcd(int p,int q){
        if(q==0)
            return q;
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(0,780));
    }
}
