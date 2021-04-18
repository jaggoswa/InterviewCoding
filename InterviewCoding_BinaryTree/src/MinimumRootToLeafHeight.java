/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class MinimumRootToLeafHeight {
	
	TreeNode root;
	
	int minHeight(TreeNode root) {
		
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int minHeight = Integer.MAX_VALUE;
		
		if(root.left != null)
			minHeight = Math.min(minHeight(root.left),minHeight);
		
		if(root.right != null)
			minHeight = Math.min(minHeight(root.right),minHeight);
		
		return minHeight + 1;
		
	}

	public static void main(String[] args) {
		
		MinimumRootToLeafHeight tree = new MinimumRootToLeafHeight();
		
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        
        System.out.print("The minimum height is: " + tree.minHeight(tree.root));

	}

}
