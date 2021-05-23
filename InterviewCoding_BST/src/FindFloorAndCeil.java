/* Time Complexity = O(n)
 * Space Complexity = O(h)*/
public class FindFloorAndCeil {
	
	TreeNode root;
	
	public void findFloorCeil(int key) {
		
		TreeNode node = root;
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;
				
		while(node != null) {
			if(key > node.data) {
				floor = node.data;
				node = node.right;
			}
			else if(key < node.data) {
				ceil = node.data;
				node = node.left;
			}
			else {
				floor = node.data;
				ceil = node.data;
				break;
			}
		}
		
		System.out.print("Value: " + key + ", " + "Floor: " + floor + ", " + "Ceil: " + ceil);
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
	

	public static void main(String[] args) {
		
		FindFloorAndCeil tree = new FindFloorAndCeil();
		
		int[] keys = {2, 4, 6, 8, 9, 10, 12};
		
		for(int key : keys) {
			tree.root = tree.insert(tree.root, key);
		}
		
		for (int i = 0; i < 16; i++) { 
            tree.findFloorCeil(i);
            System.out.println();
        }

	}

}
