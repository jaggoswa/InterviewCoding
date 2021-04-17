/*Time Complexity = O(floors * eggs) * O(floors) = O(floor^2 * eggs)
  since there are floors * eggs subproblems and for each subproblem 
  we are doing a simulation for each floor
  Space Complexity = O(floors * eggs)
 */
public class EggDropProblem {
	
	static int eggDrop(int totalEggs, int totalFloors) {
		int[][] dp = new int[totalEggs+1][totalFloors+1];
		
		/*
		 If we have 0 floors we need 0 trials, no matter the egg amount given
      	 If we have 1 floor we need 1 trial, no matter the egg amount given
		 */
		for(int eggs=0; eggs<=totalEggs; eggs++) {
			dp[eggs][0] = 0;
			dp[eggs][1] = 1;
		}
		
		/*If we have 1 egg...no matter what floors we get, our approach will
          be to do 'floorAmount' drops*/
		
		for(int floors=0; floors<=totalFloors; floors++) {
			dp[1][floors] = floors;
		}
		
		for(int eggs=2; eggs<=totalEggs;eggs++) {
			for(int floors=2; floors<=totalFloors; floors++) {
				
				dp[eggs][floors] = Integer.MAX_VALUE;
				
				for(int attemptFloor=1; attemptFloor<=floors; attemptFloor++) {
					
					/* We add 1 to account for the one drop at this level 
					 followed by checking if the egg breaks or not */
					int dropsAtThisLevel = 1 + Math.max(dp[eggs-1][attemptFloor-1],dp[eggs][floors-attemptFloor]);
					dp[eggs][floors] = Math.min(dp[eggs][floors], dropsAtThisLevel);
				}
				
			}
		}
		
		return dp[totalEggs][totalFloors];
	}

	public static void main(String[] args) {
		int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst"
                           + " case with "
                           + n + "  eggs and "
                           + k + " floors is " + eggDrop(n, k));

	}

}
