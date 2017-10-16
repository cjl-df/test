package com.books.sf.chapter2;

import javax.crypto.spec.DESedeKeySpec;

public class DefineCompareData implements Comparable<DefineCompareData>{

    private final int day;
    private final int month;
    private final int year;

    public DefineCompareData(int d, int m ,int y){
        day = d;
        month = m;
        year = y;
    }

    public int day(){
        return day;
    }

    public int month(){
        return month;
    }

    public int year(){
        return year;
    }

    public int compareTo(DefineCompareData o) {
        if(this.year > o.year ) return +1;
        if(this.year < o.year) return -1;
        if(this.month > o.month) return +1;
        if(this.month < o.month) return -1;
        if(this.day > o.day) return +1;
        if(this.day < o.day ) return -1;
        return 0;
    }

    public String toString(){
        return this.year+"/"+this.month+"/"+this.day;
    }
}
