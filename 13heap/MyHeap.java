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
    }
    
    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/
    private void pushUp(int k){
	if (k > 1 && compare(data[k], data[k/2])){
	    
	}
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
