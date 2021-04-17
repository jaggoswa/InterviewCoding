import java.util.ArrayList;

/*Time Complexity - O(n) i.e O(n) for initialization, O(n) for DFS and O(1) for time comparisons
 Space Complexity - O(n)*/

public class CheckSamePathNodes {

	TreeNode root;
	
	ArrayList<Boolean> visited = new ArrayList<Boolean>();
	ArrayList<Integer> intime = new ArrayList<Integer>();
	ArrayList<Integer> outtime = new ArrayList<Integer>();
	int timer = 0;
	
	void dfs(ArrayList<ArrayList<Integer>> graph, int v) {
		visited.set(v, true);
		timer++;
		intime.set(v, timer);
		
		for(int i: graph.get(v)) {
			if(visited.get(i) == false)
				dfs(graph,i);
		}
		
		timer++;
		outtime.set(v,timer);	
	}
	
	
	boolean checkIfSamePath(int u, int v) {
		return ((intime.get(u) < intime.get(v)
				&& outtime.get(u) > outtime.get(v))
				|| (intime.get(v) < intime.get(u)
				&& outtime.get(v) > outtime.get(u)));
	}
	
	public static void main(String[] args) {
		CheckSamePathNodes tree = new CheckSamePathNodes();
		
		int n = 9;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			tree.visited.add(false);
			tree.intime.add(0);
			tree.outtime.add(0);
		}
		
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(2).add(4);
		graph.get(2).add(5);
		graph.get(3).add(6);
		graph.get(5).add(7);
		graph.get(5).add(8);
		graph.get(5).add(9);
		
		tree.dfs(graph,1);
		
		if(tree.checkIfSamePath(1,5)) {
			System.out.print("Path exists");
		}
		else {
			System.out.print("Path doesn't exist");
		}

	}

}
