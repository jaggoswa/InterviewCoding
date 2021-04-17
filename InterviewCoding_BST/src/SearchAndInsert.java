
public class SearchAndInsert {
	
	TreeNode root;
	
	TreeNode find(TreeNode root,int k) {
		if(root == null || root.data == k)
			return root;
		
		if(k < root.data)
			return find(root.left,k);

		return find(root.right,k);
	}
	
	TreeNode insertRec(TreeNode root, int k) {
		if(root == null) {
			root = new TreeNode(k);
			return root;
		}
		
		if(k < root.data)
			root.left = insertRec(root.left,k);
		else if(k > root.data)
			root.right = insertRec(root.right,k);
		
		return root;
	}
	
	void insert(int k) {
		root = insertRec(root,k);
	}
	
	void printInorder(TreeNode root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	public static void main(String[] args) {
		SearchAndInsert tree = new SearchAndInsert();
		
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);

		System.out.println("Inorder traversal of the BST ");
		tree.printInorder(tree.root);
	}

}
