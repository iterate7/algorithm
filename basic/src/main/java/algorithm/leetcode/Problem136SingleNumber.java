package algorithm.leetcode;

public class Problem136SingleNumber {

	/**
	 * a^b^a = a^a^b = 0^b=b
	 * @param nums
	 * @return
	 */
	 public int singleNumber(int[] nums) {
		 int res = 0;
	       for(int i=0;i<nums.length;i++)
	       {
	    	   res^=nums[i];
	       }
	 return res;
	 }
	 
}
