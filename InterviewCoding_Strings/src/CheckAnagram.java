import java.util.HashMap;

public class CheckAnagram {
	
	static boolean isAnagram(String str1, String str2) {
		char arr[] = str1.toCharArray();
		HashMap<Character,Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				int count = hm.get(arr[i]);
				hm.put(arr[i], count++);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		
		for(int i=0; i<str2.length(); i++) {
			if(hm.containsKey(str2.charAt(i))) {
				int count = hm.get(str2.charAt(i));
				if(count == -1)
					return false;
				count--;
				hm.put(arr[i], count);
			}
			else
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		
		boolean isAnagram = isAnagram(str1.toLowerCase(),str2.toLowerCase());
		
		if(isAnagram)
			System.out.println("The strings are anagram");
		else
			System.out.print("The strings are not anagram");

	}

}
