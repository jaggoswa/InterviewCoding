
public class LCA {
	
	TreeNode root;
	
	TreeNode lca(TreeNode root,int n1, int n2) {
		
		if(root == null)
			return null;
		
		if(root.data > n1 && root.data > n2)
			return lca(root.left,n1,n2);
		
		if(root.data < n1 && root.data < n2)
			return lca(root.right,n1,n2);
		
		return root;
	}
	
	TreeNode insertRec(TreeNode root, int key) {
		
		if(root == null) {
			root = new TreeNode(key);
			return root;
		}
		
		if(key < root.data)
			root.left = insertRec(root.left,key);
		else if(key > root.data)
			root.right = insertRec(root.right,key);
		return root;
	}
	
	void insert(int key) {
		root = insertRec(root,key);
	}

	public static void main(String[] args) {
		LCA tree = new LCA();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(4);
		
		System.out.println("The LCA is: " + tree.lca(tree.root,10,14).data);

	}

}
