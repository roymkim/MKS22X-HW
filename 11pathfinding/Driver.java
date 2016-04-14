import java.util.*;

public class Driver{
    public static void main(String[]args){
	BetterMaze Maze = new BetterMaze("data1.data");
	Maze.clearTerminal();
	Maze.setAnimate(true);
	Maze.solveDFS();
	System.out.println(Maze);
	System.out.println(Arrays.toString(Maze.solutionCoordinates()));
    }
}