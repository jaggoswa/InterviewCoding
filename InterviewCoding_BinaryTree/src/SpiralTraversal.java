import java.util.*;

public class SpiralTraversal {
	
	TreeNode root;
	
	public void spiralTraversal(TreeNode root) {
		
		if(root == null)
			return;
		
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		currLevel.add(root);
		boolean leftToRight = false;
		
		while(!currLevel.isEmpty()) {
			int n = currLevel.size();
			
			for(int i=0; i<n; i++) {
				TreeNode node = currLevel.pop();
				System.out.print(node.data + " ");
				
				if(leftToRight) {
					if(node.left != null)
						nextLevel.add(node.left);
					
					if(node.right != null)
						nextLevel.add(node.right);
				}
				
				if(!leftToRight) {
					if(node.right != null)
						nextLevel.add(node.right);
					
					if(node.left != null)
						nextLevel.add(node.left);
				}
				
				if(i == n-1) {
					leftToRight = !leftToRight;
					Stack<TreeNode> temp = currLevel;
					currLevel = nextLevel;
					nextLevel = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		SpiralTraversal tree = new SpiralTraversal();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(7);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.left = new TreeNode(5);
		tree.root.right.right = new TreeNode(4);
		
		tree.spiralTraversal(tree.root);

	}

}
