import java.util.Arrays;

/*There are only two nested loops traversing the array, so time complexity is O(n^2). 
 * Two pointers algorithm takes O(n) time and the first element can be fixed using 
 * another nested traversal.
 * Space Complexity  = O(1)*/
public class TripletSum {
	
	static void checkTriplet(int[] arr, int sum) {
		
		Arrays.sort(arr);
		
		int l,r;
		
		for(int i=0;i<arr.length-2;i++) {
			
			l = i+1;
			r = arr.length-1;
			
			while(l < r) {
				if(arr[i] + arr[l] + arr[r] == sum) {
					System.out.print("Triplet is " + arr[i] + "," + arr[l] + "," + arr[r]);
					return;
				}
				else if(arr[i] + arr[l] + arr[r] < sum)
					l++;
				else
					r--;
			}
			
		}
		
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
 
        checkTriplet(arr, sum);

	}

}
