
public class LongestPalindromicSubstring {
	
	static int longestPalindromicSubstrings(String str) {
		
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		int len = 0;
		
		for(int g=0; g<n; g++) {
			for(int i=0,j=g; j<n; i++,j++) {
				if(g == 0) {
					dp[i][j] = true;
				}else if(g == 1) {
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				else {
					if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				
				if(dp[i][j])
					len = g + 1;
			}
		}
		
		return len;
	}

	public static void main(String[] args) {
		String str = "abccbc";
		System.out.println("The number of palindromic substrings are: " + longestPalindromicSubstrings(str));

	}

}
