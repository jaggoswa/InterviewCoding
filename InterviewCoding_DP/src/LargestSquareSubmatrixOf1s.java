/* Time Complexity = O(m*n)
 * Space Complexity = O(m*n)*/
public class LargestSquareSubmatrixOf1s {
	
	public static int largestSubmatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int ans = Integer.MIN_VALUE;
		
		for(int i=rows-1; i>=0; i--) {
			for(int j=cols-1; j>=0; j--) {
				if(i == rows - 1 && j == cols - 1) {
					dp[i][j] = 1;
				}
				else if(i == rows - 1 || j == cols - 1) {
					dp[i][j] = matrix[i][j];
				}
				else {
					if(matrix[i][j] == 0) {
						dp[i][j] = 0;
					}
					else {
						dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i][j+1],dp[i+1][j]));
					}
				}
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0;j<cols; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[][] M = {{0, 1, 1, 0, 1},
                	{1, 1, 0, 1, 0},
                	{0, 1, 1, 1, 0},
                	{1, 1, 1, 1, 0},
                	{1, 1, 1, 1, 1},
                	{0, 0, 0, 0, 0}};
		
		System.out.print(largestSubmatrix(M));
	}

}
