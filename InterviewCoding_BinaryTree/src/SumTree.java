
/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class SumTree {
	
	TreeNode root;
	
	boolean isLeaf(TreeNode node) {
		
		if(node.left == null && node.right == null)
			return true;
		
		return false;
		
	}
	
	boolean isSumTree(TreeNode root) {
		
		int ls = 0;
		int rs = 0;
		
		if(root == null || isLeaf(root))
			return true;
		
		if(isSumTree(root.left) && isSumTree(root.right)) {
			if(root.left == null)
				ls = 0;
			else if(isLeaf(root.left))
				ls = root.left.data;
			else
				ls = 2*root.left.data;
			
			if(root.right == null)
				rs = 0;
			else if(isLeaf(root.right))
				rs = root.right.data;
			else
				rs = 2*root.right.data;
			
			if(ls + rs == root.data)
				return true;
			else
				return false;
				
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		SumTree tree = new SumTree();
		
		tree.root = new TreeNode(44);
		tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(13);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
		
		
//		tree.root = new TreeNode(0);
//		tree.root.left = new TreeNode(73);
//		tree.root.right = new TreeNode(99);
//		tree.root.left.left = new TreeNode(42);
//		tree.root.left.right = new TreeNode(45);
//		tree.root.right.left = new TreeNode(38);
//		tree.root.right.right = new TreeNode(41);
		
        boolean res = tree.isSumTree(tree.root);
        
        if(res)
        	System.out.print("It is a sum tree");
        else
        	System.out.println("It is not a sum tree");

	}

}
