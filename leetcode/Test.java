
package leetcode;
import leetcode.tree.twobranchtree.searchtree.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import leetcode.strutils.*;
import leetcode.permutation.*;
import leetcode.tree.twobranchtree.TreeHandler;
import leetcode.tree.twobranchtree.TreeNode;

public class Test{ 
    public static void main(String[] args) {
        PermutationMain permutationMain = new PermutationMain();
        List<List<Integer>> res =permutationMain.permuteUnique(new int[]{1,1,2,3},0,3) ;
        permutationMain.print(res);
        System.out.println(res);
    }
}
