public class MyDeque{
    private int start, end;
    private int size;
    private T[] data;

    public MyDeque<T>{
	data = (T[]) new Object[10];
    }
    
    private void resize(){
    
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
    
    public T removeLast(){
    }

    public T getFirst(){
    }

    public T getLast(){
    }
}
