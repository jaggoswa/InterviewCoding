import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*Time Complexity = O(n) in average case
 * Space Complexity = O(n)*/
public class PrintDuplicate {

	static void printAllDuplicates(String str) {
		
		HashMap<Character,Integer> hm = new HashMap<>(); 
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(hm.containsKey(ch))
				hm.put(ch,hm.get(ch)+1);
			else
				hm.put(ch, 1);
		}
		
		for(Entry<Character,Integer> es : hm.entrySet()) {
			int count = es.getValue();
			if(count > 1)
				System.out.println(es.getKey()+ " : " + es.getValue());
		}
	}
	
	public static void main(String[] args) {
		
		System.out.print("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		printAllDuplicates(str);

	}

}
