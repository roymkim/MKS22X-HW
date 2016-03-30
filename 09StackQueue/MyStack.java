import java.util.*;
public class MyStack<T> extends MyLinkedList{
    private MyLinkedList<T> stack;
  
    public MyStack(){
	stack = new MyLinkedList<T>(); 
    }

    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
	stack.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return stack.remove(0); 
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return stack.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return stack.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return stack.size()==0;
    }

    public static void main(String[]args){
	MyStack<Integer> a = new MyStack<Integer>();
	Stack<Integer> b = new Stack<Integer>();

	for (int i = 0; i < 100; i++){
	    a.push(i);
	    b.push(i);
	}

	for (int i = 1; i < 100; i++){
	    a.pop();
	    System.out.println(a.peek());
	    b.pop();
	    System.out.println(b.peek());
	}
	
	System.out.println(a.isEmpty() == b.empty());
	
    }
}
