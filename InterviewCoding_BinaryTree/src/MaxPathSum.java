
public class MaxPathSum {
	
	TreeNode root;
	int result;
	
	int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		
		/* The current node is in the path of max sum,
		 * the current node may be extending a max sum 
		 * path or be the starting point of a max sum path
		 * */
		int temp = Math.max(Math.max(left, right) + root.data, root.data);
		
		//Current node is the root of max sum path
		int ans = Math.max(left+right+root.data, temp);
		
		//Update the maximum path found so far
		result = Math.max(result, ans);
		
		return temp;
	}
	
	public static void main(String[] args) {
		
		MaxPathSum tree = new MaxPathSum();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.left.left = new TreeNode(100);
		tree.root.left.left.right = new TreeNode(100);
		
		tree.result = Integer.MIN_VALUE;
		
		tree.maxPathSum(tree.root);
		
		System.out.print("The maximum path sum is: " + tree.result);

	}

}
