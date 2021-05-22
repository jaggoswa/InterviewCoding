/* Problem Statement: */

/* Time Complexity = O(mn) in worst case, O(m+n) in average case
 * Space Complexity = O(1)*/
public class RabinKarpAlgorithm {
	
	static int prime = 101;
	
	public static void patternSearch(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		
		long patternHash = createHash(pattern,m-1);
		long textHash = createHash(text,m-1);
		
		boolean patternFound = false;
		
		for(int i=1; i<=n-m+1; i++) {
			if(patternHash == textHash && checkEqual(text,i-1,i+m-2,pattern,0,m-1)) {
				patternFound = true;
				System.out.println("Pattern found at index: " + (i-1));
			}
			if(i < n-m+1) {
				textHash = recalculateHash(text,i-1,i+m-1,textHash,m);
			}
		}
		
		if(!patternFound)
			System.out.print("Pattern not found");
	}
	
	private static long createHash(String str,int end) {
		long hash = 0;
		for(int i=0; i<=end; i++) {
			hash += str.charAt(i) * Math.pow(prime,i);
		}
		return hash;
	}
	
	private static boolean checkEqual(String text, int start1, int end1, 
									  String pattern, int start2, int end2) {
		
		while(start1 <= end1 && start2 <= end2) {
			if(text.charAt(start1) != pattern.charAt(start2))
				return false;
			
			start1++;
			start2++;
		}
		
		return true;
	}
	
	private static long recalculateHash(String text, int oldIndex, int newIndex, 
			  						   long oldHash, int patternLen) {
		
		long newHash = oldHash - text.charAt(oldIndex);
		newHash = newHash/prime;
		newHash += text.charAt(newIndex) * Math.pow(prime,patternLen-1);
		
		return newHash;
	}

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		
		patternSearch(txt,pat);

	}

}
