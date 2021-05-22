/* For our scenario, we are kind of defining our binary search space in terms of the minimum and the maximum
 * numbers in the array. Going by this idea, the complexity for our binary search should be 
 * O(log(Max−Min))where Max is the maximum element in the array and likewise, Min is the minimum element.
 * 
 * In each iteration of our binary search approach, we iterate over the matrix trying to determine 
 * the size of the left-half as explained before. That takes O(N).
 * 
 * Thus, the overall time complexity is O(N×log(Max−Min))
 * 
 * Space Complexity = O(1)
 */
public class KthSmallestElement {

	static int kthSmallestElement(int[][] matrix, int k) {
		
		int n = matrix.length;
		int start = matrix[0][0], end = matrix[n-1][n-1];
		
		while(start < end) {
			int mid = start + (end - start)/2;
			
			int[] smallLargePair = {matrix[0][0],matrix[n-1][n-1]};
			int count = countLessEqual(matrix,mid,smallLargePair);
			
			if(count == k)
				return smallLargePair[0];
			
			if(count < k)
				start = smallLargePair[1];
			else
				end = smallLargePair[0];
		}
		
		return start;
	}
	
	static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
		
		int count = 0;
		int n = matrix.length, row = n-1, col = 0;
		
		while(row >= 0 & col < n) {
			if(matrix[row][col] > mid) {
				// as matrix[row][col] is bigger than the mid, let's keep track of the
		        // smallest number greater than the mid
				smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
				row--;
			}else {
				// as matrix[row][col] is less than or equal to the mid, let's keep track of the
		        // biggest number less than or equal to the mid
				smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
				count += (row + 1);
				col++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		
		System.out.print("kth smallest element is: " + kthSmallestElement(matrix,8));
	}

}
