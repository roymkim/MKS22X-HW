import java.util.Arrays;
public class mergeSort{
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

    public static void main(String[]args){
	int[] A = {1,2,5,100,1002,50000};
	int[] B = {-1,-5,12};
	System.out.println(Arrays.toString(merge(A, B)));
    }
}