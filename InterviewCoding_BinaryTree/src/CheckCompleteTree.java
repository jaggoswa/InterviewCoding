
public class CheckCompleteTree {
	
	TreeNode root;
	
	int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	boolean isComplete(TreeNode root, int index, int noOfNodes) {
		if(root == null)
			return true;
		
		if(index >= noOfNodes)
			return false;
		
		return (isComplete(root.left,2*index+1,noOfNodes)
				&& isComplete(root.right,2*index+2,noOfNodes));
	}

	public static void main(String[] args) {
		CheckCompleteTree tree = new CheckCompleteTree();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
//		tree.root.right.right = new TreeNode(6);
		
		int n = tree.countNodes(tree.root);
		
		if(tree.isComplete(tree.root,0,n))
			System.out.println("The tree is complete");
		else
			System.out.println("The tree is not complete");

	}

}
