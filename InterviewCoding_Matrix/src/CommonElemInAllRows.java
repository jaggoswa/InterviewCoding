import java.util.HashMap;

/* Time Complexity = O(mn)
 * Space Complexity = O(n)
 */
public class CommonElemInAllRows {
	
	static void printCommonElements(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int j=0; j<cols; j++) {
			hm.put(matrix[0][j], 1);
		}
		
		for(int i=1; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(hm.get(matrix[i][j]) != null && hm.get(matrix[i][j]) == i) {
					hm.put(matrix[i][j], i+1);
					
					if(i == rows-1)
						System.out.print(matrix[i][j] + " ");
				}
			}
		}

	}

	public static void main(String[] args) {
		int mat[][] =
		    {
		        {1, 2, 1, 4, 8},
		        {3, 7, 8, 5, 1},
		        {8, 7, 7, 3, 1},
		        {8, 1, 2, 7, 9},
		    };
		
		printCommonElements(mat);

	}

}
