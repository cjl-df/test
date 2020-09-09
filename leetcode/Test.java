
package leetcode;

public class Test{ 
    public static void main(String[] args) {
        Integer [] t = new Integer[]{3,1,4,null,2};
        TreeNode root = new Tools().arrayToTree(t);
        int x  = new Solution().kthLargest(root,2);
        System.out.println(x);
    }
}
