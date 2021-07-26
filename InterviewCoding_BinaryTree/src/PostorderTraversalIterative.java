import java.util.Stack;

/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class PostorderTraversalIterative {
	
	TreeNode root;
	
	void postorderTraversal() {
		
		if(root == null)
			return;
			
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
	
		while(curr != null || !s.isEmpty()) {
			if(curr != null) {
				s.push(curr);
				curr = curr.left;
			}else {
				TreeNode temp = s.peek().right;
				
				if(temp == null) {
					temp = s.pop();
					System.out.print(temp.data + " ");
					
					while(!s.isEmpty() && temp == s.peek().right) {
						temp = s.pop();
						System.out.print(temp.data + " ");
					}
				}else {
					curr = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PostorderTraversalIterative tree = new PostorderTraversalIterative();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(-6);
        tree.root.right = new TreeNode(15);
        tree.root.left.right = new TreeNode(8);
        tree.postorderTraversal();
	}

}
