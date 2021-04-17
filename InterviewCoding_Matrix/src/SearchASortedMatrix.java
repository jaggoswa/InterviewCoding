/* Time complexity = O(log(mn)), since we are doing a binary search
 * Space Complexity = O(1)
 */
public class SearchASortedMatrix {
	
	static boolean searchMatrix(int[][] matrix, int target) {
		
		int rows = matrix.length;
		if(rows == 0)
			return false;
		
		int cols = matrix[0].length;
		
		int pivotIdx, pivotElement;
		int left = 0, right = rows*cols-1;
		
		while(left <= right) {
			pivotIdx = (left + right)/2;
			pivotElement = matrix[pivotIdx/cols][pivotIdx%cols];
			
			if(target == pivotElement)
				return true;
			else {
				if(target < pivotElement)
					right = pivotIdx - 1;
				else
					left = pivotIdx + 1;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 30;
		
		if(searchMatrix(matrix,target))
			System.out.println("Element found");
		else
			System.out.println("Element not found");

	}

}
