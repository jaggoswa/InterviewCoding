import java.util.TreeSet;
import java.util.Iterator;

/*Time Complexity = O(nlogn), since inserting n elements into TreeSet takes O(nlogn) time
 * and other inorder operations takes O(n) time
 * Space Complexity = O(n)*/
public class BinaryTreeToBST {
	
	TreeNode root;
	
	void extractInorder(TreeNode root,TreeSet<Integer> set) {
		if(root != null) {
			extractInorder(root.left,set);
			set.add(root.data);
			extractInorder(root.right,set);
		}
	}
	
	void insertInorder(TreeNode root,Iterator<Integer> it) {
		
		if(root != null) {

			insertInorder(root.left,it);
			root.data = it.next();
			insertInorder(root.right,it);
		}
	}
	
	void printInorder(TreeNode root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}
	

	public static void main(String[] args) {
		
		BinaryTreeToBST tree = new BinaryTreeToBST();
		
		tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(10);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		tree.extractInorder(tree.root,ts);
		
		Iterator<Integer> it = ts.iterator();
		tree.insertInorder(tree.root,it);
		
		tree.printInorder(tree.root);

	}

}
