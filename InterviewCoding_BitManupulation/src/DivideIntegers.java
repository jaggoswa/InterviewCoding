/* Time Complexity = O(log(dividend))
 * Space complexity = O(1)*/
public class DivideIntegers {
	
	static long divide(long dividend, long divisor) {
		
		long temp = 0, q = 0;
		
		long sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		for(int i=31; i>=0; i--) {
			
			if(temp + (divisor << i) <= dividend) {
				temp += (divisor << i);
				q |= (1L << i);
			}
		}
		
		q = sign * q;
		
		return q >= Integer.MAX_VALUE || q <= Integer.MIN_VALUE ? Integer.MAX_VALUE : q;
	}

	public static void main(String[] args) {
		int a = 10, b = 3;
		System.out.println(divide(a, b));
		 
		int a1 = 43, b1 = -8;
		System.out.println(divide(a1, b1));
	}

}
