/* Time Complexity = O(mn)
 * Space Complexity = O(1)
 */

public class RotateMatrixBy90 {
	
	static void rotate(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i=0; i<rows; i++) {
			for(int j=i+1;j <cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i]= temp;
			}
		}
		
		for(int i=0; i<rows; i++) {
			int j = 0;
			int k = cols-1;
			while(j < k) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
				j++;
				k--;
			}
		}
		
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		System.out.println("Original Matrix");
		for(int[] rows : matrix) {
			for(int elem : rows) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		rotate(matrix);
		
		System.out.println("Rotated Matrix");
		for(int[] rows : matrix) {
			for(int elem : rows) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}

	}

}
