class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(list, new ArrayList<Integer>(), nums, 0);
            return list;
    }
    
    public void backtracking(List<List<Integer>> list, List<Integer> subList, int[] nums, int start){
/*
 *          [] 
 *     [1]  [2]   [3]
 *   [1,2]  [1,3]  [2,3]
 * [1,2,3]     
 */
        list.add (new ArrayList<>(subList));
        for(int i =start; i<nums.length; i++){
            subList.add(nums[i]);
            backtracking(list, subList, nums, i+1);
            subList.remove(subList.size() - 1);
        }
    }
}