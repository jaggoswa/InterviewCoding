/* Time Complexity = O(nc), where n is the length of the rod and l is the number of cuts given
 * Space Complexity = O(nc)
 */
public class RodCuttingProblem {
	
	static int maxProfit(int[] prices, int[] length, int L) {
		
		int[][] dp = new int[prices.length + 1][L + 1];
		
		for(int i=0; i<=prices.length; i++) {
			for(int j=0; j<=L; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(length[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i][j-length[i-1]]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[prices.length][L];
		
	}

	public static void main(String[] args) {
		
		int L = 5;
		
		int[] length = {1,2,3,4};
		int[] prices = {2,5,7,8};
		
		System.out.println("Max Profit: " + maxProfit(prices,length,L));

	}

}
