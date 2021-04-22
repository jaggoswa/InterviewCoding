/* Time Complexity = O(n*2^n), n is the number of elements in the set
 * Space Complexity = O(1)
 */
public class PrintPowerSet {
	
	static void printPowerSet(char[] set) {
		
		int setSize = set.length;
		long powSetSize = (long) Math.pow(2, setSize);
		
		for(int counter = 0; counter < powSetSize; counter++) {
			for(int j=0; j<setSize; j++) {
				
				if((counter & (1<<j)) > 0)
					System.out.print(set[j]);	
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		char[] set = {'a', 'b', 'c'};
        printPowerSet(set);

	}

}
