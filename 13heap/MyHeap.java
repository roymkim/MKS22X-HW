import java.util.*;
@SuppressWarnings("unchecked");
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;
    
    public MyHeap(){
	data = (T[])(new Comparable[10]);
	isMax = true;
	size = 0;
    }
    
    public MyHeap(T[] array){
	data = array;
	isMax = true;
	size = array.length;
    }

    /**pushDown
       precondition: datas[k]'s children are valid heaps
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data[k] and is a valid heap
    **/
    private void pushDown(int k){
	int left = 2 * (k + 1) - 1;
	int right = 2 * (k + 1);
	int temp = data[k];
	if (right >= size || temp < data[left] && temp < data[right]){
	    return -1;
	} else if (data[left] < data[right]){
	    data[i] = data[left];
	    data[left] = temp;
	    return left;
	} else {
	    data[i] = data[right];
	    data[right] = temp;
	    return right;
	}
    }
    
    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/
    private void pushUp(int k){
	while (k > 1 && compare(data[k/2].compareTo(data[k]))){
	    swap(k, k/2);
	    k = k/2; 
	}
    }
    
    private void swap(int i, int j){
	T temp = data[j];
	data[j] = data[i];
	data[i] = temp;
    }
    
    private void heapify(){
    }
    
    public T delete(){
    }

    public T peek(){
	if (size == 0){
	    throw new NoSuchElementException();
	} else {
	    return data[1];
	}
    }
    
    public void add(T x){
	if (size == data.length){
	    this.doubleSize();
	}
	data[size] = x;
	size++;
    }
    
    private void doubleSize(){
	T[] temp = (T[])(new Comparable[data.length*2+1]);
	for (int i = 1; i <= size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    public String toString(){
	String temp = "";
	for (int i = 1;i <= size;i++){
	    temp+=data[i]+" ";
	}
	return temp;
    }
    
    //do this last
    public MyHeap(boolean isMax){
    }
    
    public MyHeap(T[] array, boolean isMax){
    }
    
}
