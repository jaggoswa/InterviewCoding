
public class MinMax {
	
	TreeNode root;
	
	int findMinimum(TreeNode root) {
		if(root == null)
			return Integer.MAX_VALUE;
		
		int left = findMinimum(root.left);
		int right = findMinimum(root.right);
		
		return Math.min(Math.min(left, root.data), right);
			
	}
	
	int findMaximum(TreeNode root) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		int left = findMaximum(root.left);
		int right = findMaximum(root.right);
		
		return Math.max(Math.max(left, root.data), right);
			
	}
	
	TreeNode insertRec(TreeNode root, int key) {
		if(root == null) {
			TreeNode node = new TreeNode(key);
			return node;
		}
		
		if(key < root.data) {
			root.left = insertRec(root.left,key);
		}
		else if(key > root.data) {
			root.right = insertRec(root.right,key);
		}
		
		return root;
	}
	
	void insert(int key) {
		root = insertRec(root,key);
	}

	public static void main(String[] args) {
		
		MinMax tree = new MinMax();
		
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		
		System.out.println("Minimum element: " + tree.findMinimum(tree.root));
		System.out.println("Maximum element: " + tree.findMaximum(tree.root));
		
	}

}
