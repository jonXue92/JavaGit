package lecture2;

public class Selectionsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {10,2,5,-2,8,1,9};
		for (int i=0;i<nums.length-1;i++) {
			int minindex=i;
			for (int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[minindex]) {
					minindex=j;
				}
			}
			int temp=nums[i];
			nums[i]=nums[minindex];
			nums[minindex]=temp;
		}
		for(int k:nums) {
			System.out.print(k+" ");
		}
		System.out.println();
	}

}
