/* Problem Statement: Write an efficient program to count number of 1s in the 
 * binary representation of an integer */


/* Time Complexity = O(number of set bits)
 * Space Complexity = O(1) */
public class CountSetBits {
	
	static int countSetBits(int n) {
		
		int count = 0;
		
		while(n != 0) {
			n = n & (n-1); //(n-1) flips all bits starting from rightmost set bit
			count++;
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		int num = 52; //ans=3
		
		System.out.println("The number of set bits in the number is " + countSetBits(num));

	}

}
