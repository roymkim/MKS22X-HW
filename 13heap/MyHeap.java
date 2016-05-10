import java.util.*;
@SuppressWarnings("unchecked")

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
	size = array.length-1;
	isMax = true;
	heapify();
    }

    public boolean compare(T first, T second){
	if(isMax){
	    return first.compareTo(second) > 0;
	} else {
	    return second.compareTo(first) > 0;
	}
    }

    public void swap(int i, int j){
	T temp = data[j];
	data[j] = data[i];
	data[i] = temp;
    }

    /**pushDown
       precondition: datas[k]'s children are valid heaps
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data[k] and is a valid heap
    **/
    private void pushDown(int k){ //ty dojo
	if(k*2+1 <= size){
	    if(compare(data[k*2], data[k*2+1])){
		swap(k, k*2);
		pushDown(k*2);
	    } else {
		swap(k, k*2+1);
		pushDown(k*2+1);
	    }
	} else {
	    if (k * 2 <= size){
		swap(k, k*2);
	    }
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
	if (k > 1 && compare(data[k],data[k/2])){
	    swap(k, k/2);
	    pushUp(k/2);
	}
    }
    
    private void heapify(){
	for (int i = size/2; i > 0; i--){
	    pushDown(i);
	}
    }
    
    public T delete(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T temp = data[1];
	data[1] = data[size];
	size--;
	pushDown(1);
	return temp;
    }

    public T peek(){
	if (size == 0){
	    throw new NoSuchElementException();
	} else {
	    return data[1];
	}
    }
    
    public void add(T x){
	if (size+1 == data.length){
	    doubleSize();
	}
	size++;
	data[size] = x;	
       	pushUp(size);
    }
    
    private void doubleSize(){
	T[] temp = (T[])(new Comparable[size*2+1]);
	for (int i = 1; i <= size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    public String toString(){
	String temp = "[";
	for (int i = 1;i <= size;i++){
	    if (i == size) {
		temp += data[i];
	    } else {
		temp+=data[i]+", ";
	    }
	}
	temp += "]";
	return temp;
    }
    
    public MyHeap(boolean isMax){
	data = (T[])(new Comparable[10]);
	size = 0;
	this.isMax = isMax;
    }
    
    public MyHeap(T[] array, boolean isMax){
	data = array;
	size = array.length-1;
	this.isMax = isMax;
	heapify();
    }
    
    
}
