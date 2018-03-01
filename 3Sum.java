class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int target = 0;
        
        //keep 3 pointers front, end, middle
        for(int i =0; i< nums.length-2; i++){
        	//if i= previous, i++
            if(i>0&&nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
            	//if sum < target, move the middle pointer
                if(nums[i] +nums[j] + nums[k] <target){
                    j++;
                    //if j = previous j; j++
                    while(nums[j]== nums[j-1]&& j<k) j++;
                }else if(nums[i] +nums[j] + nums[k] >target){
                    k--;
                    while(nums[k]== nums[k+1]&& j<k) k--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                    while(nums[k] == nums[k+1] && j < k) --k;
                    
                }
            }
        }
        return result;
    }

}