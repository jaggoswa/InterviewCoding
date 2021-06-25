import java.util.ArrayList;

public class ClosestLeaf {
	
	TreeNode root;
	
	int closestDown(TreeNode node) {
		if(node == null)
			return Integer.MAX_VALUE;
		
		if(node.left == null &&  node.right == null)
			return 0;
		
		return 1 + Math.min(closestDown(node.left),closestDown(node.right));
	}
	
	int findClosestUtil(TreeNode node, int k, ArrayList<TreeNode> ancestors, int index) {
		if(node == null)
			return Integer.MAX_VALUE;
		
		if(node.data == k) {
			int res = closestDown(node);
			
			for(int i = index - 1; i >= 0; i--) {
				res = Math.min(res,(index - i) + closestDown(ancestors.get(i)));
			}
			
			return res;
		}
		
		ancestors.add(index,node);
		return Math.min(findClosestUtil(node.left,k,ancestors,index+1),
				findClosestUtil(node.right,k,ancestors,index+1));
	}
	
	int findClosest(TreeNode node, int k) {
		ArrayList<TreeNode> ancestors = new ArrayList<TreeNode>();
		return findClosestUtil(node, k, ancestors, 0);
	}
	
	public static void main(String[] args) {
		ClosestLeaf tree = new ClosestLeaf(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.right.left = new TreeNode(4); 
        tree.root.right.right = new TreeNode(5); 
        tree.root.right.left.left = new TreeNode(6); 
        tree.root.right.left.left.left = new TreeNode(7); 
        tree.root.right.left.left.right = new TreeNode(8); 
        tree.root.right.right.right = new TreeNode(9); 
        tree.root.right.right.right.left = new TreeNode(10); 
   
        int k = 1; 
        System.out.println("Distance of the closest leaf from " + k + " is "
                            + tree.findClosest(tree.root, k)); 
        k = 3; 
        System.out.println("Distance of the closest leaf from " + k + " is "
                            + tree.findClosest(tree.root, k)); 
        k = 4; 
        System.out.println("Distance of the closest leaf from " + k + " is "
                            + tree.findClosest(tree.root, k)); 
        k = 2; 
        System.out.println("Distance of the closest leaf from " + k + " is "
                             + tree.findClosest(tree.root, k)); 

	}

}
