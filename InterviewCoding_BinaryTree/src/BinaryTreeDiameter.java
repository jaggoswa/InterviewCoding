/* Time Complexity = O(n), since we are traversing each node only once 
 * and work done at each node is constant
 * Space complexity = O(n)
 */
public class BinaryTreeDiameter {
	
	TreeNode root;
	int diameter;
	
	int findDiameter(TreeNode root) {
		
		if(root == null)
			return 0;
		
		int left = findDiameter(root.left);
		int right = findDiameter(root.right);
		
		diameter = Math.max(diameter, left+right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		BinaryTreeDiameter tree = new BinaryTreeDiameter();
		tree.diameter = 0;
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		tree.findDiameter(tree.root);
		
		System.out.print(tree.diameter);

	}

}
