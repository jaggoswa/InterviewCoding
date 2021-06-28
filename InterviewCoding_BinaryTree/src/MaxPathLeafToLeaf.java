
public class MaxPathLeafToLeaf {
	
	TreeNode root;
	int result;
	
	int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.data;
		
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		
		if(root.left != null && root.right != null) {
			result = Math.max(result, left+right+root.data);
			return Math.max(left, right) + root.data;
		}
		
		if(root.left != null)
			return left + root.data;
		else
			return right + root.data;
	}

	public static void main(String[] args) {
		MaxPathLeafToLeaf tree = new MaxPathLeafToLeaf();
		
		tree.root = new TreeNode(-15);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(-8);
        tree.root.left.right = new TreeNode(1);
        tree.root.left.left.left = new TreeNode(2);
        tree.root.left.left.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(9);
        tree.root.right.right.right = new TreeNode(0);
        tree.root.right.right.right.left = new TreeNode(4);
        tree.root.right.right.right.right = new TreeNode(-1);
        tree.root.right.right.right.right.left = new TreeNode(10);
        
        tree.result = Integer.MIN_VALUE;
        
        tree.maxPathSum(tree.root);
        
        System.out.print("Maximum path sum: " + tree.result);

	}

}
