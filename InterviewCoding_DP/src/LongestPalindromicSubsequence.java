/* Time complexity = O(mn)
 * Space Complexity = O(mn)
 */
public class LongestPalindromicSubsequence {
	
	public static int LPS(String str1) {
		String str2 = reverse(str1);
		int n = str1.length();
		int[][] dp = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}
				else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[n][n];
	}
	
	private static String reverse(String str) {
		
		char[] arr = str.toCharArray();
		char temp;
		
		int i=0, j=str.length()-1;
		
		while(i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}
		
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		
		String str = "GEEKSFORGEEKS";
        System.out.printf("The length of the LPS is %d", LPS(str));
	}

}
