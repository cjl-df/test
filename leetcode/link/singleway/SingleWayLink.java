package leetcode.link.singleway;
import leetcode.link.ListNode;
import java.util.Stack;

public class SingleWayLink {

    //两个链表相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = linkToStack(l1);
        Stack<Integer> s2 = linkToStack(l2);
        ListNode root = null;
        int temp = 0;
        while(!s1.empty() && !s2.empty()){
            int x = s1.pop() + s2.pop() + temp;
            ListNode r = new ListNode(x%10);
            r.next = root;
            root = r;
            temp = x /10;
        }
        if(s1.empty()){
            s1 = s2;
        }
        while(!s1.empty()){
            int x = s1.pop()  + temp;
            ListNode r = new ListNode(x%10);
            r.next = root;
            root = r;
            temp = x /10;
        }
        if(temp>0){
            ListNode r = new ListNode(temp);
            r.next = root;
            root = r;
        }
        return root;
    }

    //单向非循环链表
    public Stack<Integer> linkToStack(ListNode l){
        Stack<Integer> s = new Stack<Integer>();
        while(l!=null){
            s.push(l.val);
            l = l.next;
        }
        return s;
    }
}