/* Time Complexity = O(n)
 * Space Complexity = O(h)
 */
public class PrintInRange {
	
	TreeNode root;
	
	public void printInRange(TreeNode root, int min, int max) {
		if(root == null)
			return;
		
		if(root.data > max)
			printInRange(root.left, min, max);
		else if(root.data < min)
			printInRange(root.right,min,max);
		else {
			printInRange(root.left,min,max);
			System.out.print(root.data + " ");
			printInRange(root.right,min,max);
		}
	}
	
	public TreeNode insert(TreeNode root, int key) {
		if(root == null)
			return new TreeNode(key);
		
		if(key < root.data)
			root.left = insert(root.left,key);
		else if(key > root.data)
			root.right = insert(root.right,key);
		
		return root;
	}

	public static void main(String[] args) {
		
		PrintInRange tree = new PrintInRange();
		int[] keys = {20,8,22,4,12};
		
		for(int key : keys) {
			tree.root = tree.insert(tree.root,key);
		}
		
		tree.printInRange(tree.root,10,25);

	}

}
