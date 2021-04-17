
/* Time Complexity = O(n^2)
 * Space Complexity = O(n^2)
 */
public class OptimalStrategyForAGame {
	
	static int maximumProfit(int[] arr) {
		
		int n = arr.length;
		int[][] dp = new int[n][n];
		
		for(int g=0; g<arr.length; g++) {
			for(int i=0, j=g; j<arr.length; i++,j++) {
				if(g == 0)
					dp[i][j] = arr[i];
				else if(g == 1)
					dp[i][j] = Math.max(arr[i], arr[j]);
				else {
					int val1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
					int val2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
					
					dp[i][j] = Math.max(val1, val2);
				}
			}
		}
		
		return dp[0][n-1];
		
	}

	public static void main(String[] args) {
		int arr1[] = { 8, 15, 3, 7 };
        System.out.println(maximumProfit(arr1));
  
        int arr2[] = { 2, 2, 2, 2 };
        System.out.println(maximumProfit(arr2));
  
        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        System.out.println(maximumProfit(arr3));
    }

}
