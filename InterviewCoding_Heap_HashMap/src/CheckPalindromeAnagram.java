import java.util.HashMap;
import java.util.Map;
public class CheckPalindromeAnagram {
	
	public static boolean checkPalindrome(String str) {
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		int oddCount = 0;
		for(Map.Entry<Character, Integer> e : hm.entrySet()) {
			
			if(e.getValue() % 2 != 0) {
				oddCount++;
			}
		}
		
		if(oddCount <= 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		
		String str = "geeksgeeks";
		
		if(checkPalindrome(str)) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
		
	}

}
