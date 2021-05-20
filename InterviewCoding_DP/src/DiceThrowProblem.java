/* Time Complexity = O(m*n*x)
 * Space Complexity = O(m*n)
 */
public class DiceThrowProblem {
	
	static long findWays(int m, int n, int x) {
		long[][] dp = new long[n+1][x+1];
		for(int j=1; j<=m && j<=x; j++) {
			dp[1][j] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=i; j<=x; j++) { //With i dices we will always get a sum of atleast i
				for(int k=1; k<j && k<=m; k++) {
					dp[i][j] += dp[i-1][j-k];
				}
			}
		}
		
		return dp[n][x];
	}

	public static void main(String[] args) {
		System.out.println(findWays(4, 2, 1)); 
        System.out.println(findWays(2, 2, 3)); 
        System.out.println(findWays(6, 3, 8)); 
        System.out.println(findWays(4, 2, 5)); 
        System.out.println(findWays(4, 3, 5)); 

	}

}
