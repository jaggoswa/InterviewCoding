import java.util.Arrays;

public class BuildingBridges {
	
	static class Bridge implements Comparable<Bridge>{
		int n;
		int s;
		
		Bridge(int n, int s){
			this.n = n;
			this.s = s;
		}

		public int compareTo(Bridge o) {
			if(this.n != o.n)
				return this.n - o.n;
			return o.s - this.s;
		}
	}
	
	public static int maximumBridges(Bridge[] bridges) {
		
		Arrays.sort(bridges, (a,b) -> Integer.compare(a.n, b.n));
		int[] dp = new int[bridges.length];
		Arrays.fill(dp, 1);
		int maxBridges = 1;
		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				if(bridges[i].s >= bridges[j].s) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			maxBridges = Math.max(maxBridges, dp[i]);
		}
		
		return maxBridges;
		
	}
	

	public static void main(String[] args) {
		int n=8;
		int[][] banks = {{8,1,4,3,5,2,6,7},{1,2,3,4,5,6,7,8}};
		Bridge[] bridges = new Bridge[n];
		
		for(int i=0; i<banks[0].length; i++) {
			bridges[i] = new Bridge(banks[0][i],banks[1][i]);
		}

		System.out.print(maximumBridges(bridges));
	}

}
