import java.util.*;
public class MyDeque<T>{
    private int start, end;
    private int size;
    private T[] data;

    public String name(){
	return "7,Roy,Kim";
    }

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10]; 
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[]) new Object[data.length * 2];
	int i = 0;
	for (int j = 0; j < data.length; j++){
	    if (start + j < data.length){
		temp[j] = data[start+j];
	    } else {
		temp[j] = data[i];
		i++;
	    }
	}
	start = 0;
	end = start + size() - 1;
	data = temp;
    }

    public void addFirst(T value){
	if (size == data.length){
	    resize();
	} 
	if (start == 0){
	    start = data.length - 1;
	}
	start--;
	data[start] = value;
	size++;
    }
    
    public void addLast(T value){
	if (size == data.length){
	    resize();
	} 
	if (end == data.length){
	    end = 0;
	}
	end++;
	data[end] = value;
	size++;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T removed = data[start];
	data[start] = null;
	if (start < data.length - 1){
	    start++;
	} else {
	    start = 0;
	}
	size--;
	return removed;
    }
    
    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T removed = data[end];
	if (end > 0){
	    end--;
	} else {
	    end = data.length - 1;
	}
	size--;
	return removed;
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public int size(){
	return size;
    }
}
