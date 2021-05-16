import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

/* Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 */
public class TreeBottomView {
	
	TreeNode root;
	
	void printTreeBottomView() {
		TreeMap<Integer,Integer> tm = new TreeMap<>();
		Queue<Qobj> q = new LinkedList<Qobj>();
		
		if(root == null)
			return;
		else
			q.add(new Qobj(0,root));
		
		int hd;
		TreeNode node;
		
		while(!q.isEmpty()) {
			Qobj temp = q.poll();
			hd = temp.hd;
			node = temp.node;
			
			tm.put(hd, node.data);
			
			if(node.left != null)
				q.add(new Qobj(hd-1,node.left));
			
			if(node.right != null)
				q.add(new Qobj(hd+1, node.right));
			
		}
		
		for(Entry<Integer,Integer> entry : tm.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	public static void main(String[] args) {
		
		TreeBottomView tree = new TreeBottomView();
		
		tree.root = new TreeNode(20); 
        tree.root.left = new TreeNode(8); 
        tree.root.right = new TreeNode(22); 
        tree.root.left.left = new TreeNode(5); 
        tree.root.left.right = new TreeNode(3); 
        tree.root.right.left = new TreeNode(4); 
        tree.root.right.right = new TreeNode(25); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(14); 
        
        tree.printTreeBottomView();
	}

}
