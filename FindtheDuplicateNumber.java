class Solution {
  public int findDuplicate(int[] nums) {
	  //use hashset to save all the numbers since hash does not allow duplicate
	  //hashset has function contains which can test
        HashSet hash = new HashSet();
        for(int number: nums){
            if(hash.contains(number)){
                return number;
            }else{
                hash.add(number);
            }
        }
        return 0;
    }
}