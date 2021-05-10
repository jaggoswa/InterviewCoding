/* Time complexity = O(mn)
 * Space Complexity = O(mn)
 */
public class ShortestCommonSupersequence {
	
	static void SCS(String str1, String str2) {
		int rows = str1.length()+1;
		int cols = str2.length()+1;
		
		int[][] dp = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		
		int scsLength = str1.length() + str2.length() - dp[rows-1][cols-1];
		
		System.out.println("The shortest common supersequence is: " + scsLength);
		
		printSCS(dp,str1,str2);
	}
	
	static void printSCS(int[][] dp, String str1,String str2) {
		
		int i = str1.length(), j = str2.length();
		int k = 0;
		
		int scsLength = i + j - dp[i][j];
		char[] scs = new char[scsLength];
		
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				scs[k] = str1.charAt(i-1);
				i--;
				j--;
			}
			else{
				if(dp[i][j-1] > dp[i-1][j]) {
					scs[k] = str2.charAt(j-1);
					j--;
				}
				else {
					scs[k] = str1.charAt(i-1);
					i--;
				}
			}
			k++;
		}
		
		while(i > 0) {
			scs[k] =  str1.charAt(i-1);
			i--;
			k++;
		}
		
		while(j > 0) {
			scs[k] =  str1.charAt(j-1);
			j--;
			k++;
		}
		
		scs = reverse(scs);
		
		System.out.print("The shortest common supersequence is: ");
		for(char elem : scs) {
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
		SCS("abcdaf","acbcf");

	}

}
