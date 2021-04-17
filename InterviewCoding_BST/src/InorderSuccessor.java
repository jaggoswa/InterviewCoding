
public class InorderSuccessor {
	
	TreeNode root;
	
	TreeNode findMinimum(TreeNode root) {
		while(root.left != null)
			root = root.left;
		return root;
	}
	
	TreeNode findSuccessor(TreeNode root,TreeNode succ,int key) {
		if(root == null)
			return null;
		
		if(root.data == key) {
			if(root.right != null)
				return findMinimum(root.right);
		}
		else if(key < root.data) {
			succ = root;
			return findSuccessor(root.left,succ,key);
		}
		else
			return findSuccessor(root.right,succ,key);
		
		return succ;
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
		
		InorderSuccessor tree = new InorderSuccessor();
		int[] keys = {15, 10, 20, 8, 12, 16, 25};
		
		for(int key : keys) {
			tree.insert(key);
		}
		
		for(int key : keys) {
			TreeNode succ = tree.findSuccessor(tree.root,null,key);
			
			if(succ != null)
				System.out.println("The successor of " + key + " is: " + succ.data);
			else
				System.out.println("The successor doesn't exist for " + key);
		}

	}

}
