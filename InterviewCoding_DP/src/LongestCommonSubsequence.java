import java.util.Scanner;

/* Time complexity = O(mn)
 * Space Complexity = O(mn)
 */
public class LongestCommonSubsequence {
	
	static void lcs(String str1, String str2) {
		
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
		
		System.out.println("The longest common subsequence length is: " + dp[rows - 1][cols - 1]);
		
		//For printing the longest common subsequence
		printLCS(dp,str1,str2);

	}
	
	static void printLCS(int[][] dp,String str1, String str2) {
		
		int i = str1.length(), j = str2.length();
		int k = 0;
		
		int lcsLength = dp[i][j];
		char[] lcs = new char[lcsLength];
		
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				lcs[k] = str1.charAt(i-1);
				i--;
				j--;
				k++;
			}else {
				if(dp[i][j-1] > dp[i-1][j])
					j--;
				else
					i--;
			}	
		}
		
		lcs = reverse(lcs);
		
		System.out.print("The longest common subsequence is: ");
		for(char elem : lcs) {
			System.out.print(elem);
		}
		System.out.println();
	}
	
	
	static char[] reverse(char[] arr) {
		
		int i = 0, j = arr.length-1;
		
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first string:");	//AGGTAB
		String str1 = sc.next();
		System.out.print("Enter second string:");	//GXTXAYB
		String str2 = sc.next();
		
		lcs(str1,str2);	//4
		
	}

}
