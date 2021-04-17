import java.util.Stack;

public class InorderTraversalIterative {
	
	TreeNode root;
	
	void inorderTraversal() {
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		
		while(curr != null || s.size() > 0) {
			
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			
			curr = s.pop();
			
			System.out.print(curr.data + " ");
			
			curr = curr.right;
		}
	}

	public static void main(String[] args) {
		
		InorderTraversalIterative tree = new InorderTraversalIterative();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.inorderTraversal();

	}

}
