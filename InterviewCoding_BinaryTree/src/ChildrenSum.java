
/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class ChildrenSum {

	TreeNode root;
	
	boolean isChildrenSum(TreeNode root) {
		int left_data = 0, right_data = 0;
		if(root == null || (root.left == null && root.right == null))
			return true;
		else {
			if(root.left != null)
				left_data = root.left.data;
			
			if(root.right != null)
				right_data = root.right.data;
			
			return(root.data == left_data + right_data 
					&& isChildrenSum(root.left) 
					&& isChildrenSum(root.right));
		}
			
	}
	
	public static void main(String[] args) {
		ChildrenSum tree = new ChildrenSum(); 
        tree.root = new TreeNode(10); 
        tree.root.left = new TreeNode(8); 
        tree.root.right = new TreeNode(2); 
        tree.root.left.left = new TreeNode(3); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.right = new TreeNode(2); 
        if (tree.isChildrenSum(tree.root)) 
            System.out.println("The given tree satisfies children sum property"); 
        else
            System.out.println("The given tree does not satisfy children sum property"); 

	}

}
