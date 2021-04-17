import java.util.HashSet;

/*Time Complexity = Time complexity of inserting m elements of arr1[] in hash table + 
Time complexity of searching n elements of arr2[] in hash table 
= m. O(1) + n . O(1) = O(m) + O(n) = O(m+n)
* Space Complexity = O(m)
*/
public class SubsetArray {
	
	static boolean isSubset(int[] arr1, int[] arr2) {
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i : arr1) {
			hs.add(i);
		}
		
		for(int i=0; i<arr2.length; i++) {
			if(!hs.contains(arr2[i]))
				return false;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
//		int[] arr1 = {11, 1, 13, 21, 3, 7};
//		int[] arr2 = {11, 3, 7, 1};
		
		int[] arr1 = {10, 5, 2, 23, 19};
		int[] arr2 = {19, 5, 33};
		
		if(isSubset(arr1,arr2))
			System.out.print("Array 2 is a subset of array 1");
		else
			System.out.println("Array 2 is not a subset of array 1");
		
	}

}
