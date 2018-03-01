class Solution {
	public List<List<Integer>> permute(int[] nums){
        Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int[] result = nums.clone();
		//reverse the result so if nums = reversed num(last permutation) then stop the search
		result = reverse(result, 0, result.length/2);
		List<Integer> subList = new ArrayList<>();
		for(int n: nums){
			subList.add(n);
		}
		ans.add(subList);
		//if they are not equal, keep find more permutation
		while(Arrays.equals(nums,result)!=true){
			subList = new ArrayList<>();
			nums = findPermutation(nums);
			//add each permutation
			for(Integer num: nums){
				subList.add(num);
			}
			ans.add(subList);
		}
		return ans;
	}
	
	public int[] reverse(int[] nums, int start, int end){
		int index = 0;
		for(int i = start; i< end; i++){
			int temp = nums[i];
			nums[i] = nums[nums.length-1-index];
			nums[nums.length-1-index]= temp;
			index++;
		}
		return nums;
	}

	public int[] findPermutation(int[] nums) {
		int i = nums.length-2;
		//from the end of num find a value that break the increasing trend
		while(i>=0&&nums[i] >= nums[i+1]){
			i--;
		}
		if(i>=0){
			//from end of the num find a value that is larger then the selected value
			int j=nums.length-1;
			while(j>i&& nums[j]<=nums[i]){
				j--;
			}
			//switch the two find and reverse everything after that value.
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
			reverse(nums,i+1,(nums.length-1-i)/2+i+1);
			
		}else{
			reverse(nums, 0, nums.length/2);
		}
		return nums;
	}
}