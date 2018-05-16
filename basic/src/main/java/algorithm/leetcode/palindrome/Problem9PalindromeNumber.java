package algorithm.leetcode.palindrome;

import java.util.Random;

/**
 * 判定一个数字是否为回文。
 * 算法1： 直接转换成string； reverse；看看是否相等；（整体）
 * 算法2： 字符串直接两个指针，一个前面，一个后面，然后往中间怼；直到相遇！（两边）
 * 算法3： 取高位和低位；然后判定是否相等；（两边往中间怼）
 *
 */
public class Problem9PalindromeNumber {

	private static Random rnd = new Random();
	public static void main(String[] args) {
		
		Problem9PalindromeNumber pp = new Problem9PalindromeNumber();
		int i = 1000021;
		for( i=0;i<1000000;i++)
		{
			boolean actual = pp.isPalindrome_1(i);
			boolean value  = pp.isPalindrome_3(i);
			if(actual != value)
			System.out.println(i+"   "+value+","+actual);
			//assert(actual == value);
		}

	}
	
	
	public boolean isPalindrome_1(int x)
	{
		return new StringBuffer(x+"").reverse().toString().equals(x+"");
	}
	
	/**
	 * 这个算法最大的问题是易读性不够。
	 * @param x
	 * @return
	 */
	public boolean isPalindrome_2(int x) {
		if(x<0)
			return false;
		 int leftexp = (int) Math.log10(x)+1;
		 int rightexp = 1;
		
		//开始左右对比, 不改变x的值的情况，也是两个指针！
		 /**
		  * 比如：取1234中的2；那么需要： x(第三位，百位)=  x %(10^3) /(10^2)
		  */
		 //那么去第k个的方法： 
		while(x>0)
		{
			
			long leftMod = (long)(Math.pow(10,leftexp));
			long rightMod = (long)(Math.pow(10,rightexp));
			if(leftMod==1)break;
			//System.out.println(leftMod+"=="+rightMod);
			
			long right = x % rightMod/(rightMod/10); 
			long left =   x % leftMod/(leftMod/10); 
		
			if(left != right)
			{
				return false;
			}
			
			leftexp--;
			rightexp++;
		}
		
		return true;
        
    }
	
	/**
	 * 整形翻转！然后判定，其实直接string翻转得了！
	 * @param x
	 * @return
	 */
	public boolean   isPalindrome_4(int x) {
	        if(x<0|| (x!=0 &&x%10==0)) return false;
	        int sum=0;
	        while(x>sum)
	        {
	            sum = sum*10+x%10;
	            x = x/10;
	        }
	        return (x==sum)||(x==sum/10);
	    }
	
	/**
	 * 这个算法易读性增强！两个指针往里怼！
	 * @param x
	 * @return
	 */
	public boolean isPalindrome_3(int x) {
		if(x<0)
			return false;
		if(x<10)
			return true;
		 int leftexp = (int) Math.log10(x);
		 int rightexp = (int) Math.log10(1);
		 
		//开始左右对比, 不改变x的值的情况，也是两个指针！
		 /**
		  * 比如：取1234中的2；那么需要： x(第三位，百位)=  x %(10^3) /(10^2)
		  */
		 //那么去第k个的方法： 
		while(x>0)
		{
			
			long leftMod = (long)(Math.pow(10,leftexp));
			long rightMod = (long)(Math.pow(10,rightexp));
			
			
			long right = x /(rightMod) % 10; 
			long left =   x /(leftMod) % 10;
		
			if(left != right)
			{
				return false;
			}
			
			leftexp--;
			rightexp++;
			if(leftexp<=rightexp || leftexp<=0)
				break;
		}
		
		return true;
        
    }

}
