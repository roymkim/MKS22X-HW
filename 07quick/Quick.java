//Credits to Mr. K and Wiki 
import java.util.Arrays;
public class Quick{
    static boolean DEBUG = true;

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

    private static int[] partition(int[] data, int left, int right){
	int pivot = left + (int)(Math.random()*(right - left + 1));
	int[] temp = new int[right - left + 1];
	int[] limits = new int[2];
	int pivotVal = data[pivot];
	int less = 0;
	int more = temp.length - 1;
	for (int i = left; i < right + 1; i++){
	    if (data[i] < pivotVal){
		temp[less] = data[i];
		less++;
	    } else if (data[i] > pivotVal){
		temp[more] = data[i];
		more--;
	    }
	}
	for (int i = less; i < more +1; i++){
	    temp[i] = pivotVal;
	}
	int j = 0;
	for (int i = left; i < right+1; i++){
	    data[i] = temp[j];
	    j++;
	}
	limits[0] = left + less - 1;
	limits[1] = left + more + 1;
	return limits;
    }
   
    public static void quickSort(int[] data){
	quickSort(data, 0, data.length-1);
    }
    
    private static void quickSort(int[] data, int left, int right){
	if (right > left){
	    int[] pivot = partition(data, left, right);
	    int less = pivot[0];
	    int more = pivot[1];
	    quickSort(data, left, less);
	    quickSort(data, more, right);
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
	return quickselectOld(data, k, 0, data.length-1);
    }

    private static int quickselectOld(int[] data, int k, int left, int right){
	if (left == right){
	    return data[left]; 
	}
	int pivot = partitionOld(data, left, right);
	if (k == pivot){
	    return data[k];
	} else if (k < pivot){
	    return quickselectOld(data, k, left, pivot-1);
	} else {
	    return quickselectOld(data, k, pivot+1, right);
	}
    }

    public static void quickSortOld(int[] data){
	quickSortOld(data, 0, data.length-1);
    }
    
    private static void quickSortOld(int[] data, int left, int right){
	if (right > left){
	    int pivot = partitionOld(data, left, right);
	    quickSortOld(data, left, pivot);
	    quickSortOld(data, pivot + 1, right);
	}
    }

    public static void main(String[]args){
	int[] a = new int[4000000];
	int[] b = new int[a.length];
	for (int i = 0; i < a.length; i++){
	    a[i] = (int)(((Math.random() * 4))); //2) - 1)* Integer.MAX_VALUE);
	    b[i] = a[i];
	}	
	quickSort(a);
	//Arrays.sort(a);
	//quickSortOld(a);
	//System.out.println("Done: Sorted="+Arrays.equals(a,b));	
	//System.out.println(Arrays.toString(a));
    }
}
