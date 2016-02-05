public class Recursion implements hw01{
    public String name(){
	return "Kim,Roy";
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("Non-negatives please!");
	} else if (n==0) {
	    return 0;
	} else {
	    return guess(n, n/2);
	}
    }

    public double guess(double n, double guess){
       	if (Math.abs(((n/guess) - guess)/guess) <= 1.0e-15){ //it seems like 1e-15 is the smallest number possible
	    return guess;
	} else {
	    return guess(n, (n/guess + guess)/2);
	}
    }
} 