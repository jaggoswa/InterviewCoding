import java.util.*;
public class DiagonalTraversal {
	
	TreeNode root;
	
	public void diagonalTraversal(TreeNode root) {
		
		if(root == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<ArrayList<TreeNode>> al = new ArrayList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<TreeNode> al_new = new ArrayList<>();
			
			while(size-- > 0) { //traverse all components of a particular diagonal
				TreeNode node = q.poll();
				while(node != null) { //traverse each component
					al_new.add(node);
					
					if(node.left != null)
						q.add(node.left);
					
					node = node.right;
				}
			}
			al.add(al_new);
		}
		
		for(ArrayList<TreeNode> l : al) {
			for(TreeNode n : l) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		DiagonalTraversal tree = new DiagonalTraversal();
		
		tree.root = new TreeNode(8);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(1);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(14);
		tree.root.right.left.left = new TreeNode(4);
		tree.root.right.left.right = new TreeNode(7);
		tree.root.right.right.left = new TreeNode(13);
		
		tree.diagonalTraversal(tree.root);

	}

}
