
public class BinaryTreeHeight {
	
	TreeNode root;
	
	int printMaxHeight(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(printMaxHeight(node.left),printMaxHeight(node.right));
	}
	
	int printMinHeight(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.min(printMaxHeight(node.left),printMaxHeight(node.right));
	}

	public static void main(String[] args) {
		BinaryTreeHeight tree = new BinaryTreeHeight();
		
		tree.root = new TreeNode(15);
//        tree.root.left = new TreeNode(10);
//        tree.root.right = new TreeNode(20);
//        tree.root.left.left = new TreeNode(8);
//        tree.root.left.right = new TreeNode(12);
//        tree.root.right.left = new TreeNode(16);
//        tree.root.right.right = new TreeNode(25);
//        tree.root.right.left.left = new TreeNode(30);
        
        System.out.println("The max height of the tree is: " + tree.printMaxHeight(tree.root));
        System.out.println("The min height of the tree is: " + tree.printMinHeight(tree.root));

	}

}
