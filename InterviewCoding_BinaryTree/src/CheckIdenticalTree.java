/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class CheckIdenticalTree {
	
	TreeNode root;
	
	boolean isIdentical(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return ((root1.data == root2.data) 
				&& isIdentical(root1.left,root2.left) 
				&& isIdentical(root1.right,root2.right));
	}

	public static void main(String[] args) {
		
		CheckIdenticalTree tree1 = new CheckIdenticalTree();
		CheckIdenticalTree tree2 = new CheckIdenticalTree();
		
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);
		
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);
		
		if(tree1.isIdentical(tree1.root,tree2.root))
			System.out.println("The trees are identical");
		else
			System.out.println("The trees are not identical");
	}

}
