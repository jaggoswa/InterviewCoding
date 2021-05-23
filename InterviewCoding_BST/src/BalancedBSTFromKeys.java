import java.util.Arrays;

/* Time Complexity = O(nlogn)
 * Space Complexity = O(n)*/
public class BalancedBSTFromKeys {

	public TreeNode createBalancedBST(int[] arr) {
		Arrays.sort(arr);
		
		return createBalancedBSTUtil(arr,0,arr.length-1);
	}
	
	public TreeNode createBalancedBSTUtil(int[] arr, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		
		node.left = createBalancedBSTUtil(arr,start,mid-1);
		node.right = createBalancedBSTUtil(arr,mid+1,end);
		
		return node;
	}
	
	public void printInorder(TreeNode root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	public static void main(String[] args) {
		
		BalancedBSTFromKeys tree = new BalancedBSTFromKeys();
		int[] keys = {15, 10, 20, 8, 12, 16, 25};
		TreeNode node = tree.createBalancedBST(keys);
		tree.printInorder(node);
	}

}
