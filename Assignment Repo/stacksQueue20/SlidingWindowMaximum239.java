package stacksQueue20;

import java.util.Arrays;

public class SlidingWindowMaximum239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums == null || k <= 0) return new int [0];
	    int [] arr = new int[nums.length - k + 1];
	    for(int i = 0; i < nums.length - k + 1; i++){
	        int max = Integer.MIN_VALUE;
	        for(int j = i; j < i + k; j++)
	           max = Math.max(max, nums[j]);
	        arr[i] = max;
	    }
	    return arr;
	}
}
