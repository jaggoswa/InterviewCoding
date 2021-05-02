import java.util.Stack;
public class PostorderTraversalIterative {
	
	TreeNode root;
	
	void postorderTraversal() {
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		s.add(root);
		
		while(!s.isEmpty()) {
			TreeNode node = s.peek();
			
			if(root.right != null)
				s.push(root.right);
			
			if(root.left != null)
				s.push(root.left);
			
			System.out.print(node.data + " ");
			s.pop();
		}
	}

	public static void main(String[] args) {
		PostorderTraversalIterative tree = new PostorderTraversalIterative();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(2);
        tree.postorderTraversal();
	}

}
