package leetcode.bytepa;

import java.util.Stack;

public class ByteMath {
    //最小交换
    public int minimumSwap(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Stack<Character> st = new Stack<Character>();
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            if((a[i]^b[i]) == 1){
                if(st.empty()){
                    st.push(a[i]);
                }else{
                    if(st.peek() == a[i]) {
                        res+=1;
                        st.pop();
                    }else
                        st.push(a[i]);
                }
            }
        }
        int x = st.size();
        return x%2 == 0?  (x/4)*2 + (x%4) + res:-1;
    }
    
}