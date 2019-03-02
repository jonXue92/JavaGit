package chapter2;

public class SecondMax {
    public static void main(String[] args) {
        int[] nums={1,2};
        int max=Math.max(nums[0],nums[1]);
        int second=Math.min(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            if(nums[i]>=max){
                second=max;
                max=nums[i];
            }else if(nums[i]>second){
                second=nums[i];
            }
        }
        System.out.println(second);
    }
}
