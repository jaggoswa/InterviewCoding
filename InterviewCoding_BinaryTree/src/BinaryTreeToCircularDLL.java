/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class BinaryTreeToCircularDLL {
	
	TreeNode root;
	static TreeNode first;
	static TreeNode last = null;
	
	void toCircularDLL(TreeNode node) {
		
		if(node == null)
			return;
		
		toCircularDLL(node.left);
		
		if(last == null) {
			first = node;
		}else {
			node.left = last;
			last.right = node;
		}
		
		last = node;
		
		toCircularDLL(node.right);
	}
	
	void printCircularDLL() {
		
		System.out.println("Circular Linked List is: ");
		
		TreeNode temp = first;
		
		do {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}while(temp != first);
	}

	public static void main(String[] args) {
		
		BinaryTreeToCircularDLL tree = new BinaryTreeToCircularDLL();
		
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);
		
		tree.toCircularDLL(tree.root);
		
		last.right = first;
		first.left = last;
		
		tree.printCircularDLL();

	}

}
