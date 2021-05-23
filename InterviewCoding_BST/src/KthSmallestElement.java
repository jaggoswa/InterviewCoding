import java.util.ArrayList;

/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class KthSmallestElement {
	
	TreeNode root;
	
	public TreeNode insert(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		
		if(val < root.data)
			root.left = insert(root.left,val);
		else if(val > root.data)
			root.right = insert(root.right,val);
		
		return root;	
	}
	
	public int kthSmallestElement(int k) {
		ArrayList<Integer> al = new ArrayList<>();
		inorder(root,al);
		return al.get(k-1);
	}
	
	public void inorder(TreeNode root, ArrayList<Integer> al) {
		if(root == null)
			return;
		inorder(root.left,al);
		al.add(root.data);
		inorder(root.right,al);
	}
	
	public static void main(String[] args) {
		
		KthSmallestElement tree = new KthSmallestElement();
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        
        for (int x : keys)
            tree.root = tree.insert(tree.root, x);
        
        int k = 3;
        System.out.print(tree.kthSmallestElement(k));

	}

}
