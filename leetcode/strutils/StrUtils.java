package leetcode.strutils;

import java.util.List;
import java.util.ArrayList;

public class StrUtils {
    //反转单词顺序
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer("");
        StringBuffer temp  = new StringBuffer("");
        char[] c = s.toCharArray();
        for(int i = c.length-1;i>=0;i--){
            if(c[i]!= ' '){
                temp.insert(0, c[i]);
            }else{
                if(temp.length()>0){
                    sb.append(" ");
                    sb.append(temp);
                    temp.setLength(0);
                }
            }
        }
        if(temp.length()>0) {sb.append(" ");sb.append(temp);}
        sb.delete(0,1);
        return sb.toString();
    }

    //字符串转换成ip地址
    public List<String> restoreIpAddresses(String s) {
        CharSequence c = s.subSequence(0, s.length());
        List<String> res = new ArrayList<>();
        _restoreIpAddresses(c,0,new int[4],0,res);
        return res;
    }

    public void _restoreIpAddresses(CharSequence c,int start,int[] sb,int count,List<String> res) {
        if(count == 3){
            if(start>c.length()-1 || c.length()-start>3) return;
            if(start<c.length()-1 && c.charAt(start) == '0') return;
            int x = Integer.parseInt(c, start, c.length(),10);
            if(x<=255 ){
                sb[count] = x;
                res.add(_intArrayToString(sb));
            }
            return;
        }
        int x= 0;
        for(int i = start ;i<c.length() && i<start+3;i++){
            x = x*10 + Integer.parseInt(c,i,i+1,10) ;
            if(x<=255){
                sb[count] = x;
                _restoreIpAddresses(c,i+1,sb,count+1,res);
            }
            if(x==0) return;
        }
    }

    public String _intArrayToString(int[] t){
        StringBuffer sb = new StringBuffer();
        sb.append(t[0]);
        for(int i = 1;i<t.length;i++){
            sb.append(".").append(t[i]);
        }
        return sb.toString();
    }
}