
/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class SumTree {
	
	TreeNode root;
	
	int isSumTree(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.data;
		
		if(root.data == isSumTree(root.left) + isSumTree(root.right)) {
			/* Since we are adding the value of current node 
			 * and sum of all the nodes below it which adds up to current nodes value */
			return root.data * 2;
		}
		
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		
		SumTree tree = new SumTree();
		
//		tree.root = new TreeNode(44);
//		tree.root.left = new TreeNode(9);
//        tree.root.right = new TreeNode(13);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.left.right = new TreeNode(5);
//        tree.root.right.left = new TreeNode(6);
//        tree.root.right.right = new TreeNode(7);
		
		
		tree.root = new TreeNode(0);
		tree.root.left = new TreeNode(73);
		tree.root.right = new TreeNode(99);
		tree.root.left.left = new TreeNode(42);
		tree.root.left.right = new TreeNode(45);
		tree.root.right.left = new TreeNode(38);
		tree.root.right.right = new TreeNode(41);
		
        int res = tree.isSumTree(tree.root);
        
        if(res != Integer.MIN_VALUE)
        	System.out.print("It is a sum tree");
        else
        	System.out.println("It is not a sum tree");

	}

}
