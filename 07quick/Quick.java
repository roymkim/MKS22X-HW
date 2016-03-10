//Credits to Wikipedia for helping me with the algorithim to quickselect
import java.util.Arrays;
public class Quick{
    static boolean DEBUG = false;

    public static String name(){
	return "7,Kim,Roy";
    }

    private static void debug(String s){
	if (DEBUG == true){
	    System.out.println(s);
	}
    }

    private static void swap(int[] ary, int target, int rep){
	int temp = ary[rep];
	ary[rep] = ary[target];
	ary[target] = temp;
    }

    private static int partition(int[] data, int left, int right){
	int pivot = left + (int)(Math.random()*(right - left + 1)); 
	int pivotVal = data[pivot];
	swap(data, pivot, right);
	int pos = left;
	for (int i = left; i < right; i++){
	    if (data[i] < pivotVal){
		swap(data, pos, i);
		pos++;
	    } 
	}
	swap(data, right, pos);
	return pos;
    }
    
    public static int quickselect(int[] data, int k){
	return quickselect(data, k, 0, data.length-1);
    }

    private static int quickselect(int[] data, int k, int left, int right){
	if (left == right){
	    return data[left]; 
	}
	int pivot = partition(data, left, right);
	if (k == pivot){
	    return data[k];
	} else if (k < pivot){
	    return quickselect(data, k, left, pivot-1);
	} else {
	    return quickselect(data, k, pivot+1, right);
	}
    }

    public static void quickSort(int[] data){
	quickSort(data, 0, data.length-1);
    }
    
    private static void quickSort(int[] data, int left, int right){
	if (right > left){
	    int pivot = partition(data, left, right);
	    quickSort(data, left, pivot);
	    quickSort(data, pivot + 1, right);
	}
    }

    public static void main(String[]args){
	int[] test = {0, 0, 0, -1, -2, 0, 1111, 0, 1333, 1, 2, 4, 3, 2, 144};		
	quickSort(test);
	System.out.println(Arrays.toString(test));
    }
}
