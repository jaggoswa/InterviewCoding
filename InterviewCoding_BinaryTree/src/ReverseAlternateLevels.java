
public class ReverseAlternateLevels {
	
	TreeNode root;
	
	void preorder(TreeNode root1, TreeNode root2, int level) {
		if(root1 == null || root2 == null)
			return;
		
		if(level%2 != 0) {
			int temp = root1.data;
			root1.data = root2.data;
			root2.data = temp;
		}
		
		preorder(root1.left,root2.right,level+1);
		preorder(root1.right,root2.left,level+1);
	}
	
	void reverseAlternateLevel(TreeNode root) {
		preorder(root.left, root.right, 1);
	}
	
	void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		
		ReverseAlternateLevels tree = new ReverseAlternateLevels();
		
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.left = new TreeNode(6); 
        tree.root.right.right = new TreeNode(7); 
        tree.root.left.left.left = new TreeNode(8); 
        tree.root.left.left.right = new TreeNode(9); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(11); 
        tree.root.right.left.left = new TreeNode(12); 
        tree.root.right.left.right = new TreeNode(13); 
        tree.root.right.right.left = new TreeNode(14); 
        tree.root.right.right.right = new TreeNode(15); 
        
        System.out.println("Inorder traversal of original tree");
        tree.inorder(tree.root);
        
        tree.reverseAlternateLevel(tree.root);
        
        System.out.println();
        System.out.println("Inorder traversal of modified tree");
        tree.inorder(tree.root);

	}

}
