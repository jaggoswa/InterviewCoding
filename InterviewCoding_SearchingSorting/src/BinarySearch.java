
public class BinarySearch {
	
	public static int binarySearch(int[] arr, int k, int low, int high) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		
		if(k == arr[mid]) {
			return mid;
		}else if(k < arr[mid]) {
			return binarySearch(arr, k , low, mid-1);
		}else
			return binarySearch(arr, k, mid+1, high);
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 12, 14, 16, 18, 20, 22};
		
		int searchIdx = binarySearch(arr, 22, 0, arr.length-1);
		
		if(searchIdx == -1)
			System.out.println("Element not found");
		else
			System.out.print("Element found at index " + searchIdx);

	}

}
