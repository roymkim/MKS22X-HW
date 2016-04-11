import java.util.*;
public class FrontierStack<T> implements Frontier<T>{
    Stack<T> FrontierStack = new Stack<T>();
    
    public void add(T element){
	FrontierStack.push(element);
    }
    
    public T next(){
	if (FrontierStack.isEmpty()){
	    throw new NoSuchElementException();
	}
	return FrontierStack.pop();
    }

    public boolean hasNext(){
	return !FrontierStack.isEmpty();
    }
}

