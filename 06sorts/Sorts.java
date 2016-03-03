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

    public static void merge(int[] data, int startA, int endA, int startB, int endB){
	
    } 

    public static void fillRandom(int[] ary){
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random() * 100);
	}
    }

    public static void swap(int[] ary, int target, int rep){
	int temp = ary[rep];
	ary[rep] = ary[target];
	ary[target] = temp;
    }
    
}
