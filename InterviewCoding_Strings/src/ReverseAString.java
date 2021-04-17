import java.util.Scanner;

/*Time Complexity = O(n)
 * Space Complexity = O(1)*/
public class ReverseAString {
	
	static char[] reverse(String str) {
		char[] ch = str.toCharArray();
		int length = ch.length;
		
		for(int i=0,j=length-1;i<j;i++,j--) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}
		
		return ch;
	}

	public static void main(String[] args) {
		
		System.out.print("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[]ch_array = reverse(str);
		
		for(char ch : ch_array) {
			System.out.print(ch);
		}
	}

}
