/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class RemoveNodesOutsideRange {
	
	TreeNode root;
	
	public TreeNode removeNodes(TreeNode root, int min, int max) {
		if(root == null)
			return null;
		
		root.left = removeNodes(root.left,min,max);
		root.right = removeNodes(root.right,min,max);
		
		if(root.data < min)
			return root.right;
		if(root.data > max)
			return root.left;
		
		return root;
	}
	
	public TreeNode insert(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		
		if(val < root.data)
			root.left = insert(root.left,val);
		else if(val > root.data)
			root.right = insert(root.right,val);
		
		return root;
	}
	
	public void printInorder(TreeNode root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		
		RemoveNodesOutsideRange tree = new RemoveNodesOutsideRange();
		
		int[] keys = {6,-13,14,-8,15,13,7};
		
		for(int key : keys) {
			tree.root = tree.insert(tree.root, key);
		}
		
		System.out.print("Inorder traversal of given tree: ");
		tree.printInorder(tree.root);
		System.out.println();
		
		int min = -10;
		int max = 13;
		
		tree.root = tree.removeNodes(tree.root,min,max);
		System.out.print("Inorder traversal of modified tree: ");
		tree.printInorder(tree.root);
		
	}

}
