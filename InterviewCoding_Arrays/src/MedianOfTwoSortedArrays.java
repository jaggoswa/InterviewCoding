/* Time Complexity = O(log(min(m,n))), since we are performing binary search on the smaller array.
 * Space Complexity = O(1)*/
public class MedianOfTwoSortedArrays {
	
	static double findMedian(int[] arr1, int[] arr2) {
		if(arr1.length > arr2.length)
			return findMedian(arr2,arr1);
		
		int x = arr1.length;
		int y = arr2.length;
		
		int low =0;
		int high = x;
		
		while(low <= high) {
			
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX-1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY-1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if((x+y)%2 == 0)
					return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				else
					return Math.max(maxLeftX, maxLeftY);
			}
			else if(maxLeftX > minRightY)
				high = partitionX - 1;
			else
				low = partitionX + 1;
		}
		
		return 0.0;
	}

	public static void main(String[] args) {
		int[] input1 = {1,3,8,9,15};
		int[] input2 = {7,11,19,21,18,25};
		
		System.out.println("The median of the two arrays is: " + findMedian(input1,input2));

	}

}
