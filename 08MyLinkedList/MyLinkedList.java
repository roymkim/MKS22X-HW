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
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public int get(int index){
	if (index < 0 || index >= size){
	    throw new IllegalArgumentException("Out of Bounds"); //I want to return null though...
	}
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int newValue){
	if (index < 0 || index >= size){
	    throw new IllegalArgumentException("Out of Bounds"); //I want to return null...
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
	    throw new IllegalArgumentException("Out of Bounds");
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
	LNode current = start;
	LNode temp = new LNode(value);
	for (int i = 0; i < index; i ++){
	    current = current.getNext();
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
	size++;
	return true;
    }

    public boolean add(int value){
	if (start == null){
	    start = new LNode(value);
	} else {
	    LNode current = start;
	    while(current.getNext() != null){
		current = current.getNext();
	    } 
	current.setNext(new LNode(value));
	}
	size++;
	return true;
    }

    public int indexOf(int value){
	return 0; //not done yet...
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
	int i = 0;
	while(i < 100){
	    m.add(i);
	    i++;
	}
	m.add(54);
	m.add(-10);
	m.add(47);
	System.out.println(m);
    }
}
