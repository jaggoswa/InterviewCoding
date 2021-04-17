import java.util.LinkedList;
import java.util.Queue;

/*Time Complexity = O(n)
 * Space Complexity = O(w) , where w is the maximum width of the tree
 */
public class MaxMinOfLevel {
	
	TreeNode root;
	
	void maxOfLevel(TreeNode root) {
		if(root == null)
			System.out.print("The tree is empty");
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int level = 0;
		
		while(!q.isEmpty()) {
			int count = q.size();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			while(count-- > 0) {
				TreeNode temp = q.poll();
				max = Math.max(max, temp.data);
				min = Math.min(min, temp.data);
				
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
			System.out.println("Min-Max of level " + level + " is: " + min + "-" +max);
			level++;
		}
	}

	public static void main(String[] args) {
		MaxMinOfLevel tree = new MaxMinOfLevel();
		
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(7);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(5);
		tree.root.left.right.right = new TreeNode(11);
		tree.root.right.right = new TreeNode(9);
		tree.root.right.right.left = new TreeNode(4);
		
		tree.maxOfLevel(tree.root);

	}

}
