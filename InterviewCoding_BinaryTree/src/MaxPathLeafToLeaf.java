
public class MaxPathLeafToLeaf {
	
	TreeNode root;
	int result;
	
	int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		
		int temp = Math.max(left, right) + root.data;
		
		//The current node can be the starting point of a max path only when it is a leaf node 
		if(root.left == null && root.right == null)
			temp = Math.max(temp, root.data);
		
		int ans = Math.max(left+right+root.data, temp);
		result = Math.max(ans, result);
		
		return temp;
		
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
