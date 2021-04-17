
public class NodeAncestorMaxDifference {
	
	TreeNode root;
	
	int maxDifference(TreeNode root, int currMax, int currMin) {
		
		if(root == null)
			return currMax - currMin;
		
		currMax = Math.max(currMax, root.data);
		currMin = Math.min(currMin, root.data);
		int left = maxDifference(root.left,currMax,currMin);
		int right = maxDifference(root.right,currMax,currMin);
		
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NodeAncestorMaxDifference tree = new NodeAncestorMaxDifference();
		
		tree.root = new TreeNode(8);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(7);
		tree.root.right.right = new TreeNode(14);
		tree.root.right.right.left = new TreeNode(13);
		
		System.out.print("The max difference between a node and ancestor is: " 
						+ tree.maxDifference((tree.root),tree.root.data,tree.root.data));

	}

}
