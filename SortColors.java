class Solution {
    	public void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int i =0;
		while(i<=end){
			if(nums[i] == 0){
				nums[i] = nums[start];
				nums[start++] = 0;
				i++;
			}else if(nums[i] == 2){
				nums[i] = nums[end];
				nums[end--] = 2;
			}else{
				i++;
			}
			
		}

	}
}