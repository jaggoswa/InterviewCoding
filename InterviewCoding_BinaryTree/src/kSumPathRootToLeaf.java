import java.util.Scanner;

/* Time Complexity = O(n), since we visit each node only once
 * Space Complexity = O(n)*/
public class kSumPathRootToLeaf {
	
	TreeNode root;
	
	boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		sum -= root.data;
		if(root.left == null && root.right == null)
			return sum == 0;
		
		return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
	}
	
	public static void main(String[] args) {
		kSumPathRootToLeaf tree = new kSumPathRootToLeaf();
		Scanner sc = new Scanner(System.in); //Enter 22
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(8);
		tree.root.left.left = new TreeNode(11);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.right.right = new TreeNode(1);
		
		System.out.print("Enter the sum: ");
		int sum = sc.nextInt();
		
		System.out.println("The tree contains a k sum path from root to leaf : " + tree.hasPathSum(tree.root,sum));

	}

}
