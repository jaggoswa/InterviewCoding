
public class ConvertToMirrorTree {
	
	TreeNode root;
	
	
	TreeNode mirrorify(TreeNode root) {
		if(root == null)
			return null;
		
		TreeNode left = mirrorify(root.left);
		TreeNode right = mirrorify(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	void printInorder(TreeNode root) {
		
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		
		ConvertToMirrorTree tree = new ConvertToMirrorTree();
		
		tree.root = new TreeNode(5); 
	    tree.root.left = new TreeNode(3); 
	    tree.root.right = new TreeNode(6); 
	    tree.root.left.left = new TreeNode(2); 
	    tree.root.left.right = new TreeNode(4); 
	    
	    tree.mirrorify(tree.root);
	    System.out.println("The mirror tree is: ");
	    tree.printInorder(tree.root);

	}

}
