
public class MyLinkedList{
    private class LNode{
	private int value;
	private LNode next; 

	public LNode(int v){
	    value = v;
	}

	public LNode(int value, LNode next){
	    this.value = value;
	    this.next = next;
	}

	public int getValue(){
	    return value;
	}

	public void setValue(int v){
	    value = v;
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

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public String name(){
	return "Kim,Roy";
    }
    
    public int get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds"); 
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int newValue){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds"); 
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	int ans = current.getValue();
	current.setValue(newValue);
	return ans;
    }

    public int size(){
	return size;
    }
    
    public int remove(int index){ // not done yet.
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Out of Bounds");
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
     	    current = current.getNext();
	}
	int ans = current.getNext().getValue();
	current.setNext(current.getNext());
	size--;
	return ans;
    }

    public boolean add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Out of Bounds");
	}
	LNode current = start;
	if (index == size){
	    add(value);
	    return true;
	} 
	for (int i = 1; i < index; i++){	
	    current = current.getNext();
	}
	LNode temp = new LNode(value);
	temp.setNext(current.getNext());
	current.setNext(temp);
	size++;
	return true;
    }

    public boolean add(int value){
	if (start == null){
	    start = new LNode(value);
	    tail = start;
	} else {
	    LNode temp = new LNode(value);
	    tail.setNext(temp);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }

    public int indexOf(int value){
	LNode current = start;
	int index = 0;
	while (current.getNext() != null){
	    if (current.getValue() == value){
		return index;
	    }
	    index++;
	    current = current.getNext();
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
	MyLinkedList m = new MyLinkedList();
	System.out.println(m);
	int i = 0;
	while(i < 100){
	    m.add(i);
	    i++;
	}
	m.add(54);
	m.add(-10);
	m.add(47);
	System.out.println(m);
	System.out.println(m.indexOf(5));
	m.add(4, 5);
	System.out.println(m);
	System.out.println(m.indexOf(5));
	System.out.println(m.get(104));
    }
}
