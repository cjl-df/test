package leetcode.array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LinearArray{

    /**
     * 长度为n数组，存放[0,n-1]的数字，有一位重复,找出重复的数字
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int i =0;
        while(i<nums.length ){
            if(nums[i] == i){
                i++;
            }else{
                int x  =  nums[i];
                if(nums[x] ==x){
                    return x;
                }else{
                    nums[i] = nums[x];
                    nums[x] = x;
                }
            }
        }
        return -1;
    }

    /**
     * 一个整型数组nums里除两个数字之外，其他数字都出现了两次。时间复杂度是O(n)，空间复杂度是O(1)。
     * @param nums
     * @return
     */
    public int[] singleNumbersTemplate1(int[] nums) {
        int n = 0;
        for (int x : nums) {
            n^=x;
        }
        int div = 1;
        while((div&n) == 0){
            div<<=1;
        }
        int a=0,b=0;
        for (int i : nums) {
            if((i&div) == 0){
                a ^= i;
            }else {
                b ^= i;
            }
        }
        return new int[]{a,b};
    }

    //输入一组非负整数，把数组里所有数字拼接起来排成一个数，求能拼接出的所有数字中最小的一个。
    public String minNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                long x = Long.parseLong(nums[i] +""+nums[j]+"") ;
                long y = Long.parseLong(nums[j]+""+nums[i]+"");
                if(x>y){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }   
            }
            sb.append(nums[i]);
        }
        sb.append(nums[i]);
        return sb.toString();
    }

    //统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public int search(int[] nums, int start,int end,int target){
        if(end<start){
            return 0;
        }
        if(nums[start] == nums[end] && nums[start]== target){
            return end - start + 1;
        }
        int t = (start + end)/2;
        if(nums[t] == target){
            return search(nums, start, t-1, target) + search(nums, t+1, end, target) + 1;
        }else if(nums[t]>target){
            return search(nums, start, t-1, target);
        }else{
            return search(nums, t+1, end, target);
        }
    }

     //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : nums) {
            map.put(i,map.get(i) == null?1:map.get(i) +1);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int x  = (int)iterator.next();
            if(map.get(x) == 1){
                return x;
            }
        }
        return -1;
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    public int majorityElement(int[] nums) {
        int count = 0;
        int t = 0;
        for (int i : nums) {
            if(count == 0){
                count++;
                t = i;
            }
            else{
                if(i == t){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return t;
    }

    //将数组升序排列  插入
    public int[] sortArrayByInsert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int x  = nums[i-1];
            for (int j = i; j < nums.length; j++) {
                if(nums[j]<x){
                    int t = x;
                    x = nums[j];
                    nums[j] = t;
                }
            }
            nums[i-1] = x;
        } 
        return nums;
    }   

    //将数组升序排列  冒泡
    public int[] sortArrayByPop(int[] nums) {
        int e = nums.length;
        for (int i = 0; i < e; i++) {
            int temp = e;
            for (int j = 0; j < temp-1; j++) {
                if(nums[j]>nums[j+1]){
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                    e = j+1;
                }
            }
            i=0;
        } 
        return nums;
    }   

    //将数组升序排列  冒泡
    public int[] sortArrayByFast(int[] nums) {
        sortArrayByFast(nums,0,nums.length-1);
        return nums;
    }  

    public void sortArrayByFast(int[] nums,int start,int end) {
        if(start>=end){
            return ;
        }
        int i = start,j = end;
        int x = nums[start];
        while(start<end){
            while(start<end && nums[end]>=x){
                end--;
            }
            if(start<end)
                nums[start++] = nums[end];
            while(start<end && nums[start]<=x){
                start++;
            }
            if(start<end)
                nums[end--] = nums[start];
        }
        nums[start] = x;
        sortArrayByFast(nums,i,start-1);
        sortArrayByFast(nums,start+1,j);
    } 


    //纸牌分组
    public boolean isNStraightHand(int[] hand, int W){
        if(hand.length % W != 0) return false;
        if(W==1) return true;
        return _isNStraightHand(hand,W,0);
    }
    public boolean _isNStraightHand(int[] hand, int W,int start) {
        if(start>=hand.length) return true;
        int x = hand[start];  
        for(int i=start+1;i<hand.length;i++){
            if(hand[i]<x){
                int t = x;
                x = hand[i];
                hand[i] = t;   
            }
        }
        hand[start] = x;
        int y = x + W-1;
        int j = 1;
        int i = start+1;
        while(i<hand.length){
            if(hand[i]<=y){
                int t = hand[i] - x + start;
                if(i == t ){
                    j++;
                    i++;
                }else{
                    if(hand[t] != hand[i]){
                        j++;
                        hand[i] = hand[t];
                        hand[t] = hand[start] + t;
                    }
                    i++;
                }
                if(j == W){
                    return _isNStraightHand(hand,W,start+W);
                }  
            }     
        }
        return false;
    }

    //数组快速排序
    public void fastSort(int[] array,int start,int end) {
        if (end <= start) return;
        int t = array[start];
        int i = start,
          j = end;
        while (i < j) {
          while (i < j && array[j] > array[i]) {
            j--;
          }
          if (i < j) {
            array[i++] = array[j];
            array[j] = t;
          }
          while (i < j && array[i] < array[j]) {
            i++;
          }
          if (i < j) {
            array[j--] = array[i];
            array[i] = t;
          }
        }
        fastSort(array, start, i - 1);
        fastSort(array, i + 1, end);
      }

      //冒泡排序
      public void popSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int t = i;
          for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
              array[j] = array[j + 1];
              array[j + 1] = temp;
              t = j + 1;
            }
          }
          i = t;
        }
      }


    //1528. 重新排列字符串
    public String restoreString(String s, int[] indices) {
        for (int i = 0; i < indices.length; i++) {
            int x = indices[i];
            indices[x] = i; 
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < indices.length; i++) {
            sb.append(s.charAt(indices[i]));
        }
        return sb.toString();
    }
}   