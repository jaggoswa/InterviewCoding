import java.util.Arrays;
import java.util.Scanner;

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
		
		return dp[dp_length - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of the array: ");
		int size = sc.nextInt();
		
		System.out.print("Enter the array: ");
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("The longest increasing subsequence length is: " + LIS(arr));

	}

}
