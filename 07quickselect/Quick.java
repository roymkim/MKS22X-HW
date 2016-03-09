//Credits to Wikipedia for helping me with the algorithim
import java.util.Random;
public class Quick{
    public static String name(){
	return "7,Kim,Roy";
    }

    private static void swap(int[] ary, int target, int rep){
	int temp = ary[rep];
	ary[rep] = ary[target];
	ary[target] = temp;
    }

    private static int partition(int[] data, int left, int right){
	Random rand = new Random();
	int pivot = left + rand.nextInt(right-left+1); //(int)(left + Math.random()*(right - left + 1)) 
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
    
    private static int quickselect(int[] data, int k){
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

    private static void quickSort(int[] data, int k, int left, int right){
	
    }

    private static void main(String[]args){
    
    }
}
