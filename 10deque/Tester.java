public class Tester<T>{
    T[] data;

    @SuppressWarnings("unchecked");
    public Tester(){
	data = (T[]) new Object[10];
    }

    public void add(T n){
	data[0] = n;
    }

    public T get(){
	return data[0];
    }

    public static void main(String[]args){
	Tester<String> x = new Tester<String>();
	x.add("fish");
	System.out.println(x.get());
    }
}