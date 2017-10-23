package com.tools.random;

import java.util.Random;

/**
 * 先生成一个带选数组的集合，随机一个下标，然后将这个随机到的数去除，
 * 接着随机。
 */
public class RandomArray{
    private int[] source;
    private Random random;

    public RandomArray(){
        random = new Random();
    }

    public int[] getRes(int n,int max,int min){
        if(max < min || n > (max -min) +1)
            return null;
        init(max,min);
        int len = max - min + 1;
        int[] res = new int[n];       //存放结果
        for(int i =0; i< n ;i++){
            int j = Math.abs(random.nextInt()%(len - i));
            res[i] = source[j];
            source[j] = source[len-i-1];
        }
        return res;
    }

    /**
     * 初始化source数组，[min...max]
     */
    private void init(int max,int min){
        int len = max-min+1;
        source = new int[ len ];
        for(int i= 0 ; i< len; i++)
            source[i] = min+i;
    }

    public static void main(String[] args) {
        int [] a = new RandomArray().getRes(5,10,3);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
