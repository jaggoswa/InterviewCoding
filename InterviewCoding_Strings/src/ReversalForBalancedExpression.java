/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class ReversalForBalancedExpression {
	
	public static int countReversals(String exp) {
		
		//If the expression has odd length it cannot be balanced
		if(exp.length() % 2 != 0)
			return -1;
		
		int invCount = 0;
		int openCount = 0;
		
		for(int i=0; i<exp.length(); i++) {
			// if the current character is an opening brace
			if(exp.charAt(i) == '{') {
				openCount++;
			}
			// if the current character is a closing brace
			else {
				// if an opening brace is found before, close it
				if(openCount != 0) {
					openCount--;
				}
				// invert the closing brace, i.e., change `}` to `{`
				else {
					invCount++;
					openCount = 1;
				}
			}
		}
		
		// for `n` opened braces, exactly `n/2` inversions are needed
		return invCount + openCount / 2;
	}

	public static void main(String[] args) {
		String expr = "{{}{{}{{";
		System.out.println(countReversals(expr));

	}

}
