import java.util.*;
public class MyDeque<T>{
    private int start, end;
    private int size;
    private T[] data;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10]; 
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[]) new Object[data.length * 2];
	for (int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    public void addFirst(T value){
	if (size == data.length){
	    resize();
	} 
	if (start < 0){
	    start = data.length - 1;
	}
	data[start] = value;
	start--;
	size++;
    }
    
    public void addLast(T value){
	if (size == data.length){
	    resize();
	} 
	if (end == data.length){
	    end = 0;
	}
	data[end] = value;
	end++;
	size++;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = data[start];
	if (start == data.length-1){
	    start = 0;
	} else {
	    start++;
	}
	size--;
	return ans;
    }
    
    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T ans = data[end];
	if (end == 0){
	    end = data.length-1;
	} else {
	    end--;
	}
	size--;
	return ans;
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[start+1];
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[end-1];
    }
}
