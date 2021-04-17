import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	TreeNode root;
	
	void printLevelOrder() {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
		}
	}

	public static void main(String[] args) {
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		
		System.out.println("Level order traversal:");
		tree.printLevelOrder();
	}

}
