/* Problem Statement: Given an integer num, return an array of the number of 1's in the binary representation
 * of every number in the range [0, num] */


/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class CountingBits {
	
	static int[] countBits(int num) {
		
		int[] countArr = new int[num+1];
		
		for(int i=0; i<=num; i++) {
			countArr[i] = countArr[i/2] + i%2;
		}
		
		return countArr;
		
	}
	
//	static int[] countBits(int num) {
//		
//		int[] countArr = new int[num+1];
//		
//		for(int i=0; i<=num; i++) {
//			countArr[i] = countArr[i>>1] + (i & 1);
//		}
//		
//		return countArr;
//		
//	}

	public static void main(String[] args) {
		int num = 5;
		
		int[] countArr = countBits(num);
		
		for(int i : countArr) {
			System.out.print(i + " ");
		}

	}

}
