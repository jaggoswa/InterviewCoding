import java.util.Stack;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class ValidParentheses {
	
	public static boolean isValid(String exp) {
		Stack<Character> leftChars = new Stack<>();
		
		for(int i=0; i<exp.length(); i++) {
			if(exp.charAt(i) == '(' || 
			   exp.charAt(i) == '[' || 
			   exp.charAt(i) == '{') {
				
				leftChars.push(exp.charAt(i));
			}else {
				if(leftChars.isEmpty())
					return false;
				
				if(exp.charAt(i) == ')' && leftChars.peek() != '(' ||
				   exp.charAt(i) == ']' && leftChars.peek() != '[' ||
				   exp.charAt(i) == '}' && leftChars.peek() != '{') {
					
					return false;
				}
				
				leftChars.pop();	
			}
		}
		
		return leftChars.isEmpty();
	}

	public static void main(String[] args) {
		//String expression = "{[]}";
		String expression = "([)]";
		
		if(isValid(expression))
			System.out.print("Valid Parentheses");
		else
			System.out.print("Invalid parentheses");

	}

}
