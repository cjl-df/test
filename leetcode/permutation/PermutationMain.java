package leetcode.permutation;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PermutationMain {
    
    public List<List<Integer>> permuteUnique(int[] nums){
        return permuteUnique(nums,0,nums.length-1);
    }

    public List<List<Integer>> permuteUnique(int[] nums,int x,int y) {
        List<List<Integer>> list  = new ArrayList<List<Integer>>();
        if(x == y){
            List<Integer> t = new ArrayList<>();
            t.add(nums[x]);
            list.add(t);
            return list;
        }
        Set<Integer> set = new HashSet<Integer>();
        int i = x;
        while(i<=y){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                int temp = nums[i];
                nums[i] = nums[x];
                List<List<Integer>> t = permuteUnique(nums,x+1,y);
                for (List<Integer> list2 : t) {
                    list2.add(0, temp);
                }
                list.addAll(t);
                nums[i] = temp;
            }
            i++;
        }
        return list;
    }

    public void print(List<List<Integer>> list){
        Iterator<List<Integer>> iterator = list.iterator();
        while(iterator.hasNext()){
            List<Integer> t = iterator.next();
            Iterator<Integer> i = t.iterator();
            while(i.hasNext()){
                System.out.print(i.next()+" ");
            }
            System.out.println();
        }
    }
}