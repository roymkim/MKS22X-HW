public class KnightBoard{
    private int[][]board;
    
    public KnightBoard(int size){
	if (size <= 0){
	    throw new IllegalArgumentException("No Imaginary Boards");
	}
	board = new int[size][size];
    }

    public boolean solve(){
    }

    public void printSolution(){
    }

    // public String toString(){
	//}
    
    //public static void main(String[]args){
	//}
    
    
}
