import java.util.ArrayList;

public class PrintAllDownwardkSumPath {
	
	TreeNode root;
	
	void printDownwardPath(TreeNode root, ArrayList<Integer> pathNodes, int targetSum) {
		
		if(root == null)
			return;
		
		pathNodes.add(root.data);
		
		printDownwardPath(root.left,pathNodes,targetSum);
		printDownwardPath(root.right,pathNodes,targetSum);
		
		int pathSum = 0;
		for(int i=pathNodes.size()-1; i>=0; i--) {
			pathSum += pathNodes.get(i);
			
			if(pathSum == targetSum)
				printPath(pathNodes,i);
		}
		
		pathNodes.remove(pathNodes.size()-1);
	}
	
	void printPath(ArrayList<Integer> pathNodes, int j) {
		for(int i=j; i<pathNodes.size(); i++) {
			System.out.print(pathNodes.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintAllDownwardkSumPath tree = new PrintAllDownwardkSumPath();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(3); 
	    tree.root.left.left = new TreeNode(2); 
	    tree.root.left.right = new TreeNode(1); 
	    tree.root.left.right.left = new TreeNode(1); 
	    tree.root.right = new TreeNode(-1); 
	    tree.root.right.left = new TreeNode(4); 
	    tree.root.right.left.left = new TreeNode(1); 
	    tree.root.right.left.right = new TreeNode(2); 
	    tree. root.right.right = new TreeNode(5); 
	    tree.root.right.right.right = new TreeNode(2); 
	    
	    int k=5;
	    ArrayList<Integer> pathNodes = new ArrayList<>();
	    
	    tree.printDownwardPath(tree.root,pathNodes,k);
	}

}
