package com.tools;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 获取一个区间的随机整数
 * 1.使用hashset 是因为里面不能存放重复的元素
 * 2.hashSet如果知道set集合的大小，那么最好初始化的时候就指定，这样会避免系统指定大小浪费空间。
 */
public class RandomInts {
    private static Random random = new Random();

    public static void main(String[] args) {
        Set set = getRandomInts(5,35,5);
        Iterator t = set.iterator();
        while(t.hasNext()){
            System.out.println(t.next());
        }
    }

    /**
     * 获取在闭区间[min,max]的随机数
     * 如果是开区间[min,max) random.nextInt(max-min)+min;
     */
    public static int getRandom(int max,int min){
        return random.nextInt(Math.abs(max-min)+1) + Math.min(max,min);
    }

    /**
     * 获取指定数目的不重复的随机数
     */
    public static Set<Integer> getRandomInts(int n){
        Set<Integer> set = new HashSet<Integer>(n);
        while (set.size()!=n ){
            set.add(random.nextInt());
        }
        return set;
    }

    /**
     * 获取指定数目的不重复的在一个范围的随机数
     */
    public static Set<Integer> getRandomInts(int n,int max,int min){
        Set<Integer> set = new HashSet<Integer>(n);
        while(set.size() != n){
            set.add(getRandom(max,min));
        }
        return set;
    }
}
