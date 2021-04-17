
/*Time complexity = O(n)
 * Space Complexity = O(1)*/
public class Sort012 {
	
	static void sort(int[] arr) {
		
		//Dutch Flag Problem
		
		int low = 0, mid = 0, high = arr.length - 1;
		
		while(mid <= high) {
			if(arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				mid++;
				low++;
			}
			else if(arr[mid] == 1)
				mid++;
			else if(arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--; //low will never be pointing to zero
			}
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort(arr);
		
		System.out.println("The sorted array is:");
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}

}
