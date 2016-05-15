import java.util.*;
public class RunningMedian{
    private MyHeap<Integer> min, max;
    
    public RunningMedian(){
	min = new MyHeap<Integer>();
	max = new MyHeap<Integer>(false);
    }

    public int getMedian(){
	if (min.getSize() == 0 && max.getSize() == 0){
	    throw new NoSuchElementException();
	} else {
	    if (min.getSize() == max.getSize()){
		return (min.peek() + max.peek())/2;
	    }
	    else if (min.getSize() > max.getSize()){
		return min.peek();
	    } else {
		return max.peek();
	    }
	}
    }

    public void add(Integer i){
	if(min.getSize() == 0 && max.getSize() == min.getSize()){
	    min.add(i);
	} else if(i > this.getMedian()) {
	    max.add(i);
	} else {
	    min.add(i);
	}
	if (min.getSize() - max.getSize() !=0 && min.getSize() - max.getSize() != 1){
	    if (min.getSize() > max.getSize()){
		max.add(min.delete());
	    } else {
		min.add(max.delete());
	    }
	} 
    }
    
}
