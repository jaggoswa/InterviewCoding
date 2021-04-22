
/* Time Complexity = O(1)
 * Space Complexity = O(1)*/
public class CopySetBitsInARange {
	
	static int toggleBits(int a, int b, int l, int r) {
		
		int mask = ((1 << (r-l+1)) - 1) << (l-1);
		
		mask = mask & a;
		
		return (mask | b);
		
	}

	public static void main(String[] args) {
		int num1 = 13, num2 = 10, l = 2, r = 3;
		int mod_num2 = toggleBits(num1,num2,l,r);
		
		System.out.println("Modified number is: " + mod_num2);

	}

}
