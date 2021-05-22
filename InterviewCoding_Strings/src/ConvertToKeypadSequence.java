/* Time Complexity  = O(n)
 * Space Complexity = O(1)*/
public class ConvertToKeypadSequence {
	
	public static void printSequence(String str, String[] arr) {
		
		String result = "";
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ' ')
				result += "0";
			else {
				int index = str.charAt(i) - 'A';
				result += arr[index];
			}	
		}
		
		System.out.print(result);
	}

	public static void main(String[] args) {
		String[] arr = {"2","22","222",
					 "3","33","333",
					 "4","44","444",
					 "5","55","555",
					 "6","66","666",
					 "7","77","777","7777",
					 "8","88","888",
					 "9","99","999","9999"};
		
		String str = "GEEKSFORGEEKS";
		printSequence(str,arr);
		
	}

}
