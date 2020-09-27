
package leetcode;
import java.util.HashSet;
// import leetcode.tree.twobranchtree.searchtree.*;
// import java.util.Arrays;
// import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
// import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
// import leetcode.strutils.*;
// import leetcode.permutation.*;
import leetcode.tree.twobranchtree.TreeHandler;
import leetcode.tree.twobranchtree.TreeNode;
import leetcode.array.LinearArray;
import leetcode.array.Util;
import leetcode.bytepa.ByteMath;
// import leetcode.array.Matrix;
// import leetcode.array.Util;
import java.util.Set;
import java.util.Stack;

public class Test{ 
    public static void main(String[] args) {
        TreeHandler treeHandler = new TreeHandler();
        TreeNode root = treeHandler.arrayToTree(new Integer[]{
            1,2,3,4,23,43,3
        });
        List<List<Integer>> t = treeHandler.levelOrder(root);
        for(int i =0;i< t.size();i++){
            System.out.print(t.get(i)+"");
            System.out.println( );
        }
        System.out.println( );
    }
}

// "yxyxxxyyxxyxxxx"
// "yyyxyyyxyxxxyxy"