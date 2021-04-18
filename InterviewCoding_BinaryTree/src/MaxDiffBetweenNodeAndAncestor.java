
/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class MaxDiffBetweenNodeAndAncestor {
	
	TreeNode root;
	
	int maxDiff = 0;
	
	void maxDifference(TreeNode root, int currMax, int currMin) {
		
		if(root == null)
			return;
		
		int temp = Math.max(Math.abs(currMax - root.data), Math.abs(root.data - currMin));
		maxDiff = Math.max(maxDiff, temp);
		currMax = Math.max(currMax, root.data);
		currMin = Math.min(currMin, root.data);
		
		maxDifference(root.left,currMax,currMin);
		maxDifference(root.right,currMax,currMin);
	}

	public static void main(String[] args) {
		
		MaxDiffBetweenNodeAndAncestor tree =
			new	MaxDiffBetweenNodeAndAncestor();
		
		tree.root = new TreeNode(8);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(7);
		tree.root.right.right = new TreeNode(14);
		tree.root.right.right.left = new TreeNode(13);
		
		tree.maxDifference(tree.root,tree.root.data,tree.root.data);
		
		System.out.println("The maximum difference is: " + tree.maxDiff);
		
	}

}
