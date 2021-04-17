
public class CountLeavesInTree {
	
	TreeNode root;
	
	int countLeaves(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		else
			return countLeaves(root.left) + countLeaves(root.right);
	}

	public static void main(String[] args) {
		
		CountLeavesInTree tree = new CountLeavesInTree();
		
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        
        System.out.print("The number of leaf nodes in the tree is: " + tree.countLeaves(tree.root));
		
	}

}
