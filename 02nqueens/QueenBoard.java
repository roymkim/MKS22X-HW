public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	for (int c = 0; c<board.length; c++){
	    return solveH(c);
	}
	return false;
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	if (col >= board.length){//past last column
	    return true;
	}
	for (int r = 0; r < board.length; r++){
	    if (addQueen(r, col)){
		addQueen(r, col);
		if (solveH(col+1)){
		    return true;
		} 
		removeQueen(r, col);
		System.out.println(toString());
	    }
	}
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	      all negative numbers, and 0's are replaced with '_'
	         and all 1's are replaced with 'Q'
	*/
	String ans = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (board[r][c] < 0){
		    ans+=" \t";
		} else if (board[r][c] == 1){
		    ans+="Q\t";
		} else {
		    ans+="_\t";
		}
	    }
	    ans+="\n";
	}
	System.out.println(ans);
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
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
    QueenBoard b = new QueenBoard(4);
        System.out.println(b);
	b.addQueen(1,0);
       	b.addQueen(1,3);
        System.out.println(b);
	//b.removeQueen(3,0);
        //System.out.println(b);
       	System.out.println(b.solve());
	b.printSolution();
    }
    
    
}