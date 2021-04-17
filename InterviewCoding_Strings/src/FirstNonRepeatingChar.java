import java.util.HashMap;

public class FirstNonRepeatingChar {
	
	static int firstNonRepeating(String str) {
		
		char[] arr = str.toCharArray();
		HashMap<Character,Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				int count = hm.get(arr[i]);
				hm.put(arr[i], count+1);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		

		for(int i=0; i<arr.length; i++) {
			if(hm.get(arr[i]) == 1)
				return i;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String str = "GeeksForGeeks";
		
		int idx = firstNonRepeating(str);
		
		if(idx == -1)
			System.out.println("No non-repeating characters present");
		else
			System.out.print(str.charAt(idx));

	}

}
