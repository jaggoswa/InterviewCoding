import java.util.HashMap;

public class LongestSubstringWithoutRepetition {
	
	public static int longestSubstring(String str) {
		
		if(str.length() == 0) {
			return 0;
		}
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		hm.put(str.charAt(0), 1);
		int maxLength = 1;
		
		int i=0, j=0;
		while(j < str.length() - 1) {
			j++;
			char ch = str.charAt(j);
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            
            while(hm.get(str.charAt(j)) > 1) {
                ch = str.charAt(i);
                hm.put(ch, hm.get(ch) - 1);
                i++;
            }
            
            maxLength = Math.max(maxLength, j-i+1);
		}
		
		return maxLength; 
	}

	public static void main(String[] args) {
		
		String str = "BBBB";
		System.out.println(longestSubstring(str));

	}

}
