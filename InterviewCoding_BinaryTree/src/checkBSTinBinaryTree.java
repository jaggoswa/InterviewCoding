
public class checkBSTinBinaryTree {
	
	TreeNode root;
	int prev = Integer.MIN_VALUE;
	
	boolean isBST(TreeNode root) {
		if(root == null)
			return true;
		
		if(!isBST(root.left))
			return false;
		
		if(root.data <= prev)
			return false;
		
		prev = root.data;
		
		return isBST(root.right);
	}

	public static void main(String[] args) {
		checkBSTinBinaryTree tree = new checkBSTinBinaryTree();
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(4);
		
		if(tree.isBST(tree.root))
			System.out.println("The tree is a BST");
		else
			System.out.println("The tree is not a BST");

	}

}
