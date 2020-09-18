package leetcode.strutils;

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
}