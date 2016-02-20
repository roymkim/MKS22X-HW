public class KnightBoard{
    private int[][]board;
    /*
    private static boolean DEBUG = false;

    private void debug(String s){
	if (DEBUG)
	    System.out.println(s);
    }
    */
    public KnightBoard(int size){
	if (size <= 0){
	    throw new IllegalArgumentException("No Imaginary Boards");
	}
	board = new int[size][size];
    }

    public KnightBoard(int row, int col){
	if (row <= 0 || col <= 0){
	    throw new IllegalArgumentException("No Imaginary Boards");
	}
	board = new int[row][col];
    }

    public void resetBoard(){
	for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                board[r][c] = 0;
            }
        }
    }

    public boolean solve(){
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (solveH(r,c,1)){
		    return true;
		}
		resetBoard();
	    }
	}
	return false;
    }

    public boolean solveH(int row, int col, int ctr){
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length){
            return false;
        }        
	for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                if (board[r][c] >= ctr){
                    board[r][c] = 0;
                }
            }
        }
	if (ctr == board.length * board[row].length + 1){    
	    return true;
        } else if (board[row][col] != 0) {
	    return false;
	} else {
	    board[row][col] = ctr;
	    return (solveH(row+1, col+2, ctr+1)||
		    solveH(row-1, col+2, ctr+1)||
		    solveH(row+1, col-2, ctr+1)||
		    solveH(row-1, col-2, ctr+1)||
		    solveH(row+2, col+1, ctr+1)||
		    solveH(row-2, col+1, ctr+1)||
		    solveH(row+2, col-1, ctr+1)||
		    solveH(row-2, col-1, ctr+1));
	}
    }

    public void printSolution(){
	String solution = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (board.length*board[r].length >= 10){
		    if (board[r][c] / 10 == 0){
			solution+="_"+board[r][c]+"\t";
		    } else {
			solution+=board[r][c]+"\t";
		    }
		}
	    }
	    solution+="\n";
	}
	System.out.println(solution);
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	KnightBoard b = new KnightBoard(3, 7);
	System.out.println(b.solve());
	b.printSolution();
    }
}
