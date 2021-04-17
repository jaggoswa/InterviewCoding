
public class ConvertToSumTree {
	
	TreeNode root;
	
	int toSumTree(TreeNode root) {
		if(root == null)
			return 0;
		
		int oldVal = root.data;
		root.data = toSumTree(root.left) + toSumTree(root.right);
		
		return oldVal + root.data;
	}
	
	void printInorder(TreeNode root) {
		if(root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		
		ConvertToSumTree tree = new ConvertToSumTree();
		
		tree.root = new TreeNode(10); 
        tree.root.left = new TreeNode(-2); 
        tree.root.right = new TreeNode(6); 
        tree.root.left.left = new TreeNode(8); 
        tree.root.left.right = new TreeNode(-4); 
        tree.root.right.left = new TreeNode(7); 
        tree.root.right.right = new TreeNode(5);
        
        tree.toSumTree(tree.root);
        System.out.println("The inorder traversal of the sum tree is: ");
        tree.printInorder(tree.root);
	}

}
