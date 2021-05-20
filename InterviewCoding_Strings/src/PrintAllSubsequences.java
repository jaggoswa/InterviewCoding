/* Time Complexity = O(2^n)
 * Space Complexity = O(n^2)
 */
public class PrintAllSubsequences {
	
	static void printSS(String s, String ans) {
		if(s.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		printSS(s.substring(1), ans + s.charAt(0));
		printSS(s.substring(1), ans);
	}

	public static void main(String[] args) {
		String str = "abcd";
		printSS(str,"");

	}

}
