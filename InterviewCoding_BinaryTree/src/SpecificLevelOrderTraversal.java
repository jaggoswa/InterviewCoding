import java.util.LinkedList;
import java.util.Queue;

public class SpecificLevelOrderTraversal {
	
	TreeNode root;
	
	void printSpecificLevelOrder() {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		
		if(root.left != null)
			System.out.print(root.left.data + " " + root.right.data + " ");
		else
			return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root.left);
		q.add(root.right);
		
		while(!q.isEmpty()) {
			TreeNode first = q.poll();
			TreeNode second = q.poll();
			
			System.out.print(first.left.data + " " + second.right.data + " ");
			System.out.print(first.right.data + " " + second.left.data + " ");
			
			if(first.left.left != null) {
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
			
		}
	}

	public static void main(String[] args) {
		SpecificLevelOrderTraversal tree = new SpecificLevelOrderTraversal(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
   
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.left = new TreeNode(6); 
        tree.root.right.right = new TreeNode(7); 
   
        tree.root.left.left.left = new TreeNode(8); 
        tree.root.left.left.right = new TreeNode(9); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(11); 
        tree.root.right.left.left = new TreeNode(12); 
        tree.root.right.left.right = new TreeNode(13); 
        tree.root.right.right.left = new TreeNode(14); 
        tree.root.right.right.right = new TreeNode(15); 
   
        tree.root.left.left.left.left = new TreeNode(16); 
        tree.root.left.left.left.right = new TreeNode(17); 
        tree.root.left.left.right.left = new TreeNode(18); 
        tree.root.left.left.right.right = new TreeNode(19); 
        tree.root.left.right.left.left = new TreeNode(20); 
        tree.root.left.right.left.right = new TreeNode(21); 
        tree.root.left.right.right.left = new TreeNode(22); 
        tree.root.left.right.right.right = new TreeNode(23); 
        tree.root.right.left.left.left = new TreeNode(24); 
        tree.root.right.left.left.right = new TreeNode(25); 
        tree.root.right.left.right.left = new TreeNode(26); 
        tree.root.right.left.right.right = new TreeNode(27); 
        tree.root.right.right.left.left = new TreeNode(28); 
        tree.root.right.right.left.right = new TreeNode(29); 
        tree.root.right.right.right.left = new TreeNode(30); 
        tree.root.right.right.right.right = new TreeNode(31); 
   
        System.out.println("Specific Level Order traversal of binary" 
                                                            +"tree is "); 
        tree.printSpecificLevelOrder();

	}

}
