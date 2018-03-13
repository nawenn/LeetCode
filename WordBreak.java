class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
        	int mid = start+(end-start)/2;
        	if(target == nums[mid]) {
        		int index = mid;
        		while(index<nums.length&&nums[index] == target){
        
        			ans[1] = index;
                    index++;
        		}
        		index = mid;
        		while(index>= 0 && nums[index] == target){
        			ans[0] = index;
                    index--;
        		}
        		return ans;
        	}
        	else{
        		if(target<nums[mid]) end = mid-1;
        		else start = mid+1;
        	}
        }
        ans[0] =-1;
        ans[1] =-1;
        return ans;
    }
}