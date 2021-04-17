/*Time Complexity: O(n) where n is number of nodes in the given binary tree.*/
import java.util.Scanner;

public class NodesAtDistanceK {
	
	TreeNode root;
	
	void nodesAtDistanceK(TreeNode node, int k) {
		if(node == null)
			return;
		
		if(k == 0) {
			System.out.print(node.data + " ");
			return;
		}
		
		nodesAtDistanceK(node.left, k-1);
		nodesAtDistanceK(node.right, k-1);
	}

	public static void main(String[] args) {
		NodesAtDistanceK tree = new NodesAtDistanceK();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the distance: ");
		int distance = sc.nextInt();
		
		System.out.println("Nodes at distance " + distance + " from root are:");
		tree.nodesAtDistanceK(tree.root, distance);

	}

}
