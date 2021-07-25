import java.util.*;

public class ReverseLevelOrder {
	
	TreeNode root;
	
	public void reverseLevelOrder(TreeNode root) {
		
		if(root == null)
			return;
		
		Stack<TreeNode> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			st.add(node);
			
			if(node.right != null)
				q.add(node.right);
			
			if(node.left != null)
				q.add(node.left);
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop().data + " ");
		}
		
	}

	public static void main(String[] args) {
		ReverseLevelOrder tree = new ReverseLevelOrder();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		tree.reverseLevelOrder(tree.root);
	}

}
