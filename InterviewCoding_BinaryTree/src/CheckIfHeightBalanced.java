
public class CheckIfHeightBalanced {
	
	TreeNode root;
	
	int height(TreeNode root) {
		if(root == null)
			return -1;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	boolean isHeightBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return ((Math.abs(lh-rh) <= 1) 
				&& isHeightBalanced(root.left) 
				&& isHeightBalanced(root.right));
		
	}

	public static void main(String[] args) {
		
		CheckIfHeightBalanced tree = new CheckIfHeightBalanced();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
//        tree.root.right.right = new TreeNode(6); 
        tree.root.left.left.left = new TreeNode(7); 
        
        if(tree.isHeightBalanced(tree.root))
        	System.out.println("The tree is height balanced ");
        else
        	System.out.println("The tree is not height balanced");
		
	}

}
