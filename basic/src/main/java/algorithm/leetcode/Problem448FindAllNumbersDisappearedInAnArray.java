package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem448FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {

		Problem448FindAllNumbersDisappearedInAnArray nin = new Problem448FindAllNumbersDisappearedInAnArray();
		int nums[] = new int[]{3,4,5,2,1,1,1};
		//nums = new int[]{1,3,3,4,5,6};
		nin.findDisappearedNumbers(nums);
		
	}
	
	

	
 
	/**
	 * 算法思路：
	 * 1. 利用已有的数组来保存遍历的信息；
	 * 2. 遍历过的数字如何记录？ 利用位置来表示对应的值，也就是说value这个数字是否出现：主要看nun[value]==负数状态来表示；当然为了数组不越界，直接把value-1；
	 * 3. 然后已有的数组遍历一遍之后则形成一个出现数字的统计数组（类似于map结构，注意：index是值，对应的value是Boolean信息，存在与否）
	 * 4. 输出没出现的数字（value是负数的）
	 * 
	 * 技巧：历史数组为了防止重叠，用前一位。另外为了不影响原来位置的数值，不能冲掉，改变负值状态即可，这个技巧特别注意！
	 * 核心：核心就在这里：一个值有两层含义：正负代表存在；绝对值代表当前的值
	 * 
	 * @param nums list of numbers
	 * @param n [1,n]
	 * @return numbers of not exist in nums
	 */
	public List<Integer> findDisappearedNumbers(int[] nums)
	{
		List<Integer> ret = new ArrayList<Integer>();
		int n = nums.length;
		for (int item : nums) {
			
			//取值, 不管状态有没有被改变，这个值肯定是正确的。核心就在这里：一个值有两层含义：正负代表存在；绝对值代表当前的值
			item = Math.abs(item); 
			
			//把item的状态改变，记录为负状态
			if(nums[item-1]<0) //已经记录了，不用再记录
				continue;
			
			//这个value代表原来的值，我们要保留，不管正负。
			int value = Math.abs(nums[item - 1]);
			nums[item - 1] = -1; // 改变状态；
			nums[item - 1] = -value;// 原来的值保留着！如果nums[item]==-1那么item+1数字出现;
									// 这里直接设置-1其实是可以的，但是会覆盖原来的值！所以为了兼容，那就改变值即可！

		}

		boolean findNotExist = false;
		for (int i = 0; i < n; ++i) {
			if (nums[i] > 0) {
				findNotExist = true;
				System.out.println(i + 1);
				ret.add(i+1);
			}
		}

		// 都存在的话
		if (!findNotExist)
			System.out.println("NONE");
		return ret;
	}
	
	
	//用更多空间的思路
	public List<Integer> findDisappearedNumbersBaseMoreSpace(int[] nums) {
        boolean[] marked = new boolean[nums.length];
      for(int i=0; i < nums.length; ++i) {
         int val = nums[i];
         marked[val-1] = true;
      }
      List<Integer> result = new ArrayList<Integer>();
      for(int i=0; i < nums.length; ++i) {
         if(!marked[i]) {
            result.add(i+1);
         }
      }
      return result;
  }

}
