import java.util.Arrays;
import java.util.Scanner;

/* Time Complexity = O(n^2)
 * Space Complexity = O(n)*/
public class LongestIncreasingSubsequence {
	
	static int LIS(int[] arr) {
		
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		
		int maxLength = 0;
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println("The longest increasing subsequence length is: " + LIS(arr));
	}

}
