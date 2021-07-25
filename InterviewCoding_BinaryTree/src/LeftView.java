import java.util.*;
public class LeftView {
	
	TreeNode root;
	
	public void leftView(TreeNode root) {
		
		if(root == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			
			for(int i=0; i<n; i++) {
				TreeNode node = q.poll();
				
				if(i == 0)
					System.out.print(node.data + " ");
				
				if(node.left != null)
					q.add(node.left);
				
				if(node.right != null)
					q.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		
		LeftView tree = new LeftView();
		
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(3);
		tree.root.right.right = new TreeNode(1);
		tree.root.right.left.left = new TreeNode(6);
		tree.root.right.left.right = new TreeNode(7);
		
		tree.leftView(tree.root);
		
	}

}
