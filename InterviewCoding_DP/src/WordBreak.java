import java.util.Arrays;
import java.util.List;

/* Time Complexity = O(n^3)
 * Space Complexity = O(n)
 */
public class WordBreak {
	
	static boolean wordBreak(String s, List<String> dict) {
		int[] dp = new int[s.length()];
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<=i; j++) {
				if(dict.contains(s.substring(j,i+1))){
					if(j > 0)
						dp[i] += dp[j-1];
					else
						dp[i] += 1;
				}
			}
		}
		
		return dp[s.length()-1] > 0;
	}

	public static void main(String[] args) {
		String str = "leetcode";
		String[] arr = {"leet","code"};
		List<String> dict = Arrays.asList(arr);
		
		if(wordBreak(str,dict))
			System.out.print("Possible");
		else
			System.out.print("Not possible");
		

	}

}
