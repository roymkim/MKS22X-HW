import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	private LNode prev;
	public LNode(T v){
	    value = v;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public LNode getPrev(){
	    return prev;
	}
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public void setPrev(LNode n){
	    prev = n;
	}
	public String toString(){
	    return value.toString();
	}
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	    {
		private LNode current = head;

		public boolean hasNext(){
		    return current != null;
		}
		public T next(){
		    if(!hasNext()){
			throw new NoSuchElementException();
		    }
		    T value = current.getValue();
		    current = current.getNext();
		    return value;
		}
       		public void remove(){
		    throw new UnsupportedOperationException();
		}
	    };
    } 

    public Iterator<T> backwards(){
	return new Iterator<T>()
	    {
		private LNode current = tail;

                public boolean hasPrev(){
                    return current != null;
                }
                public T prev(){
                    if(!hasPrev()){
                        throw new NoSuchElementException();
                    }
                    T value = current.getValue();
                    current = current.getPrev();
                    return value;
                }
                public void remove(){
                    throw new UnsupportedOperationException();
                }
	    };
    }

    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    public boolean add(T value){
	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	}else{
	    LNode added = new LNode(value);
	    added.setPrev(tail);
	    tail.setNext(added);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if (size() == 0){
	    temp = head;
	    head = null;
	    tail = null;
	} else if (index == 0){
	    temp = head;
	    head = head.getNext();
	    head.setPrev(null);
	} else if (index == size() - 1){
	    temp = tail;
	    tail = tail.getPrev();
	    tail.setNext(null);
	} else {
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    p.setNext(temp.getNext());
	    temp.getNext().setPrev(p);
	} 
	size--;
	return temp.getValue;
    }
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(head);
	    head = temp;
	    if(size==0){
		tail = head;
	    }
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    p.setNext(temp);
	    temp.getNext().setPrev(temp);
	    p.getNext().setPrev(p);
	    if(tail.getNext() != null){
		tail=tail.getNext();
	    }
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }
}
