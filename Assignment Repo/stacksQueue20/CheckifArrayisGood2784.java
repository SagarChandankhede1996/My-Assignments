package stacksQueue20;

import java.util.Arrays;

public class CheckifArrayisGood2784 {

	 public boolean isGood(int[] nums) 
	  {
	    int max_val = Integer.MIN_VALUE;
	    for(int num: nums)
	    {
	      if(max_val < num)
	      {
	        max_val = num;
	      }
	    }
	    if(nums.length != max_val + 1)
	    {
	      return false;
	    }
	    Arrays.sort(nums);
	    if(nums[0] != 1 || nums[nums.length - 2] != max_val || nums[nums.length - 1] != max_val)
	    {
	      return false;
	    }
	    int i = 1;
	    while(i < nums.length - 1 && nums[i] - nums[i - 1] == 1)
	    {
	      i++;
	    }
	    return i == nums.length - 1;      
	  }

}
