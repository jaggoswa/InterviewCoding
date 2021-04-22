import java.util.Stack;


/* Time Complexity = O(mn), maxRectangleInARow takes O(n) time and is performed for every row
 * Space Complexity = O(n)
 */
public class MaximumSizeRectangle {
	
	static int maximumSize(int[][] matrix) {
		
		int[] row_arr = new int[matrix[0].length];
		int maxArea = 0;
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				row_arr[j] = matrix[i][j] == 1 ? row_arr[j] + 1 : 0;
			}
			maxArea = Math.max(maxArea, maxRectangleInARow(row_arr));
		}
		
		return maxArea;
	}
	
	static int maxRectangleInARow(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		
		int[] left = new int[arr.length];
		stack.push(0);
		left[0] = -1;
		
		for(int i=1; i<arr.length; i++) {
			while(stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size() == 0)
				left[i] = -1;
			else
				left[i] = stack.peek();
			
			stack.push(i);
		}
		
		stack = new Stack<>();
		int[] right = new int[arr.length];
		stack.push(arr.length-1);
		right[arr.length - 1] = arr.length;
		
		for(int i=arr.length-2; i>=0; i--) {
			while(stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size() == 0)
				right[i] = arr.length;
			else
				right[i] = stack.peek();
			
			stack.push(i);
		}
		
		int maxArea = 0;
		for(int i=0; i<arr.length; i++) {
			int width = right[i] - left[i] - 1;
			int area = width * arr[i];
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
		
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		System.out.println("Maximum size rectangle in the matrix is: " + maximumSize(matrix));
	}

}
