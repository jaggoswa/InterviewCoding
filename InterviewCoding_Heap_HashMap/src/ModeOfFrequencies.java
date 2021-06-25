import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ModeOfFrequencies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0; i<t; i++){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int j=0; j<n; j++){
	            arr[j] = sc.nextInt();
	        }
	        
	        HashMap<Integer, Integer> hm1 = new HashMap<>();
		    HashMap<Integer, Integer> hm2 = new HashMap<>();
		    
		    for(int a : arr){
		        hm1.put(a, hm1.getOrDefault(a, 0) + 1);
		    }
		    
		    int mode = 0;
		    int maxFreq = 0;
		    
		    for(Map.Entry<Integer, Integer> e : hm1.entrySet()){
		        int val = e.getValue();
		        int freq = hm2.getOrDefault(val, 0) + 1;
		        if(freq > maxFreq || (freq == maxFreq && val < mode)){
		        	maxFreq = freq;
		            mode = val;
		        }
		        hm2.put(val, freq);
		    }
		    
		    System.out.println(mode);
		
	    }

	}

}
