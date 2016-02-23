public class Bronze{
    /**
     *precondition: 
     *-Pasture rows and columns are between 3 and 100 inclusive.
     *-The depth at which cows push the land down is between 1 and 40 inclusive
     *-Pasture is stomped in a 3x3 Grid given that higher elevations are stomped first
     *postcondition:
     *-The pasture is adjusted with the given order to stomp
     */
    public void stomp(int[][] pasture, int row, int col, int depth){
	row = row--; //adjusting the coordinates so that the first col and row is 1,1 not 0,0
	col = col--;
	for (int d = depth; d > 0; d--){
	    int maxElevation = pasture[row][col];
	    for (int r = row; r < row+3; r++){
		for (int c = col; c < col+3; c++){
		    if (pasture[r][c] > maxElevation){
			maxElevation = pasture[r][c];
		    }
		}
	    }
	    for (int r = row; r < row+3; r++){
		for (int c = col; c < col+3; c++){
                    if (pasture[r][c] == maxElevation){
			pasture[r][c]--;
                    }
                }
            }
	}
    }

    public int calculateLakeVolume(int[][] pasture, int elevation){
	int sum = 0;
	for (int r = 0; r < pasture.length; r++){
	    for (int c = 0; c < pasture[r].length; c++){
		if (pasture[r][c] < elevation){
		    sum+=(elevation - pasture[r][c]);
		}
	    }
	}
	return sum * 72 * 72;
    }

    public static void main(String[]args){
	
    }
}