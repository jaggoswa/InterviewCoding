import java.util.Random;

public class kthSmallestElement {
	
	static int random(int min, int max) {
		if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
        
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int partition(int[] arr, int left, int right, int pivotIdx) {
		int pivot = arr[pivotIdx];
		swap(arr,right,pivotIdx);
		
		int i = left - 1;
		int j = left;
		
		while(j < right) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr,i,j);
			}
			j++;
		}
		
		swap(arr,right,i+1);
		return i+1;
		
	}
	
	static int quickSelect(int[] arr, int left, int right,int k) {

		int pivotPos = random(left,right);
			
		int partition = partition(arr,left,right,pivotPos);
		
		if(k-1 == partition)
			return arr[partition];
		else if(k-1 < partition) {
			return quickSelect(arr,left,partition-1,k);
		}
		else
			return quickSelect(arr,partition+1,right,k);
	}

	public static void main(String[] args) {
		int[] array = { 10, 4, 5, 8, 6, 11, 26 };
		int k = 3;
		int length = array.length;
		
		if (k > length) {
            System.out.println("Index out of bound");
        }
		else {
            // find kth smallest value
            System.out.println("K-th smallest element in array : "+ quickSelect(array, 0, length - 1, k));
        }

	}

}
