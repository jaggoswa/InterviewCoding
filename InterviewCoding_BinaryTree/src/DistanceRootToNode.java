import java.util.Scanner;

/* Time Complexity - O(n), since in worst case the node can be a leaf node 
 * and the tree can be skewed 
 * Space complexity - O(n) */
public class DistanceRootToNode {
	
	TreeNode root;
	
	int nodeDistance(TreeNode root, int nodeData, int level) {
		if(root == null)
			return -1;
		
		if(root.data == nodeData)
			return level;
		
		int left = nodeDistance(root.left,nodeData,level+1);
		
		if(left == -1)
			return nodeDistance(root.right,nodeData,level+1);
		
		return left;
	}

	public static void main(String[] args) {
		DistanceRootToNode tree = new DistanceRootToNode();
		Scanner sc = new Scanner(System.in);
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(20);
		tree.root.left.right = new TreeNode(25);
		tree.root.left.right.right = new TreeNode(45);
		tree.root.right.left = new TreeNode(30);
		tree.root.right.right = new TreeNode(35);
		
		System.out.print("Enter the node: ");
		int n = sc.nextInt();
		
		System.out.println("Node " + n + " : Distance " 
		+ tree.nodeDistance(tree.root,n,0));

	}

}
