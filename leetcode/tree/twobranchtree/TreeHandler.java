package leetcode.tree.twobranchtree;
import java.util.List;
import java.util.ArrayList;

public class TreeHandler {

    /**
     * 是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode t = mirrorTree(root);
        return isEquals(root,t);
    }

    /**
     * 对比两棵树是否相同
     * @param root
     * @param list
     * @return
     */
    public boolean isEquals(TreeNode r,TreeNode m){
        if(r !=  null && m != null){
            if(r.val != m.val)
                return false;
            else{
                boolean x = isEquals(r.left, m.left);
                if(!x){ return false;}
                x = isEquals(r.right, m.right);
                if(!x) return false;
                return true;
            }
        } else if(r==null && m ==null){
            return true;
        }
        else return false;
    }

    /**
     * 左顺遍历
     * @param root
     * @return
     */
    public List<Integer> leftToRight(TreeNode root,List<Integer> list){
        if(root == null){
            return list;
        }else{
            leftToRight(root.left,list);
            list.add(root.val);
            leftToRight(root.right, list);
        }
        return list;
    }

    /**
     * 树的镜像
     * @param root
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode nroot = new TreeNode(root.val);
        nroot.right =  mirrorTree(root.left);
        nroot.left =  mirrorTree(root.right);
        return nroot;
    }

    
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
        for(int i=0, j=(int)Math.pow( 2,i+1);j<=t.length;i++,j=(int)Math.pow( 2,i+1)){
            for(int begin=(int)Math.pow(2,i),temp=0 ;begin+temp<j;temp++){
                int top = begin + temp -1;
                int low = j+2*temp;
                if(low-1 < t.length &&x[top]!=null ){
                    x[top].left = x[low -1];
                }
                if(low<t.length &&x[top]!=null){
                    x[top].right = x[low];
                }
                if(low>=t.length){
                    return x[0];
                }
            }
        }
        return x[0];
    }
    
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root,new ArrayList<Integer>());
    }

    public List<Integer> inorderTraversal(TreeNode root,List<Integer> list) {   
        if(root != null){
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }     
        return list;
    }

    /**
     * 之字形遍历二叉树
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> temp =  new ArrayList<>();
        if(root !=null){
            List<Integer> t = new ArrayList<>();
            temp.add(root);
            t.add(root.val);
            res.add(t);
        }
        boolean flag = false;
        while(temp.size()>0){
            List<Integer> t = new ArrayList<>();
            List<TreeNode> y =  new ArrayList<>();
            for(int j = temp.size()-1;j>=0;j--){
                TreeNode z = temp.get(j);
                handleLevelOrderNode(t,y,z,flag);
            }
            flag = !flag;
            if(t.size()>0)
                res.add(t);
            temp = y;
        }
        return res;
    }

    private void handleLevelOrderNode(List<Integer> t,List<TreeNode> y,TreeNode z,boolean flag){
        TreeNode l = flag?z.left:z.right;
        TreeNode r = flag?z.right:z.left;

        if(l!=null){
            t.add(l.val);
            y.add(l);
        }
        if(r!=null){
            t.add(r.val);
            y.add(r);
        }
    }
}