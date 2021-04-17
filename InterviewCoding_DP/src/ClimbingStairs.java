
/*Time Complexity = O(n), since we are doing constant time work for each stair
  Space Complexity = O(n), for the dp table
 */
public class ClimbingStairs {

	static int distinctWays(int n){
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2]; //See the generalized solution from GFG
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int noOfStairs = 4;
		
		System.out.print("Number of distinct ways of climbing the stairs: " + distinctWays(noOfStairs));

	}

}
