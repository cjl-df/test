package leetcode;
import java.util.*;

/**
 * 二叉搜索树
 */
class TwoBranchSearchTree {
    /**
     * 删除指定节点
     * @param root
     * @param key
     * @return 根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        List<TreeNode> t = findeNode(root, key, null); //没找到
        if(t==null) return root;
        TreeNode r = t.get(1);
        TreeNode p = t.get(0);
        if(r.left == null && r.right == null){//如果是叶子节点，直接删除
            if(p != null)  {replaceNode(p, r, null); return root;}
            else return null;
        }
        if(r.left !=null ){ //存在左子树，找出左子树最大节点替换当前节点
            TreeNode max = findLeftMaxNode(r.left);
            max.right = r.right;
            if(p == null) return max;
            replaceNode(p,r,max);
        }else{
            if(p == null) return r.right;
            replaceNode(p, r, r.right);
            return root;
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

    /**
     * 查找结点
     * @param t
     * @return
     */
    public TreeNode findeNode(TreeNode root, int key){
        List<TreeNode> t = findeNode(root, key, null); //没找到
        if(t==null) return null;
        else return t.get(1);
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
        Integer [] t = new Integer[]{1,null,2};
        TreeNode root = new Tools().arrayToTree(t);
        TreeNode x  = new TwoBranchSearchTree().deleteNode(root,1);
        System.out.println("x");
    }
}
