/*Time Complexity= O(n^3)
 * Space Complexity = O(n^2)*/
public class BooleanParenthesization {
	
	static int noOfWays(String str1, String str2) {
		
int n = str1.length();
		
		int[][] dpt = new int[n][n];
		int[][] dpf = new int[n][n];
		
		for(int g=0; g<n; g++) {
			for(int i=0,j=g; j<n; i++,j++) {
				
				if(g == 0) {
					char ch = str1.charAt(i);
					
					if(ch == 'T') {
						dpt[i][j] = 1;
						dpf[i][j] = 0;
					}else {
						dpf[i][j] = 1;
						dpt[i][j] = 0;
					}
				}else {
					for(int k=i; k<j; k++) {
						char op = str2.charAt(k);
						int ltc = dpt[i][k];
						int rtc = dpt[k+1][j];
						int lfc = dpf[i][k];
						int rfc = dpf[k+1][j];
						
						if(op == '&') {
							
							dpt[i][j] += ltc * rtc;
							dpf[i][j] += ltc * rfc + lfc * rtc + lfc * rfc;
							
						}else if(op == '|') {
							
							dpt[i][j] += ltc * rfc + lfc * rtc + ltc * rtc;
							dpf[i][j] += lfc * rfc;
							
						}else {
							
							dpt[i][j] += ltc * rfc + lfc + rtc;
							dpf[i][j] += ltc * rtc + lfc * rfc;
							
						}
					}
				}
				
			}
		}
		
		return dpt[0][n-1];
 	}

	public static void main(String[] args) {
		String str1 = "TFTF";
		String str2 = "&|^";
		
		int ways = noOfWays(str1,str2);
		
		System.out.println("Number of ways to parenthesize is: " + ways);

	}

}
