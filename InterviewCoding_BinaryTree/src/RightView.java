import java.util.*;
public class RightView {
	
	TreeNode root;
	
	public void rightView(TreeNode root) {
		
		if(root == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			
			for(int i=0; i<n; i++) {
				TreeNode node = q.poll();
				
				if(i == n-1)
					System.out.print(node.data + " ");
				
				if(node.left != null)
					q.add(node.left);
				
				if(node.right != null)
					q.add(node.right);

				
			}
		}
	}

	public static void main(String[] args) {
		
		RightView tree = new RightView();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.right.right = new TreeNode(8);
		
		tree.rightView(tree.root);

	}

}
