import java.util.Scanner;

/*Time Complexity = O(n)
 * Space Complexity = O(1)*/
public class CheckPalindrome {
	
	static boolean isPalindrome(String str) {
		
		int length = str.length();
		
		for(int i=0,j=length-1; i<j; i++,j--) {
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		System.out.print("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(isPalindrome(str))
			System.out.println("The string is a palindrome");
		else
			System.out.print("The string is not a palindrome");
	}

}
