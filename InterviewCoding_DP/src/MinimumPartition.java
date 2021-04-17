
public class MinimumPartition {
	
	static int minPartitionDiff(int[] input) {
		int rows = input.length + 1;
		int sum = 0;
		
		for(int i=0; i<input.length; i++)
			sum += input[i];
		
		int cols = sum + 1;
		
		boolean[][] dp = new boolean[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(j == 0)
					dp[i][j] = true;
				else if(i == 0)
					dp[i][j] = false;
				else if(input[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j - input[i-1]];
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=sum/2; i++) {
			if(dp[rows-1][i] && Math.abs(sum - 2*i) < min) {
				min = Math.abs(sum - 2*i);
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		int[] input = {2,4,2,3};
		System.out.println("The minimum difference of subsets: " + minPartitionDiff(input));

	}

}
