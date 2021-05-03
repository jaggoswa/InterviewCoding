import java.util.Stack;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */

public class ValidBSTFromPreorder {
	
	TreeNode root;
	
	static boolean isValid(int[] preorder) {
		
		int root = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<preorder.length; i++) {
			
			while(!st.isEmpty() && preorder[i] > st.peek()) {
				root = st.peek();
				st.pop();
			}
			
			if(preorder[i] < root)
				return false;
			
			st.push(preorder[i]);
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		int[] arr1 = {2,4,3};
		int[] arr2 = {2,4,1};
		int[] arr3 = {44,22,11,33,66,55,77,88};
		int[] arr4 = {44,22,11,66,55,33,77,88};
		
		if(isValid(arr4))
			System.out.println("Valid BST can be formed");
		else
			System.out.println("Valid BST can't be formed");

	}

}
