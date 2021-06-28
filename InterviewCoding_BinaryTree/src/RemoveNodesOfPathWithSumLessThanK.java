
public class RemoveNodesOfPathWithSumLessThanK {
	
	TreeNode root;
	
	TreeNode removeNodes(TreeNode root, int sum) {
		
		if(root == null)
			return null;
		
		sum -= root.data;
		root.left = removeNodes(root.left,sum);
		root.right = removeNodes(root.right,sum);
		
		if(root.left == null && root.right == null && sum > root.data)
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
		
		RemoveNodesOfPathWithSumLessThanK tree = new RemoveNodesOfPathWithSumLessThanK();
		  
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(12);
        tree.root.right.right.left = new TreeNode(10);
        tree.root.right.right.left.right = new TreeNode(11);
        tree.root.left.left.right.left = new TreeNode(13);
        tree.root.left.left.right.right = new TreeNode(14);
        tree.root.left.left.right.right.left = new TreeNode(15);
  
        System.out.println("The inorder traversal of original tree is : "); 
        tree.printInorder(tree.root); 
        TreeNode res = tree.removeNodes(tree.root,45); 
        System.out.println(""); 
        System.out.println("The inorder traversal of modified tree is : "); 
        tree.printInorder(res); 
		
	}

}
