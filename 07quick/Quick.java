//Credits to Mr. K and Wiki 
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

    private static int partitionOld(int[] data, int left, int right){
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
    
    public static int quickselectOld(int[] data, int k){
	return quickselect(data, k, 0, data.length-1);
    }

    private static int quickselectOld(int[] data, int k, int left, int right){
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

    public static void quickSortOld(int[] data){
	quickSort(data, 0, data.length-1);
    }
    
    private static void quickSortOld(int[] data, int left, int right){
	if (right > left){
	    int pivot = partition(data, left, right);
	    quickSort(data, left, pivot);
	    quickSort(data, pivot + 1, right);
	}
    }

    public static void main(String[]args){
	int[] a = new int[4000000];
	int[] b = new int[a.length];
	for (int i = 0; i < a.length; i++){
	    a[i] = (int)(Math.random() * 3); //Integer.MAX_VALUE);
	    b[i] = a[i];
	}
	//quickSort(a);
	Arrays.sort(a);
	//System.out.println("Done: Sorted="+Arrays.equals(a,b));
    }
}
