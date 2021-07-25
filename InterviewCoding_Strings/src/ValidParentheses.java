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
				//If closing bracket and the stack is empty i.e more closing brackets
				if(leftChars.isEmpty())
					return false;
				
				//If closing bracket doesn't match the top of the stack i.e mismatched brackets
				if(exp.charAt(i) == ')' && leftChars.peek() != '(' ||
				   exp.charAt(i) == ']' && leftChars.peek() != '[' ||
				   exp.charAt(i) == '}' && leftChars.peek() != '{') {
					
					return false;
				}
				
				leftChars.pop();	
			}
		}
		
		return leftChars.isEmpty(); //If characters left in stack return false i.e more opening brackets
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
