
public class MinDistanceBetweenNodes {

	TreeNode root;
	
	TreeNode LCA(TreeNode root, int a, int b) {
		if(root == null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		TreeNode left = LCA(root.left,a,b);
		TreeNode right = LCA(root.right,a,b);
		
		if(left == null && right == null)
			return null;
		
		if(left != null && right != null)
			return root;
		
		if(left != null)
			return left;
		else
			return right;
	}
	
	int findLevel(TreeNode root, int node, int level) {
		if(root == null)
			return -1;
		
		if(root.data == node)
			return level;
		
		int left = findLevel(root.left,node,level+1);
		
		if(left == -1)
			return findLevel(root.right,node,level+1);
		
		return left;
	}
	
	int findDistance(TreeNode root, int a, int b) {
		TreeNode lca = LCA(root,a,b);
		return findLevel(lca,a,0) + findLevel(lca,b,0);
	}
	
	public static void main(String[] args) {
		MinDistanceBetweenNodes tree = new MinDistanceBetweenNodes();
		
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);
        System.out.println("Dist(4, 5) = "
                             + tree.findDistance(tree.root, 4, 5));
                              
        System.out.println("Dist(4, 6) = "
                             + tree.findDistance(tree.root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + tree.findDistance(tree.root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + tree.findDistance(tree.root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + tree.findDistance(tree.root, 8, 5));

	}

}
