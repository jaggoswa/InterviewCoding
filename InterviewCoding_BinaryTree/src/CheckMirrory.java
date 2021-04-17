
public class CheckMirrory {
	
	TreeNode root;
	
	boolean isMirror(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return ((root1.data == root2.data) && isMirror(root1.left,root2.right) 
				&& isMirror(root1.right, root2.left));
	}

	public static void main(String[] args) {
		CheckMirrory tree1 = new CheckMirrory();
		CheckMirrory tree2 = new CheckMirrory();
		
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(3);
		tree1.root.right = new TreeNode(2);
		tree1.root.right.left = new TreeNode(5);
		tree1.root.right.right = new TreeNode(4);
		
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);
		tree2.root.left.left = new TreeNode(4);
		tree2.root.left.right = new TreeNode(5);
		
		if(tree1.isMirror(tree1.root,tree2.root))
			System.out.println("The two trees are mirror images of each other");
		else
			System.out.println("The two trees are not mirror images of each other");

	}

}
