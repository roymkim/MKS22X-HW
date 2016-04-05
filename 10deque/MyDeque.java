public class MyDeque<T>{
    private int start, end;
    private int size;
    private T[] data;

    public MyDeque(){
	temp = (T[]) new Object[10];
    }
    
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
	if (end = data.length){
	    end = 0;
	}
	data[end] = value;
	end++;
	size++;
    }

    public T removeFirst(){
	
    }
    
    //    public T removeLast(){
    //return;
    //}

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T) data[start+1];
    }

    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T) data[end-1];
    }

    public String toString(){
	String ans = "[ ";
	int n = 
    }
}
