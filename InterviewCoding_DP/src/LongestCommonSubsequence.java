import java.util.Scanner;

public class LongestCommonSubsequence {
	
	static int lcs(String str1, String str2) {
		
		int rows = str1.length()+1;
		int cols = str2.length()+1;
		int[][] dp = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		
		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first string:");
		String str1 = sc.next();
		System.out.print("Enter second string:");
		String str2 = sc.next();
		
		System.out.println("The longest common subsequence length is: " + lcs(str1,str2));
		
	}

}
