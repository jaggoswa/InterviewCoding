/* Time Complexity = O(N)
 * Space Complexity = O(1)
 */
public class SplitZeroesOnes {
	
	static int countMaxSubstr(String str) {
		
		int zeroCount = 0;
		int oneCount = 0;
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0') {
				zeroCount++;
			}
			else {
				oneCount++;
			}
			
			if(zeroCount == oneCount)
				count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		String str = "0100110101";
		System.out.print(countMaxSubstr(str));
	}

}
