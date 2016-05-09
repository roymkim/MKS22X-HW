import java.util.*;
@SuppressWarnings("unchecked");
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    
    public MyHeap()
	public MyHeap(T[] array)
	
	/**pushDown
	   precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
      shifted to the correct spot.
      -data[k] and is a valid heap
	**/
	private void pushDown(int k)
	
	/**pushUp
      precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
      shifted to the correct spot.
      -data is a valid heap
	**/
	private void pushUp(int k)
	private void heapify()
	public T delete()
	public void add(T x)
	private void doubleSize()
	public String toString()
	
	//do this last
	public MyHeap(boolean isMax)
	public MyHeap(T[] array, boolean isMax)
	
	}
