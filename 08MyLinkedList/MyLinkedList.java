public class MyLinkedList<T>{
    private class LNode{
	private T thing;
	private LNode next; 

	public LNode(T thing){
	    this.thing = thing;
	    next = null;
	}

	public LNode(T thing, LNode next){
	    this.thing = thing;
	    this.next = next;
	}

	public T getValue(){
	    return thing;
	}

	public void setValue(T thing){
	    this.thing = thing;
	}

	public LNode getNext(){
	    return next;
	}

	public void setNext(LNode n){
	    next = n;
	}
    }

    private LNode start;
    private LNode tail;
    private int size;
    private T thing;

    public MyLinkedList(){
	start = null;
	tail = null;
	size = 0;
    }

    public String name(){
	return "Kim,Roy";
    }
    
    public T get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds"); 
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public void set(int index, T newThing){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds"); 
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	T ans = current.getValue();
	current.setValue(newThing);
    }

    public int size(){
	return size;
    }
    
    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds");
	}
	T ans;
	LNode current = start;
	if (index == 0){
	    ans = current.getValue();
	    start = current.getNext();
	} else {
	    for (int i = 0; i < index - 1; i++){
		current = current.getNext();
	    }
	    ans = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	}	    
	size--;
	return ans;
    }

    public boolean add(int index, T thing){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Out of Bounds");
	}
	LNode current = start;
	LNode temp = new LNode(thing);
	if (index == size){
	    add(thing);
	    return true;
	} 
	if (index == 0){
	    temp.setNext(current);
	    start = temp;
	    size++;
	    return true;
	}
	for (int i = 1; i < index; i++){	
	    current = current.getNext();
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
	size++;
	return true;
    }

    public boolean add(T thing){
	if (start == null){
	    start = new LNode(thing);
	    tail = start;
	} else {
	    LNode temp = new LNode(thing);
	    tail.setNext(temp);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }

    public int indexOf(T thing){
	LNode current = start;
	int index = 0;
	while (current.getNext() != null){
	    if (current.getValue().equals(thing)){
		return index;
	    }
	    index++;
	    current = current.getNext();
	}
	if (current.getValue().equals(thing)){
	    return size-1;
	}
	return -1;
    }

    public String toString(){
	LNode current = start;
	String ans = "[";
	while(current != null){
	    ans += current.getValue();
	    if (current.getNext()!=null){
		ans+=", ";
	    }
	    current = current.getNext();
	}
	return ans+"]";
    }


    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();
	int i = 0;
	while(i < 50){
	    m.add("blues");
	    i++;
	}
	m.add("crew");
	System.out.println(m.size);
	System.out.println(m);
	m.add(50, "LION");
	m.add(5, "TIGER");
	System.out.println(m.indexOf("crew"));
	System.out.println(m.size);
	System.out.println(m.remove(50));
	System.out.println(m);
    }
}
