import java.util.ArrayList;

public class FactorialOfLargeNo {
	
	static void factorial(int n) {
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		
		for(int i=2; i<n; i++) {
			multiply(i,al);
		}
		
		System.out.print("The factorial of the number is: ");
		for(int i=al.size()-1; i>=0; i--) {
			System.out.print(al.get(i) + "");
		}
	}
	
	static void multiply(int x, ArrayList<Integer> al) {
		
		int carry = 0;
		
		for(int i=0; i<al.size(); i++) {
			int product = al.get(i) * x + carry;
			al.set(i,product%10);
			carry = product/10;
		}
		
		while(carry != 0) {
			al.add(carry%10);
			carry = carry/10;
		}
	}

	public static void main(String[] args) {
		int n = 100;
		
		factorial(n);
	}

}
