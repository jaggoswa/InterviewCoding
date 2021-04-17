import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Time Complexity = O(nlogn), since we could have a complete binary tree 
 * and if that is the case, then there would be n/2 leafs. 
 * For every leaf, we perform a potential O(logn) operation of copying over the path nodes
 * to a new list to be added to the final pathsList
 * 
 * Space Complexity = O(nlogn), atmost there can be n/2 lists of path nodes 
 * each with max O(logn) elements*/
public class PrintKSumPathRootToLeaf {
	
	TreeNode root;
	
	void getKSumPath(TreeNode root, int sum, ArrayList<Integer> pathNodes, 
			ArrayList<ArrayList<Integer>> pathList) {
		
		if(root == null)
			return;
		
		sum -= root.data;
		pathNodes.add(root.data);
		
		if(sum == 0 && root.left == null && root.right == null) {
			pathList.add(new ArrayList<>(pathNodes));
		}
		else {
			getKSumPath(root.left,sum,pathNodes,pathList);
			getKSumPath(root.right,sum,pathNodes,pathList);
		}
		
		pathNodes.remove(pathNodes.size() - 1);
	}

	public static void main(String[] args) {
		PrintKSumPathRootToLeaf tree = new PrintKSumPathRootToLeaf();
		Scanner sc = new Scanner(System.in);
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(8);
		tree.root.left.left = new TreeNode(11);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.right.left = new TreeNode(5);
		tree.root.right.right.right = new TreeNode(1);
		
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pathNodes = new ArrayList<Integer>();
		
		System.out.print("Enter the sum: ");
		int sum = sc.nextInt();
		
		tree.getKSumPath(tree.root,sum,pathNodes,pathList);
		
		for(List<Integer> list : pathList) {
			for(int data : list) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
		
		

	}

}
