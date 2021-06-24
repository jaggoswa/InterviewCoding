import java.util.Arrays;
import java.util.Scanner;

/* Time Complexity = O(n^2)
 * Space Complexity = O(n)*/
public class LongestIncreasingSubsequence {
	
	static int LIS(int[] arr) {
		int dp_length = arr.length;
		int[] dp = new int[dp_length];
		Arrays.fill(dp, 1);
		
		for(int i=1; i<dp_length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int elem : dp) {
			max = Math.max(max, elem);
		}
		
		return max;
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println("The longest increasing subsequence length is: " + LIS(arr));
	}

}
