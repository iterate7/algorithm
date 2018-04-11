package algorithm.leetcode;

public class NumberOf1Bits191 {

	/**skill:
	 * n & 1==1  odd
	 * n & 0==0  even
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
		int ones = 0;
	    	while(n!=0) {
	    		ones = ones + (n & 1); //(n & 1) = last bit is odd or even?
	    		n = n>>>1; //move right, the most left most be set 0.
	    	}
	    	return ones;
	}
	
	//http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
	 /**
	  *  n & (n-1)
	  * skill:Turn off the rightmost 1-bit.
	  * @param n
	  * @return
	  */
	  public int hammingWeight2(int n) {
	        int count = 0;
	        while(n != 0){ //n>0 is wrong
	            n = n & (n-1);
	            count++;
	        }
	        return count;
	    }
}
