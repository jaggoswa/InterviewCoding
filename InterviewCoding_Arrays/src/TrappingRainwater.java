
/* Time Complexity = O(n)
 * Space Complexity = O(1)*/
public class TrappingRainwater {
	
	static int calculateTrappedWater(int[] arr) {
		
		int maxLeft = arr[0];
		int maxRight = arr[arr.length-1];
		
		int left = 1;
		int right = arr.length-2;
		
		int trappedWater = 0;
		
		while(left <= right) {
			if(maxLeft < maxRight) {
				if(arr[left] > maxLeft)
					maxLeft = arr[left];
				else
					trappedWater += maxLeft-arr[left];	
				
				left++;
			}
			else {
				if(arr[right] > maxRight)
					maxRight = arr[right];
				else
					trappedWater += maxRight-arr[right];
				
				right--;
			}
		}
		
		return trappedWater;
		
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println("Maximum water that "
                     + "can be accumulated is "
                     + calculateTrappedWater(arr));

	}

}
