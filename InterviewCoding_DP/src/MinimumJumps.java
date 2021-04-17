
/*Time complexity = O(n^2)since nested traversal of the array is needed
 * Space Complexity = O(n) for the two new arrays created*/
public class MinimumJumps {
	
	static int  minJumps(int arr[], int[] actualJump) {
		int[] noOfJumps = new int[arr.length];
		noOfJumps[0] = 0;
		
		for(int i=1; i<noOfJumps.length; i++) {
			noOfJumps[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] + j >= i) {
					if(noOfJumps[j] + 1 < noOfJumps[i]) {
						noOfJumps[i] = noOfJumps[j] + 1;
						actualJump[i] = j;
					}
				}
			}
		}
		
		return noOfJumps[noOfJumps.length - 1];
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] actualJump = new int[arr.length];

		System.out.println("The minimum number of jumps needed is: " + minJumps(arr,actualJump));
		
		System.out.println("The jumps needed are: ");
		int i = arr.length - 1;
		
		while(i > 0) {
			System.out.print(actualJump[i] + " ");
			i = actualJump[i];
		}

	}

}
