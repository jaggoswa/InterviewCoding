/* Time Complexity = O(n)
 *  Space Complexity = O(n)
 */
public class RemoveNodesRToLLengthLessThanK {
	
	TreeNode root;
	
	TreeNode removeNodes(TreeNode root, int level, int k) {
		if(root == null)
			return null;
		
		root.left = removeNodes(root.left,level+1,k);
		root.right = removeNodes(root.right,level+1,k);
		
		if(root.left == null &&  root.right == null && level < k)
			return null;
		
		return root;
	}
	
	void printInorder(TreeNode root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	public static void main(String[] args) {
		RemoveNodesRToLLengthLessThanK tree = new RemoveNodesRToLLengthLessThanK();
		int k = 4; 
		int level = 1;
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.left.left.left = new TreeNode(7); 
        tree.root.right.right = new TreeNode(6); 
        tree.root.right.right.left = new TreeNode(8); 
        
        System.out.println("The inorder traversal of original tree is : "); 
        tree.printInorder(tree.root); 
        TreeNode res = tree.removeNodes(tree.root,level,k); 
        System.out.println(""); 
        System.out.println("The inorder traversal of modified tree is : "); 
        tree.printInorder(res); 

	}

}
