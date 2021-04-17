import java.util.HashMap;
import java.util.Scanner;

public class DownwardKSum {
	
	TreeNode root;
	static int targetSum;
	int count = 0;
	HashMap<Integer,Integer> hm = new HashMap<>();
	
	void kSumPath(TreeNode root, int currSum) {
		if(root == null)
			return;
		
		currSum += root.data;
		
		if(root.data == targetSum)
			count++;
		
		count += hm.getOrDefault(currSum - targetSum,0);
		
		hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
		
		kSumPath(root.left,currSum);
		kSumPath(root.right,currSum);
		
		hm.put(currSum, hm.get(currSum)-1);
		
	}

	public static void main(String[] args) {
		DownwardKSum tree = new DownwardKSum();
		Scanner sc = new Scanner(System.in);
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(-3);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(3);
		tree.root.left.left.right = new TreeNode(-2);
		tree.root.left.right.right = new TreeNode(2);
		tree.root.right.right = new TreeNode(11);
		
		System.out.print("Enter the target sum: ");
		targetSum = sc.nextInt();
		
		tree.kSumPath(tree.root,0);
		
		System.out.print("The number of downward path of sum k is: " + tree.count);

	}

}
