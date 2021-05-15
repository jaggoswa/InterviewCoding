/* Time Complexity = O(n^3), since no. of subproblems is O(n^2)
 * 							and no of split possible in a subproblem = O(n)
 * Space complexity = O(n^2)*/
public class MatrixMultiplication {
	
	static int numberOfMultiplications(int[] arr) {
		
		int[][] dp = new int[arr.length - 1][arr.length - 1];
		
		for(int g=0; g<dp.length; g++) {
			for(int i=0, j=g; j<dp.length; i++, j++) {
				if(g == 0) {
					dp[i][j] = 0;
				}
				else if(g == 1) {
					dp[i][j] = arr[i] * arr[j] * arr[j+1];
				}
				else {
					int min = Integer.MAX_VALUE;
					
					for(int k=i; k<j; k++) {
						int totalCount = dp[i][k] + dp[k+1][j] + (arr[i] * arr[k+1] * arr[j+1]);
						if(totalCount < min)
							min = totalCount;
					}
					
					dp[i][j] = min;
				}
			}
		}
		
		return dp[0][dp.length - 1];
		
	}

	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10, 30};
		System.out.print(numberOfMultiplications(arr));

	}

}
