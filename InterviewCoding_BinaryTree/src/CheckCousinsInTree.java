/* Time Complexity = O(n)
 * Space complexity = O(n)*/

public class CheckCousinsInTree {
	
TreeNode root;

	boolean isCousin(TreeNode node1, TreeNode node2) {
		return (getLevel(root,node1,1) == getLevel(root,node2,1) 
				&& !isSibling(root,node1,node2));
	}
	
	int getLevel(TreeNode root,TreeNode node,int level) {
		if(root == null)
			return 0;
		
		if(root == node)
			return level;
		
		int l = getLevel(root.left,node,level+1);
		
		if(l!=0)
			return l;
		
		return getLevel(root.right,node,level+1);
	}
	
	boolean isSibling(TreeNode root,TreeNode node1,TreeNode node2) {
		if(root == null)
			return false;
		
		return ((root.left == node1 && root.right == node2) || (root.left == node2 && root.right == node1)
				|| isSibling(root.left,node1,node2) || isSibling(root.right,node1,node2));
					
	}
	
	public static void main(String[] args) {
		
		CheckCousinsInTree tree = new CheckCousinsInTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4); 
		tree.root.left.right = new TreeNode(5); 
		tree.root.left.right.right = new TreeNode(15); 
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.left.right = new TreeNode(8);
	 
	    TreeNode data_one = tree.root.left.left;
	    TreeNode data_two = tree.root.right.right;
	 
	    if (tree.isCousin(data_one,data_two))
	        System.out.print("YES");
	    else
	        System.out.print("NO");
	}

}
