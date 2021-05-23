/* Time complexity = O(sum*n) 
 * Space Complexity = O(sum*n) */
public class BalancedPartition {
	
	public static boolean balancedPartition(int[] arr) {
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		if(sum % 2 != 0)
			return false;
		else
			return subsetSum(arr,sum/2);
	}
	
	private static boolean subsetSum(int[] arr, int sum) {
		
		int rows = arr.length + 1;
		int cols = sum + 1;
		boolean[][] dp = new boolean[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(j == 0)
					dp[i][j] = true;
				else if(i == 0)
					dp[i][j] = false;
				else if(j < arr[i-1])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
			}
		}
		
		return dp[rows-1][cols-1];
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };
		
		if (balancedPartition(arr) == true)
            System.out.println(
                "Can be divided into two subsets of equal sum");
        else
            System.out.println(
                "Can not be divided into two subsets of equal sum");
	}

}
