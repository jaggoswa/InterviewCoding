import java.util.ArrayList;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class FindTargetSumPair {
	
	TreeNode root;
	
	public void inorderTraversal(TreeNode root, ArrayList<Integer> al) {
		if(root == null)
			return;
		
		inorderTraversal(root.left,al);
		al.add(root.data);
		inorderTraversal(root.right,al);
	}
	
	public void printTargetSumPair(int sum) {
		ArrayList<Integer> al = new ArrayList<>();
		inorderTraversal(root,al);
		
		int i=0,j=al.size()-1;
		
		while(i<j) {
			if(al.get(i) + al.get(j) > sum)
				j--;
			else if(al.get(i) + al.get(j) < sum)
				i++;
			else {
				System.out.println(al.get(i) + " " + al.get(j));
				i++;
				j--;
			}
		}
	}
	
	public TreeNode insert(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		
		if(val < root.data)
			root.left = insert(root.left,val);
		else if(val > root.data)
			root.right = insert(root.right,val);
		
		return root;
	}
	
	public void printInorder(TreeNode root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		FindTargetSumPair tree = new FindTargetSumPair();
		
		int[] keys = {5,3,6,2,4,7};
		
		for(int key : keys) {
			tree.root = tree.insert(tree.root, key);
		}
		
		tree.printTargetSumPair(9);

	}

}
