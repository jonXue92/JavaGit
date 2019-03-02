package chapter2;

import java.util.*;

public class Deduplication {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    //O(n) time,O(n)space
    public static int deduplication(int[] nums) {
        // write your code here
        HashMap<Integer,Boolean> mp=new HashMap<Integer, Boolean>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],true);
        }
        int result=0;
        for(Map.Entry<Integer,Boolean> entry:mp.entrySet()){
            nums[result++]=entry.getKey();
        }
        return result;
    }
    public static int deduplication0(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> st=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
//            if (!st.contains(nums[i])) {
                st.add(nums[i]);
//            }
        }
        int index = 0;
        Iterator it = st.iterator();
        while (it.hasNext()) {
            nums[index++] = (int) it.next();
        }
        return index;
    }
    //O(nlogn)time,O(1)extra space
    public static int deduplication1(int[] nums){
        if(nums.length==0){
            return 0;
        }
        //先排序
        Arrays.sort(nums);
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[len]){
                nums[++len]=nums[i];
            }
        }
        return len+1;
    }
    public static void main(String[] args) {
    int[] list={1,3,1,4,4,2};
    int n=deduplication1(list);
    for(int k:list){
        System.out.print(k+" ");
    }
    System.out.println();
    System.out.println(n);
    }
}