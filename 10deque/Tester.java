public class Tester<T>{
    public static void main(String[]args){
	MyDeque<T> a = new MyDeque<T>();
	Deque b = new ArrayDeque();

	for (int i = 0; i < 1000000; i++){
	    a.addFirst(i);
	    b.addFirst(i);
	}
	System.out.println(a.equals(b));
	
    }
}
