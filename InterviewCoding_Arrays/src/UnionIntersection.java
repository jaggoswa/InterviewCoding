import java.util.ArrayList;

public class UnionIntersection {
	
	/* Time Complexity = O(m+n)
	 * Space Complexity = O(m+n)
	 */
	static void union(int[] arr1,int[] arr2) {
		
		int len1 = arr1.length;
		int len2 = arr2.length;
		int i = 0, j = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while(i < len1 && j < len2) {
			
			if(arr1[i] < arr2[j]) {
				if(list.size()> 0 && list.get(list.size()-1) != arr1[i])
					list.add(arr1[i]);
				else if(list.size() == 0)
					list.add(arr1[i]);
				i++;
			}
			else if(arr2[j] < arr1[i]) {
				if(list.size() > 0 && list.get(list.size()-1) != arr2[j])
					list.add(arr2[j]);
				else if(list.size() == 0)
					list.add(arr2[j]);
				j++;
			}
			else {
				if(list.size() > 0 && list.get(list.size()-1) != arr1[i])
					list.add(arr1[i]);
				else if(list.size() == 0)
					list.add(arr1[i]);
				i++;
				j++;
			}
		}
		
		while(i < len1) {
			list.add(arr1[i]);
			i++;
		}
		
		while(j < len2) {
			list.add(arr2[j]);
			j++;
		}
		
		for(int elem : list) {
			System.out.print(elem + " ");
		}
	}
	
	/* Time Complexity = O(m), if m < n
	 * Space Complexity = O(m), if m < n
	 */
	static void intersection(int[] arr1,int[] arr2) {
			
			int len1 = arr1.length;
			int len2 = arr2.length;
			int i = 0, j = 0;
			
			ArrayList<Integer> list = new ArrayList<>();
			
			while(i < len1 && j < len2) {
				
				if(arr1[i] < arr2[j])
					i++;
				else if(arr2[j] < arr1[i])
					j++;
				else {
					if(list.size() > 0 && list.get(list.size()-1) != arr1[i])
						list.add(arr1[i]);
					else if(list.size() == 0)
						list.add(arr1[i]);
					i++;
					j++;
				}
			}
			
			for(int elem : list) {
				System.out.print(elem + " ");
			}
		}


	public static void main(String[] args) {
		
		int arr1[] = { 1, 2, 2, 2, 3 };
        int arr2[] = { 2, 3, 4, 5 };
        
        System.out.println("Union of arrays");
        union(arr1,arr2);
        
        System.out.println();
        
        System.out.println("Intersection of arrays");
        intersection(arr1,arr2);
	}

}
