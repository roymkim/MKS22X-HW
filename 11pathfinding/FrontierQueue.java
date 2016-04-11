import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    Queue<T> FrontierQueue = new ArrayDeque<T>();

    public void add(T element){
	FrontierQueue.add(element);
    }

    public T next(){
	if (FrontierQueue.isEmpty()){
	    throw new NoSuchElementException();
	}
	return FrontierQueue.remove();
    }

    public boolean hasNext(){
	return !(FrontierQueue.size() == 0);
    }
}