import java.util.HashSet;

/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class LongestConsecutiveSubsequence {
	
	static int longestConsecutiveSubsequence(int[] arr) {
		
		HashSet<Integer> hs = new HashSet<>();
		int result = Integer.MIN_VALUE;
		
		for(int i : arr) {
			hs.add(i);
		}
		
		for(int i : arr) {
			if(!hs.contains(i-1)) {
				int j=i;
				while(hs.contains(j))
					j++;
				
				result = Math.max(result, (j-i));
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {1, 9, 3, 10, 4, 20, 2};
		System.out.println("The length of the longest common subsequence is: "
		+ longestConsecutiveSubsequence(arr));
	}

}
