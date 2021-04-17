public class MorrisTraversal {
	
	TreeNode root;
	
	void printInorder(TreeNode root) {
		TreeNode curr = root;
		
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			else {
				TreeNode p = curr.left;
				while(p.right != null && p.right != curr) {
					p = p.right;
				}
				
				if(p.right == null) {
					p.right = curr;
					curr = curr.left;
				}
				else{
					p.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		MorrisTraversal tree = new MorrisTraversal();
		
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(30);
		tree.root.left.left = new TreeNode(-2);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.right = new TreeNode(40);
		tree.root.left.left.right = new TreeNode(2);
		tree.root.left.right.right = new TreeNode(8);
		tree.root.left.left.right.left = new TreeNode(-1);
		
		tree.printInorder(tree.root);
	}

}
