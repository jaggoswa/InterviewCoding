
public class PositionOfOnlySetBit {
	
	static int findSetbit(int n) {
		
		int i = 1, pos = 1;
		
		if(!isPowerOfTwo(n))
			return -1;
		
		while((i&n) == 0) {
			i = i << 1;
			pos++;
		}
		
		return pos;
		
	}
	
	static boolean isPowerOfTwo(int n) {
		
		return (n>0 && ((n & (n-1)) == 0)) ? true : false;
		
	}

	public static void main(String[] args) {
		int n = 16;
		int pos = findSetbit(n);
		
		if(pos == -1)
			System.out.println("Invalid number");
		else
			System.out.println("Position of set bit is: " + pos);
		
		n = 12;
		pos = findSetbit(n);
		
		if(pos == -1)
			System.out.println("Invalid number");
		else
			System.out.println("Position of set bit is: " + pos);

	}

}
