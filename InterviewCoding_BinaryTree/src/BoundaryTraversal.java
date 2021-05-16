/*Time Complexity - O(n)
 * Space Complexity - O(n)*/
public class BoundaryTraversal {
	
	TreeNode root;
	
	void printLeftBoundary(TreeNode node) {
		if(node == null)
			return;
		
		if(node.left != null) {
			System.out.print(node.data +" ");
			printLeftBoundary(node.left);
		}
		else if(node.right != null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.right);
		}
	}
	
	void printRightBoundary(TreeNode node) {
		if(node == null)
			return;
		
		if(node.right != null) {
			printRightBoundary(node.right);
			System.out.print(node.data +" ");
		}
		else if(node.left != null) {
			printRightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}
	
	void printLeaves(TreeNode node) {
		if(node == null)
			return;
		
		printLeaves(node.left);
		
		if(node.left == null && node.right == null)
			System.out.print(node.data + " ");
		
		printLeaves(node.right);
	}
	
	void printBoundary() {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
//		printLeaves(node.left);
		printLeaves(root);
		printRightBoundary(root.right);
		
	}
	
	public static void main(String[] args) {
		BoundaryTraversal tree = new BoundaryTraversal();
		
		tree.root = new TreeNode(20); 
        tree.root.left = new TreeNode(8); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(12); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(14); 
        tree.root.right = new TreeNode(22); 
        tree.root.right.right = new TreeNode(25); 
        tree.printBoundary(); 

	}

}
