
public class checkSubtree {
	
	TreeNode root;
	TreeNode subRoot;
	
	boolean equals(TreeNode x, TreeNode y) {
		if(x == null && y == null)
			return true;
		
		if(x == null || y == null)
			return false;
		
		return((x.data == y.data) && equals(x.left,y.left) && equals(x.right,y.right));
	}
	
	boolean hasSubtree(TreeNode root, TreeNode subRoot) {
		return ((root != null) && (equals(root,subRoot) 
				|| hasSubtree(root.left,subRoot)
				|| hasSubtree(root.right,subRoot)));
	}
	
	public static void main(String[] args) {
		checkSubtree tree = new checkSubtree();
		
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(2);
//		tree.root.left.right.left = new TreeNode(0);
		
		tree.subRoot = new TreeNode(4);
		tree.subRoot.left = new TreeNode(1);
		tree.subRoot.right = new TreeNode(2);
		
		if(tree.hasSubtree(tree.root,tree.subRoot))
			System.out.println("Subtree found");
		else
			System.out.println("Subtree not found");

	}

}
