public class Recursion implements hw01{
    public String name(){
	return "Kim,Roy";
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("Non-negatives please!");
	} else {
	    return guess(n, n/2);
	}
    }

    public double guess(double n, double guess){
	if (n/guess == guess){
	    return n;
	} else {
	    return guess(n, (n/guess + guess)/2);
	}
    }
} 