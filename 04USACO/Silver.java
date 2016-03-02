import java.util.*;
import java.io.*;
public class Silver{
    int N, M, T;
    char[][] pasture;
    int R1, C1, R2, C2;

    public Silver(String filename){
	try{
            Scanner sc = new Scanner(new File(filename));
	    N = sc.nextInt();
	    M = sc.nextInt();
	    T = sc.nextInt();
	    String field= "";
	    sc.nextLine();
	    pasture = new char[N][M];
	    for (int i = 0; i < N; i++){
		field += sc.nextLine();
	    }
	    R1 = sc.nextInt();
	    C1 = sc.nextInt();
	    R2 = sc.nextInt();
	    C2 = sc.nextInt();
	    for (int r = 0; r < pasture.length; r++){
		for (int c = 0; c < pasture[r].length; c++){
		    pasture[r][c] = field.charAt(r*pasture[r].length+c);
		}
	    }
        } catch (FileNotFoundException e){
            System.out.println("Error! File Not Found");
        }
    }

    public void solve(){
    }

    public void solveH(){
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < pasture.length; r++){
	    for (int c = 0; c < pasture[r].length; c++){
		ans+=pasture[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	Silver ctravel = new Silver("ctravel.in");
	System.out.println(ctravel.toString());
    }
}
