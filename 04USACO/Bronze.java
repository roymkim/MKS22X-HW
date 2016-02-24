import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Bronze{
    /**
     *precondition: 
     *-Pasture rows and columns are between 3 and 100 inclusive.
     *-The depth at which cows push the land down is between 1 and 40 inclusive
     *-Pasture is stomped in a 3x3 Grid given that higher elevations are stomped first
     *postcondition:
     *-The pasture is adjusted with the given order to stomp
     */
    public static void stomp(int[][] pasture, int row, int col, int depth){
	for (int d = depth; d > 0; d--){
	    int maxElevation = pasture[row][col];
	    for (int r = row-1; r < row+2; r++){//adjusting coordinates
		for (int c = col-1; c < col+2; c++){
		    if (pasture[r][c] > maxElevation){
			maxElevation = pasture[r][c];
		    }
		}
	    }
	    for (int r = row-1; r < row+2; r++){
		for (int c = col-1; c < col+2; c++){
                    if (pasture[r][c] == maxElevation){
			pasture[r][c]--;
                    }
                }
            }
	}
    }

    public static int calculateLakeVolume(int[][] pasture, int elevation){
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
    
    public static String toString(int[][] array){
	String ans = "";
	for (int r = 0; r < array.length; r++){
	    for (int c = 0; c < array[r].length; c++){
		ans+= array[r][c] + "\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String[]args){
	try {
	    File file = new File("makelake.in");
	    Scanner sc = new Scanner(file);
	    int R = sc.nextInt(); //row
	    int C = sc.nextInt(); //col
	    int E = sc.nextInt(); //elevation
	    int N = sc.nextInt(); //sets of commands
	    sc.nextLine();
	    int[][] pasture = new int[R][C];
	    for(int r = 0; r < pasture.length; r++){
		for(int c = 0; c < pasture[r].length; c++){
		    pasture[r][c] = sc.nextInt();
		}
	    }
	    int[][] instructions = new int[N][3];
	    for (int r = 0; r < instructions.length; r++){
		for (int c = 0; c < instructions[r].length; c++){
		    instructions[r][c] = sc.nextInt();
		}
	    }
	    sc.close();
	    for (int r = 0; r < instructions.length; r++){
		stomp(pasture, instructions[r][0], instructions[r][1], instructions[r][2]);
	    }
	    int volume = calculateLakeVolume(pasture, E);
	    System.out.println(volume + ",7,Kim,Roy");
	    //System.out.println(toString(pasture));
	    //System.out.println(toString(instructions));
	} catch (FileNotFoundException e){
		System.out.println("Didn't find makeLakes.in.");
	}	    
    }
}