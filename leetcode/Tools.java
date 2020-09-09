package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

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
                x[begin+temp-1].left = x[j+2*temp-1 ];
                x[begin+temp-1].right = x[j+2*temp];
            }
        }
        return x[0];
    }
}