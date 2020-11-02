
package leetcode;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import leetcode.strutils.*;
import leetcode.permutation.*;
import leetcode.array.LinearArray;
import leetcode.array.Util;
import leetcode.bytepa.ByteMath;
import leetcode.array.Matrix;
import leetcode.array.Util;
import java.util.Set;
import java.util.Stack;
import leetcode.tree.twobranchtree.searchtree.*;
import leetcode.tree.twobranchtree.TreeHandler;
import leetcode.tree.twobranchtree.TreeNode;
import leetcode.link.singleway.*;

public class Test{ 
    public static void main(String[] args) {
        SingleWayLink singleWayLink = new SingleWayLink(new int[]{1,2,3,4,5});
        int x =  singleWayLink.kthToLast(singleWayLink.root, 2);
        System.out.println(x);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {

    public ListNode getNode(){
        int [] t = new int[]{};
        ListNode r = new ListNode(-1);
        ListNode x = r;
        for(int i=0;i<t.length;i++){
            x.next = new ListNode(t[i]);
            x = x.next;
        }
        return r.next;     
    }

    public void reorderList(ListNode head) {
        if(head==null) return;
        List<ListNode> t = new ArrayList<>();

        while(head!=null) {
            t.add(head);
            head = head.next;
        }
        head = t.get(0);
        int i=0,j=t.size()-1;
        while(i<j){
            head.next = t.get(j);
            head = head.next;
            i++;
            if(i<j){
                head.next = t.get(i);
                head = head.next;
                j--;
            }
        }
        head.next = null;
    }

    public static int minDays(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int x = minDays(n/2)+n%2 + 1;
        int y = minDays(n/3)+ n%3 + 1;
        return x>y?y:x;
    }
}