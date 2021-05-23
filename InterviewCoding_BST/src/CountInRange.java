/* Time Complexity = O(n)
 * Space Complexity = O(h)
 */
public class CountInRange {

	TreeNode root;
	
	public int countInRange(TreeNode root, int min, int max) {
		if(root == null)
			return 0;
		
		if(root.data > max)
			return countInRange(root.left, min, max);
		else if(root.data < min)
			return countInRange(root.right,min,max);
		else {
			return 1 + countInRange(root.left,min,max) + countInRange(root.right,min,max);
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
		
		CountInRange tree = new CountInRange();
		int[] keys = {20,8,22,4,12};
		
		for(int key : keys) {
			tree.root = tree.insert(tree.root,key);
		}
		
		System.out.print("Coun of elements in the given range: " + tree.countInRange(tree.root,10,25));

	}

}
