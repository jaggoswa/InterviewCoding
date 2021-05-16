
public class CountUniqueBST {
	
	TreeNode root;
	
	static int countBST(int n) {
		
		int[] G = new int[n+1];
		
		//Base Cases
		G[0] = 1;
		
		if(n >= 1) {
			G[1] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				G[i] += G[j-1] * G[i-j];
			}
		}
		
		return G[n];
	}

	public static void main(String[] args) {
		System.out.print(countBST(2));

	}

}
