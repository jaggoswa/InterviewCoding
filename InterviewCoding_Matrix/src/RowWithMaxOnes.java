/* Time Complexity = O(m+n)
 * Space Complexity = O(1)
 */
public class RowWithMaxOnes {
	
	static int maxOnesIndex(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int maxRowindex = 0;
		int j = cols-1;
		
		while(j>=0 && matrix[0][j] == 1) {
			j--;
		}
		
		for(int i=1; i<rows; i++) {
			while(j>= 0 && matrix[i][j] == 1) {
				j--;
				maxRowindex = i;
			}
		}
		
		return maxRowindex;
	}

	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 1},{0, 0, 1, 1},{1, 1, 1, 1},{0, 0, 0, 0}};
		System.out.println("Index of the 1st row with max ones is: " + maxOnesIndex(matrix));

	}

}
