package leetcode.tree.twobranchtree.searchtree;
import leetcode.tree.twobranchtree.*;
import java.util.*;

public class Tools {
     TreeNode kthLargest(TreeNode root, int[] x,int k) {
        if(root == null) return null;
        TreeNode t = kthLargest(root.right,  x,k) ;
        if(t!=null) return t;
        x[0] = x[0] + 1;
        if(x[0] == k) return root;
        t = kthLargest(root.left, x, k);
        if(t != null) return t;
        return null;
    }

    /**
     * 第k大节点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        TreeNode t =  kthLargest(root,new int[]{0},k);
        if(t!=null) return t.val;
        return -1;
    }


    /**
     * 二叉搜索树，检索相应节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        List<TreeNode> t = findeNode(root, val, null); //没找到
        if(t==null) return null;
        else return t.get(1);
    }

        /**
     * 二叉搜索树查找节点,并返回前驱节点
     * @param root
     * @param key
     * @param pre
     * @return
     */
    List<TreeNode> findeNode(TreeNode root, int key,TreeNode pre){
        if(root == null) return null;
        if(root.val == key){
            return Arrays.asList(new TreeNode[]{pre,root});
        }else{
            if(key < root.val ){
                return findeNode( root.left,  key,root);
            }else{
                return findeNode( root.right,  key,root);
            }
        }
    }

    /**
     * 二叉搜索树 转换双向循环链表
     * @param root
     * @return
     */
    public TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}