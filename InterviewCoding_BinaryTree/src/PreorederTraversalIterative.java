import java.util.Stack;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class PreorederTraversalIterative {
	
	TreeNode root;
	
void preorderTraversal() {
		
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while(!s.isEmpty()) {
			
			TreeNode node = s.pop();
			System.out.print(node.data + " ");
			
			if(node.right != null) {
				s.push(node.right);
			}
			
			if(node.left != null) {
				s.push(node.left);
			}
		}
		
	}

	
	public static void main(String[] args) {
		
		PreorederTraversalIterative tree = new PreorederTraversalIterative();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(2);
        tree.preorderTraversal();

	}

}
