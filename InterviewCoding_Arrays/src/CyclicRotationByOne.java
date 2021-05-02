/*Time complexity = O(n)
 * Space Complexity = O(1)*/
public class CyclicRotationByOne {
	
	static void rotate(int[] arr) {
		int len = arr.length;
		int last = arr[len-1];
		
		for(int i=len-1; i>0; i--) {
			arr[i] = arr[i-1]; 
		}
		
		arr[0] = last;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		System.out.println("The original array is");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		rotate(arr);
		
		System.out.println("The array after rotation");
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}

}
