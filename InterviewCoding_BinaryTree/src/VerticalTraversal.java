import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/* Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 */
public class VerticalTraversal {
	
TreeNode root;
	
	void printVerticalOrder() {
		TreeMap<Integer,ArrayList<Integer>> tm = new TreeMap<>();
		Queue<Qobj> q = new LinkedList<Qobj>();
		q.add(new Qobj(0,root));
		int hd;
		TreeNode node;
		
		while(!q.isEmpty()) {
			Qobj temp = q.poll();
			hd = temp.hd;
			node = temp.node;
			
			if(tm.containsKey(hd)) {
				tm.get(hd).add(node.data);
			}
			else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(node.data);
				tm.put(hd, al);
			}
			
			if(node.left != null)
				q.add(new Qobj(hd-1,node.left));
			
			if(node.right != null)
				q.add(new Qobj(hd+1,node.right));
		}
		
		for(Map.Entry<Integer,ArrayList<Integer>> entry : tm.entrySet()) {
			ArrayList<Integer> al = entry.getValue();
			for(int i : al) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		VerticalTraversal tree =new VerticalTraversal();
		
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);
        tree.root.right.right.right = new TreeNode(9);
        tree.root.right.right.left = new TreeNode(10);
        tree.root.right.right.left.right = new TreeNode(11);
        tree.root.right.right.left.right.right = new TreeNode(12);
        System.out.println("Vertical order traversal is ");
        tree.printVerticalOrder();
	}

}
