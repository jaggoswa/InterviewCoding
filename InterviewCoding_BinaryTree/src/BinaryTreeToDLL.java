/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class BinaryTreeToDLL {
	TreeNode root;
	TreeNode head;
	TreeNode prev = null;
	
	void toDLL(TreeNode node) {
		if(node == null)
			return;
		
		toDLL(node.left);
		
		if(prev == null)
			head = node;
		else {
			node.left = prev;
			prev.right = node;
		}
		
		prev = node;
		toDLL(node.right);
	}
	
	void printDLL(TreeNode head) {
		TreeNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(36);
        
        tree.toDLL(tree.root);
        tree.printDLL(tree.head);
	}

}
