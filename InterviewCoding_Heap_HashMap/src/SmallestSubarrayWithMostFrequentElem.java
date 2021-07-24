import java.util.HashMap;

public class SmallestSubarrayWithMostFrequentElem {
	
	static class Pair{
			
		int startIdx;
		int endIdx;
		int frequency;
		
		Pair(int start, int end, int frequency){
			this.startIdx = start;
			this.endIdx = end;
			this.frequency = frequency;
		}
	}
		
	public static Pair smallestSubarray(int[] arr) {
		
		HashMap<Integer,Pair> hm = new HashMap<>();
		
		int startIdx = 0;
		int endIdx = 0;
		int maxFreq = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			
			int start, freq, end;
			if(hm.containsKey(arr[i])) {
				start = hm.get(arr[i]).startIdx;
				freq = hm.get(arr[i]).frequency + 1;
				end = i;
				hm.put(arr[i], new Pair(start, end, freq));
			}
			else {
				start = i;
				end = i;
				freq = 1;
				hm.put(arr[i], new Pair(i, i, 1));
			}
			
			if(freq > maxFreq 
			   || (freq == maxFreq && end-start < endIdx - startIdx)) {
				startIdx = start;
				endIdx = end;
				maxFreq = freq;
			}
		}
		
		return new Pair(startIdx, endIdx, maxFreq);
	}


	public static void main(String[] args) {
		
		int[] arr = {4, 1, 1, 2, 2, 1, 3, 3};
		Pair p = smallestSubarray(arr);
		
		for(int i=p.startIdx; i<=p.endIdx; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
