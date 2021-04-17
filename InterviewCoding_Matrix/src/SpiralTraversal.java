
public class SpiralTraversal {
	
	static void printSpiralTraversal(int[][] m) {
		int rows = m[0].length;
		int cols = m.length;
		
		int top = 0, bottom = rows-1, left = 0, right = cols-1;
		int dir = 0;
		
		while(top <= bottom && left <= right) {
			
			if(dir == 0) {
				for(int i=left; i<=right; i++)
					System.out.print(m[top][i] + " ");
				top++;
			}
			else if(dir == 1) {
				for(int i=top; i<=bottom; i++)
					System.out.print(m[i][right] + " ");
				right--;
			}
			else if(dir == 2) {
				for(int i=right; i>= left; i--)
					System.out.print(m[bottom][i] + " ");
				bottom--;
			}
			else if(dir == 3) {
				for(int i=bottom; i>=top; i--)
					System.out.print(m[i][left] + " ");
				left++;
			}
			
			dir = (dir+1)%4;
		}
	}

	public static void main(String[] args) {
		
		int[][] matrix = {{2,4,6,8},{5,9,12,16},{2,11,5,9},{3,2,1,8}};
		
		printSpiralTraversal(matrix);

	}

}
