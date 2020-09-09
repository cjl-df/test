package leetcode;
import java.util.*;
import leetcode.*;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        List<TreeNode> t = findeNode(root, key, null);
       
        //没找到
        if(t==null) return root;
      
        TreeNode r = t.get(1);
        TreeNode p = t.get(0);
        //如果是叶子节点，直接删除
        if(r.left == null && r.right == null){
            if(p != null)  replaceNode(p, r, null);
            else return null;
        }
        //存在左子树，找出左子树最大节点替换当前节点
        if(r.left !=null ){
            TreeNode max = findLeftMaxNode(r.left);
            max.right = r.right;
            if(p == null) return max;
            replaceNode(p,r,max);
        }else{
            return p.right;
        }
        return root;
    }

    public void replaceNode(TreeNode p,TreeNode d,TreeNode n){
        if(p.left == d){
            p.left = n;
        }else{
            p.right = n;
        }
    }

    public List<TreeNode> findeNode(TreeNode root, int key,TreeNode pre){
        if(root == null) return null;
        if(root.val == key){
            return Arrays.asList(new TreeNode[]{pre,root});
        }else{
            List<TreeNode> temp=null;
            temp = findeNode( root.left,  key,root);
            if(temp!=null){
                return temp;
            }
            temp = findeNode( root.right,  key,root);
            return temp;
        }
    }

    public TreeNode findLeftMaxNode(TreeNode t){
        if(t.right !=null){
            TreeNode r = t;
            TreeNode x = t;
            t = t.right;
            while(t.right!=null){
                x = t;
                t = t.right;
            }
            x.right = t.left;
            t.left = r;
        }
        return t;
    }
}


public class Test{ 
    public static void main(String[] args) {
        Integer [] t = new Integer[]{5,3,6,2,4,null,7};
        TreeNode root = new Tools().arrayToTree(t);
    }
}
