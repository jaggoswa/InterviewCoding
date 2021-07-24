import java.util.HashMap;
import java.util.Map;
public class SameFrequencyAfterOneRemoval {
	
	public static boolean checkAllSame(HashMap<Character, Integer> hm) {
		
		int same = 0;
		
		for(Map.Entry<Character, Integer> e : hm.entrySet()) {
			int val = e.getValue();
			if(val > 0) {
				same = val;
				break;
			}
		}
		
		for(Map.Entry<Character, Integer> e : hm.entrySet()) {
			int val = e.getValue();
			if(val > 0 && val != same) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkSameFreqAfterOneRemoval(String str) {
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		if(checkAllSame(hm))
			return true;
		
		for(Map.Entry<Character, Integer> e : hm.entrySet()) {
			char key = e.getKey();
			int val = e.getValue();
			hm.put(key, val - 1);
			
			if(checkAllSame(hm))
				return true;
			
			hm.put(key, val);	
		}
		
		return false;
	}

	public static void main(String[] args) {
		String str = "xxxxyyzz";
        if (checkSameFreqAfterOneRemoval(str))
            System.out.println("Yes");
        else
            System.out.println("No");

	}

}
