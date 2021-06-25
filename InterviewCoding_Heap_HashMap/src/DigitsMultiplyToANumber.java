import java.util.LinkedList;

public class DigitsMultiplyToANumber {
	
	public static void smallestNumber(int num) {
		
		LinkedList<Integer> smallestNum = new LinkedList<>();
		
		if(num < 10) {
			System.out.print(num+10);
		}else {
		
			int i=9;
			while(i > 1) {
				if(num % i == 0) {
					smallestNum.addFirst(i);
					num /= i;
				}else {
					i--;
				}
			}
			
			if(num > 10) {
				System.out.print("Not possible");
			}
		}
		
		for(int e : smallestNum) {
			System.out.print(e);
		}
	}

	public static void main(String[] args) {
		
		int n = 13;
		smallestNumber(n);
	}

}
