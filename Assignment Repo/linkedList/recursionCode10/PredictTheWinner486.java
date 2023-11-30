package recursionCode10;

public class PredictTheWinner486 {

	public static void main(String[] args) {
		
		int[] nums= {1,5,233,2};
		System.out.println(PredictTheWinner(nums));
	}
	 public static boolean PredictTheWinner(int[] nums) {
         int[][] memo = new int[nums.length][nums.length];
        return getScore(0, nums.length - 1, nums, memo) >= 0;
    }
	   private static int getScore(int i, int j, int[] nums, int[][] memo) {
	        if (i == j) return nums[i];

	        if (memo[i][j] != 0) return memo[i][j];

	        int iScore = nums[i] - getScore(i + 1, j, nums, memo);
	        int jScore = nums[j] - getScore(i, j - 1, nums, memo);

	        return memo[i][j] = Math.max(iScore, jScore);
	    }
}
