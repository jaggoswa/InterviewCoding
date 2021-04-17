
public class ReverseWordByWord {
	
	static char[] reverse(char[] arr, int i, int j) {
		
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return arr;
		
	}
	
	static String reverseWord(String str) {
		char[] arr = str.toCharArray();
		int i = 0;
		
		for(int j=0; j<str.length(); j++) {
			if(arr[j] == ' ' || j == str.length() - 1) {
				arr = reverse(arr,i,j-1);
				i=j+1;
			}
		}
		
		return String.valueOf(arr);
	}
	

	public static void main(String[] args) {
		String str = "My name is Jagriti";
		
		String rev_str = reverseWord(str);
		
		System.out.print(rev_str);

	}

}
