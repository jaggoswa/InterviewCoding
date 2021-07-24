import java.util.HashMap;

public class KAnagram {
	
public static boolean checkKAnagram(String str1, String str2, int k) {
		
		if(str1.length() != str2.length())
			return false;
		
		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();
		int matchCount = 0;
		
		for(int i=0; i< str1.length(); i++) {
			char ch = str1.charAt(i);
			hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
		}
		
		for(int i=0; i<str2.length(); i++) {
			char ch = str2.charAt(i);
			hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
			if(hm1.containsKey(ch) && hm2.get(ch) <= hm1.get(ch))
				matchCount++;
		}
		
		if(str1.length() - matchCount <= k)
			return true;
		
		return false;
		
	}

	public static void main(String[] args) {
		
		String str1 = "geeks", str2 = "eggkf";
		int k = 1;
		
		if(checkKAnagram(str1, str2, k)) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}

}
