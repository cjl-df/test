package leetcode.twobranchtree.searchtree;
import leetcode.twobranchtree.*;
import java.util.*;

public class Tools {

    /**
     * 将数组转换成树，按层序结构转换
     * @param  t 数组
     * @return 树
     */
    public TreeNode arrayToTree(Integer [] t ){
        if(t==null || t.length <1) return null;
        TreeNode [] x = new TreeNode[t.length];
        for(int i=0;i<x.length;i++){
            if(t[i]!=null)
                x[i] = new TreeNode(t[i]);
            else 
                x[i] = null;
        }
        for(int i=0, j=(int)Math.pow( 2,i+1);j<t.length;i++,j=(int)Math.pow( 2,i+1)){
            for(int begin=(int)Math.pow(2,i),temp=0 ;begin+temp<j;temp++){
                int w = j+2*temp;
                if(w-1 < t.length){
                    x[begin+temp-1].left = x[w -1];
                }
                if(w<t.length){
                    x[begin+temp-1].right = x[w];
                }
                if(w>=t.length){
                    return x[0];
                }
            }
        }
        return x[0];
    }

    public TreeNode kthLargest(TreeNode root, int[] x,int k) {
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
    public List<TreeNode> findeNode(TreeNode root, int key,TreeNode pre){
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
}