
package leetcode;
import leetcode.tree.twobranchtree.searchtree.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import leetcode.strutils.*;
import leetcode.permutation.*;
import leetcode.tree.twobranchtree.TreeHandler;
import leetcode.tree.twobranchtree.TreeNode;
import leetcode.array.LinearArray;
import leetcode.array.Matrix;
import leetcode.array.Util;

public class Test{ 
    public static void main(String[] args) {
        LinearArray linearArray = new LinearArray();
        // [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
        int res =linearArray.majorityElement(
            new int[]{3,3,4});
        System.out.println(res);
    }
}
