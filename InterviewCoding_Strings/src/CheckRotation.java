/*time Complexity = O(n), since indexOf function takes O(n) time
 * Space Complexity = O(n)*/
public class CheckRotation {
	
	static boolean isRotation(String s1,String s2) {
		
		return (s1.length() == s2.length()) 
				&& ((s1+s1).indexOf(s2) != -1);
	}

	public static void main(String[] args) {
		String str1 = "AACD";
		String str2 = "ACDA";
		
		if(isRotation(str1,str2))
			System.out.print("Strings are rotations of each other");
		else
			System.out.print("Strings are not rotation of each other");
	}

}
