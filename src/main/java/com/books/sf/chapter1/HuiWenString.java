package com.books.sf.chapter1;

import junit.framework.TestCase;

/**
 * 检查一个字符串是不是回文
 */
public class HuiWenString extends TestCase{

    public static boolean testHuiWen(String s){
        int i =0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }

    public void test(){
        assertEquals(true,testHuiWen("sssggsss"));
        assertEquals(false,testHuiWen("dsfded"));
    }
}
