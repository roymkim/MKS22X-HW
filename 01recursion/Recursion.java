public class Recursion implements hw01{
    public String name(){
	return "Kim,Roy";
    }

    public double sqrt(double n){
	
    }

    public double guess(double n, double guess){
	if (n/guess == guess){
	    return n;
	} else {
	    guess(n, (n/guess + guess)/2);
	}
    }
} 