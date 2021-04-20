/* Time Complexity = O(no. of set bits)
 * Space Complexity = O(1)
 */
public class NumberOfFlips {
	
	static int countFlips(int num1, int num2) {
		
		return countSetBits(num1^num2);
		
	}
	
	static int countSetBits(int num) {
		
		int count = 0;
		
		while(num!=0) {
			num = num & (num-1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		System.out.println("The number of set bits in the number is " + countFlips(num1,num2));

	}

}
