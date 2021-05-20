import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Box{
	int length, width, height;
	
	Box(int length, int width, int height){
		this.length = length;
		this.width = width;
		this.height = height;
	}
}

/* Time Complexity = O(n^2)
 * Space Complexity = O(n)
 */
public class BoxStacking {
	
	public static List<Box> createAllRotations(List<Box> boxes){
		
		List<Box> rotations = new ArrayList<>(); 
		
		for(Box box : boxes) {
			rotations.add(box);
			
			rotations.add(new Box(Math.max(box.length, box.height),
								  Math.min(box.length,box.height),
								  box.width));
			
			rotations.add(new Box(Math.max(box.width, box.height),
					  			  Math.min(box.width,box.height),
					  			  box.length));
		}
		
		return rotations;
	}
	
	public static int findMaxHeight(List<Box> boxes) {
		
		List<Box> rotations = createAllRotations(boxes);
		
		Collections.sort(rotations,(x,y) -> (y.length * y.width - x.length * x.width));
		
		int[] maxHeight = new int[rotations.size()];
		
		for(int i=0; i<rotations.size(); i++) {
			maxHeight[i] = rotations.get(i).height;
		}
		
		for(int i=1; i<rotations.size(); i++) {
			for(int j=0; j<i; j++) {
				if((rotations.get(i).length < rotations.get(j) .length)
					&& (rotations.get(i).width < rotations.get(j) .width)) {
					
					maxHeight[i] = Math.max(maxHeight[i], rotations.get(i).height + maxHeight[j]);
				}
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<rotations.size(); i++) {
			System.out.println(maxHeight[i]);
			max = Math.max(max, maxHeight[i]);
		}
		
		return max;
	}

	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(38,25,45));
        boxes.add(new Box(76,35,3));
//        boxes.add(new Box(45,23,12));
//        boxes.add(new Box(6, 3, 8));
          
        System.out.println("The maximum possible "+
                           "height of stack is " + 
                           findMaxHeight(boxes));

	}

}
