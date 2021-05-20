/* Time Complexity = O(n^2)
 * Space Complexity = O(n)
 */
public class MaximumProductCutting {
	
	static int maximumProduct(int length) {
		
		int[] dp = new int[length + 1];

		for(int i=2; i<dp.length; i++) {
			for(int j=1; j<=i/2; j++) {
				dp[i] = Math.max(dp[i],Math.max(j * (i-j), dp[j] * dp[i-j]));
			}
		}
		
		return dp[length];
	}

	public static void main(String[] args) {
		int length = 10;
		System.out.print(maximumProduct(length));
	}

}
