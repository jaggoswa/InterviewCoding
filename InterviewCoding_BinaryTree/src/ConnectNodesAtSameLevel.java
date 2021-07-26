import java.util.LinkedList;
import java.util.Queue;

/* Time Complexity = O(n) as we are processing each element of the tree only once
 * and each time it performs constant time operations.
 * Space Complexity = O(n)*/

class TreeNode1{
	int data;
	TreeNode1 left,right,nextRight;
	
	TreeNode1(int d){
		data = d;
		left = right = nextRight = null;
	}
}

public class ConnectNodesAtSameLevel {

	TreeNode1 root;
	
//	void connect(TreeNode1 root) {
//		Queue<TreeNode1> q = new LinkedList<TreeNode1>();
//		q.add(root);
//		
//		while(!q.isEmpty()) {
//			int n = q.size();
//			
//			for(int i=0; i<n; i++) {
//				TreeNode1 temp = q.poll();
//				
//				if(i < n-1)
//					temp.nextRight = q.peek();
//				
//				if(temp.left != null)
//					q.add(temp.left);
//				
//				if(temp.right != null)
//					q.add(temp.right);
//			}
//		}
//	}
	
	//In case of perfect binary tree
	//Space Complexity = O(1)
	void connect(TreeNode1 root) {
		
		if(root == null)
			return;
		
		TreeNode1 leftmost = root;
		while(leftmost.left != null) {
			TreeNode1 head = leftmost;
			
			while(head != null) {
				
				head.left.nextRight = head.right;
				
				if(head.nextRight != null)
					head.right.nextRight = head.nextRight.left;
				
				head = head.nextRight;
			}
			
			leftmost = leftmost.left;
		}
		
	}
	
	public static void main(String[] args) {
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
		
		tree.root = new TreeNode1(10); 
        tree.root.left = new TreeNode1(8); 
        tree.root.right = new TreeNode1(2); 
        tree.root.left.left = new TreeNode1(3);
        tree.root.left.right = new TreeNode1(4);
        tree.root.right.left = new TreeNode1(5);
        tree.root.right.right = new TreeNode1(6);
        
        tree.connect(tree.root);
        
        System.out.println("Following are populated nextRight pointers in the tree"
                + "(-1 is printed if there is no nextRight)"); 
        
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.data + " is " + a); 
        
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.left.data + " is " + b); 
        
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.right.data + " is " + c);
        
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);

	}

}
