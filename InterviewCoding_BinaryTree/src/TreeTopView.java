import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

/* Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 */
public class TreeTopView {
	
	TreeNode root;
	
	void printTreeTopView() {
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
			
			if(!tm.containsKey(hd))
				tm.put(hd,node.data);
			
			if(node.left != null)
				q.add(new Qobj(hd-1,node.left));
			if(node.right != null)
				q.add(new Qobj(hd+1,node.right));
		}
		
		for(Entry<Integer,Integer> entry : tm.entrySet()) {
			System.out.print(entry.getValue() + " ");
		} 
		
	}

	public static void main(String[] args) {
		TreeTopView tree = new TreeTopView();
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.left.right.right.right = new TreeNode(6);

        System.out.println("Top view of the tree is ");
        tree.printTreeTopView();
	}

}
