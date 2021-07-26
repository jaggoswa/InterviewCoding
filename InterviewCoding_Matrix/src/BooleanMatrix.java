/* Time Complexity = O(mn)
 * Space Complexity = O(1)
 */
public class BooleanMatrix {
	
	public static void setZeroes(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean isCol = false;
		
		for(int i=0; i<rows; i++) {
			if(matrix[i][0] == 0)
				isCol = true;
			
			for(int j=1; j<cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<rows; i++) {
			for(int j=1; j<cols; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if(matrix[0][0] == 0) {
			for(int j=0; j<cols; j++) {
				matrix[0][j] = 0;
			}
		}
		
		if(isCol == true) {
			for(int i=0; i<rows; i++) {
				matrix[i][0] = 0;
			}
		}
		
	}

	public static void main(String[] args) {
//		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
