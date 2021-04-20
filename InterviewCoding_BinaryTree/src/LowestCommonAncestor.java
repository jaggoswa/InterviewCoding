
/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class LowestCommonAncestor {
	
	TreeNode root;
	
	TreeNode findLCA(TreeNode root, int a, int b) {
		
		if(root == null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		TreeNode left = findLCA(root.left,a,b);
		TreeNode right = findLCA(root.right,a,b);
		
		if(left == null && right == null)
			return null;
		
		if(left != null && right != null)
			return root;
		
		if(left != null)
			return left;
		else
			return right;
		
	}

	public static void main(String[] args) {
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
        
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        
        System.out.println("LCA(4, 5) = " + tree.findLCA(tree.root,4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(tree.root,4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(tree.root,3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(tree.root,2, 4).data);
	}

}
