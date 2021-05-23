
public class Deletion {
	
	TreeNode root;
	
	void delete(int key) {
		root = deleteRec(root,key);
	}
	
	int minValue(TreeNode root) {
		int min = root.data;
		
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		return min;
	}
	
	TreeNode deleteRec(TreeNode root, int key) {
		if(root == null)
			return root;
		
		if(key < root.data)
			root.left = deleteRec(root.left,key);
		else if(key > root.data)
			root.right = deleteRec(root.right,key);
		else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			
			root.data = minValue(root.right);
			root.right = deleteRec(root.right,root.data);
		}
		return root;
	}
	
	void insert(int key) {
		root = insertRec(root,key);
	}
	
	TreeNode insertRec(TreeNode root, int key) {
		if(root == null) {
			TreeNode node = new TreeNode(key);
			return node;
		}
		
		if(key < root.data)
			root.left = insertRec(root.left,key);
		else if(key > root.data)
			root.right = insertRec(root.right,key);
		
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
		Deletion tree = new Deletion();
		
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		
		System.out.println("Inorder traversal: ");
		tree.printInorder(tree.root);
		
		tree.delete(5);
		System.out.println();
		System.out.println("Inorder traversal after deletion: ");
		tree.printInorder(tree.root);
	}

}
