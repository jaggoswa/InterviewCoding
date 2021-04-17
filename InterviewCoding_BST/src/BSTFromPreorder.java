/*Time Complexity = O(n) since we visit each node exactly once
 * Space Complexity = O(n)*/
public class BSTFromPreorder {
	
	TreeNode root;
	int index = 0;
	
	TreeNode preorderToBST(int[] pre,int min,int max) {
		if(index == pre.length)
			return null;
		
		int val = pre[index];
		if(val < min || val > max)
			return null;
		
		index++;
		TreeNode node = new TreeNode(val);
		node.left = preorderToBST(pre,min,val);
		node.right = preorderToBST(pre,val,max);
		
		return node;
	}
	
	void printInorder(TreeNode root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	public static void main(String[] args) {
		
		BSTFromPreorder tree = new BSTFromPreorder();
		int[] pre = {10, 5, 1, 7, 40, 50};
		tree.root = tree.preorderToBST(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
		tree.printInorder(tree.root);
		
	}

}
