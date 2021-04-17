
public class ReverseAnArray {
	
	static void reverse(int[] arr) {
		int start = 0, end = arr.length - 1;
		
		while(start < end) {
			int temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		reverse(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
