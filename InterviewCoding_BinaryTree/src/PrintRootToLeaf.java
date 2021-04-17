import java.util.ArrayList;


public class PrintRootToLeaf {
	
	TreeNode root;
	
	void printAllPaths(TreeNode node) {
		if(root == null)
			return;
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		printPathUtil(root,path,0);
	}
	
	void printPathUtil(TreeNode node, ArrayList<Integer> path, int index) {
		
		if(node == null)
			return;
		
		path.add(index,node.data);
		index++;
		
		if(node.left == null && node.right == null) {
			printPath(path,index);
		}
		else {
			printPathUtil(node.left,path,index);
			printPathUtil(node.right,path,index);
		}
	}
	
	void printPath(ArrayList<Integer> path,int pathLength) {
		for(int i=0; i< pathLength; i++) {
			System.out.print(path.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PrintRootToLeaf tree = new PrintRootToLeaf(); 
        tree.root = new TreeNode(10); 
        tree.root.left = new TreeNode(8); 
        tree.root.right = new TreeNode(2); 
        tree.root.left.left = new TreeNode(3); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.left = new TreeNode(2); 
          
        /* Let us test the built tree by printing Inorder traversal */
        tree.printAllPaths(tree.root); 

	}

}
