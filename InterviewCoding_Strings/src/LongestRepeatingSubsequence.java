/* Time complexity = O(mn)
 * Space Complexity = O(mn)
 */
public class LongestRepeatingSubsequence {
	
	static void LRS(String str) {
		
		int n = str.length()+1;
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(str.charAt(i-1) == str.charAt(j-1) && i != j)
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		System.out.print("The longest repeating subsequence is: " + dp[n-1][n-1]);
	}

	public static void main(String[] args) {
		String str = "axxxy";
		
		LRS(str);

	}

}
