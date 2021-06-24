import java.util.Arrays;

public class BuildingBridges {
	
	public static class Bridge{
		
		int n;
		int s;
		
		Bridge(int n, int s){
			this.n = n;
			this.s = s;
		}
		
	}
	
	public static int maximumBridges(Bridge[] bridges) {
		
		Arrays.sort(bridges,(a,b) -> Integer.compare(a.n, b.n));
		int[] dp = new int[bridges.length];
		Arrays.fill(dp,1);
		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				if(bridges[i].s >= bridges[j].s)
					dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int elem : dp) {
			max = Math.max(max, elem);
		}
		return max;
	}

	public static void main(String[] args) {
		int n=4;
		Bridge[] bridges = new Bridge[n];
		bridges[0] = new Bridge(6,2);
		bridges[1] = new Bridge(4,3);
		bridges[2] = new Bridge(2,6);
		bridges[3] = new Bridge(1,5);
		
		System.out.print(maximumBridges(bridges));
	}

}
