import java.util.Arrays;
public class Sorts{
    public static void insertionSort(int[] arr){
	int current;
	int pos;
	for (int i = 1; i < arr.length; i++){
	    current = arr[i];
	    pos = i;
	    for (int j = i-1; j > -1 && arr[j] > current; j--){
		arr[j+1] = arr[j];
		pos = j;
	    }
	    arr[pos] = current;
	}
    }

    public static void selectionSort(int[] arr){
	int min;
	int minVal;
	for (int i = 0; i < arr.length; i++){
	    min = i;
	    for (int j = i+1; j < arr.length; j++){
		if (arr[j] < arr[min]){
		    min = j;
		}
	    }
	    minVal = arr[min];
	    arr[min] = arr[i];
	    arr[i] = minVal;
	}
    }
    
    public static void bubbleSort(int[] arr){
	int current;
	int end = arr.length;
	while (end > 0){
	    for (int j = 0; j < end-1; j++){
		if (arr[j] > arr[j+1]){
		    current = arr[j];
		    arr[j] = arr[j+1];
		    arr[j+1] = current;
		}
	    }
	    end--;
	}
    }

    public static int[] merge(int[]aryA, int[]aryB){
	int[] ans = new int[aryA.length + aryB.length];
	int i, j, k;
	i = j = k = 0;
	while (i < aryA.length && j < aryB.length){
	    if (aryA[i] <= aryB[j]){
		ans[k] = aryA[i];
		i++;
	    } else {
		ans[k] = aryB[j];
		j++;
	    }
	    k++;
	}
	if (i == aryA.length){
	    while (j < aryB.length){
		ans[k] = aryB[j];
		j++;
		k++;
	    } 
	} else {
	    while (i < aryA.length){
		ans[k] = aryA[i];
		i++;
		k++;
	    }
	}
	return ans;
    }

    public static void mergesort(int[] arr){
	if (arr.length == 1){
	    return;
	} 
	int[] ans = mergeSortHelper(arr);
	for (int i = 0; i < arr.length; i++){
	    arr[i] = ans[i];
	}
    }
    
    public static int[] mergeSortHelper(int[] arr){
	int pos = arr.length/2;
	int[] A = new int[pos];
	int[] B = new int[arr.length - pos];
	int p = 0;
	for (int i = 0; i < A.length; i++){
	    A[i] = arr[p];
	    p++;
	}
	for (int i = 0; i < B.length; i++){
	    B[i] = arr[p];
	    p++;
	}
	if (pos == 0){
	    return merge(A, B);
	} else {
	    return merge(mergeSortHelper(A), mergeSortHelper(B));
	}	
    }

    /*
    public static void merge(int[] data, int startA, int endA, int startB, int endB){
	int[] temp = new int[endB-startA+1];
	int pos = 0;
	for (int i = startA; i <= endA; i++){
	    temp[pos] = data[i];
	    pos++;
	}
	for (int i = startB; i <= endB; i++){
	    temp[pos] = data[i];
	    pos++;
	}
	pos = 0;
	for (int i = startA; i <= endB; i++){
	    data[i] = temp[pos];
	    pos++;
	}
	System.out.println(Arrays.toString(temp));
	}*/ 

    public static void main(String[]args){
	int[] test = {101,9223,3823232,237323,0,-6,-100,1,36,25,34,332323,32,1};
      	System.out.println(Arrays.toString(test));
	mergeSort(test);
	System.out.println(Arrays.toString(test));
    }
    
}
