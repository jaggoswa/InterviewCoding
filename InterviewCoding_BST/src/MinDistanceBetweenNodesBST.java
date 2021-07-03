
public class MinDistanceBetweenNodesBST {
	
	TreeNode root;
	
	TreeNode insert(TreeNode root, int key) {
		if(root == null)
			return new TreeNode(key);
		
		if(key < root.data)
			root.left = insert(root.left,key);
		
		if(key > root.data)
			root.right = insert(root.right,key);
		
		return root;
	}
	
	int distanceFromRoot(TreeNode root, int x) {
		if(root.data == x)
			return 0;
		
		if(x < root.data)
			return 1 + distanceFromRoot(root.left,x);
		return 1 + distanceFromRoot(root.right,x);
	}
	
	int nodesDistance(TreeNode root, int a, int b) {
		if(root == null)
			return 0;
		
		if(a < root.data && b < root.data)
			return nodesDistance(root.left,a,b);
		
		if(a > root.data && b > root.data)
			return nodesDistance(root.right,a,b);
		
		if(a <= root.data && b >= root.data)
			return distanceFromRoot(root,a) + distanceFromRoot(root,b);
		
		return 0;	
	}
	
	int findDistance(TreeNode root, int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b= temp;
		}
		
		return nodesDistance(root,a,b);
	}

	public static void main(String[] args) {
		
		MinDistanceBetweenNodesBST tree = new MinDistanceBetweenNodesBST();
		
		tree.root = tree.insert(tree.root, 20);  
	    tree.insert(tree.root, 10);  
	    tree.insert(tree.root, 5);  
	    tree.insert(tree.root, 15);  
	    tree.insert(tree.root, 30);  
	    tree.insert(tree.root, 25);  
	    tree.insert(tree.root, 35);  
	    System.out.println(tree.findDistance(tree.root, 5, 35)); 
//	    System.out.println(tree.root.left.data);


	}

}
