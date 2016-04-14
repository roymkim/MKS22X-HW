import java.util.*;

public class Driver{
    public static void main(String[]args){
	BetterMaze Maze = new BetterMaze("data1.data");
	Maze.clearTerminal();
	Maze.setAnimate(true);
	Maze.solveBFS();

    }
}