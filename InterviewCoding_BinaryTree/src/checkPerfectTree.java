
public class checkPerfectTree {
	
	TreeNode root;
	
	int findADepth(TreeNode root) {
		if(root == null)
			return -1;
		
		return 1 + findADepth(root.left);
	}
	
	boolean isPerfect(TreeNode root, int d , int level) {
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return (d == level);
		
		if(root.left == null || root.right == null)
			return false;
		
		return (isPerfect(root.left,d,level+1) && isPerfect(root.right,d,level+1));
	}

	public static void main(String[] args) {
		checkPerfectTree tree = new checkPerfectTree();
		
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(20);
		tree.root.right = new TreeNode(30);
		tree.root.left.left = new TreeNode(40);
		tree.root.left.right = new TreeNode(50);
		tree.root.right.left = new TreeNode(60);
//		tree.root.right.right = new TreeNode(70);
		
		int depth = tree.findADepth(tree.root);
		
		if(tree.isPerfect(tree.root,depth,0))
			System.out.println("The tree is perfect");
		else
			System.out.println("The tree is not perfect");

	}

}
