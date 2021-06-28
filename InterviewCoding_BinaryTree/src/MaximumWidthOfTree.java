import java.util.LinkedList;
import java.util.Queue;

/* Time Complexity = O(n)
 * Space Complexity = O(w) , where w is the maximum width of the tree */
public class MaximumWidthOfTree {
	
	TreeNode root;

	int getMaximumWidth(TreeNode root) {
		if(root == null)
			return 0;
		
		int maxWidth = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int count = q.size();
			maxWidth = Math.max(maxWidth, count);
			
			while(count-- > 0) {
				TreeNode temp = q.remove();
				
				if(temp.left != null)
					q.add(temp.left);
				
				if(temp.right != null)
					q.add(temp.right);
				
			}
		}
		
		return maxWidth;
	}
	
	public static void main(String[] args) {
		MaximumWidthOfTree tree = new MaximumWidthOfTree();
		
		tree.root = new TreeNode(1); 
		tree.root.left = new TreeNode(2); 
		tree.root.right = new TreeNode(3); 
		tree.root.left.left = new TreeNode(4); 
		tree.root.left.right = new TreeNode(5); 
		tree.root.right.right = new TreeNode(8); 
		tree.root.right.right.left = new TreeNode(6); 
		tree.root.right.right.right = new TreeNode(7);
		
		System.out.print("The maximum width of the tree is: " + tree.getMaximumWidth(tree.root));

	}

}
