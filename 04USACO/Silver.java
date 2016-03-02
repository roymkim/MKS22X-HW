import java.util.*;
import java.io.*;
public class Silver{
    int N, M, T;
    int[][] pasture;
    int R1, C1, R2, C2;

    public Silver(String filename){
	try{
            Scanner sc = new Scanner(new File(filename));
	    N = sc.nextInt();
	    M = sc.nextInt();
	    T = sc.nextInt();
	    String field= "";
	    sc.nextLine();
	    pasture = new int[N][M];
	    for (int i = 0; i < N; i++){
		field += sc.nextLine();
	    }
	    R1 = sc.nextInt() - 1; //adjusting coordinates
	    C1 = sc.nextInt() - 1;
	    R2 = sc.nextInt() - 1;
	    C2 = sc.nextInt() - 1;
	    for (int r = 0; r < pasture.length; r++){
		for (int c = 0; c < pasture[r].length; c++){
		    if (field.charAt(r*pasture[r].length+c) == '*'){
			pasture[r][c] = -1;
		    } else {
			pasture[r][c] = 0;
		    }
		}
	    }
        } catch (FileNotFoundException e){
            System.out.println("Error! File Not Found");
        }
    }

    public int solve(){
	pasture[R1][C1] = 1;
	for (int t = 0; t < T; t++){
	    int[][] temp = new int[N][M];
	    int sum = 0;
	    for (int r = 0; r < N; r++){
		for (int c = 0; c < M; c++){
		    sum = 0;
		    if (r-1 >= 0 && pasture[r-1][c] > 0) {
			sum += pasture[r-1][c];
		    }
		    if (r+1 < pasture.length && pasture[r+1][c] > 0){
			sum += pasture[r+1][c];
		    }
		    if (c-1 >= 0 && pasture[r][c-1] > 0){
			sum += pasture[r][c-1];
		    }
		    if (c+1 < pasture[r].length && pasture[r][c+1] > 0){
			sum += pasture[r][c+1];
		    }
		    if (pasture[r][c] >= 0){
			temp[r][c] = sum;
		    } else {
			temp[r][c] = -1;
		    }
		}
	    }
       	    pasture = temp;
	}
	return pasture[R2][C2];
    }


    public String toString(){
	String ans = "";
	for (int r = 0; r < pasture.length; r++){
	    for (int c = 0; c < pasture[r].length; c++){
		ans+=pasture[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	Silver ctravel = new Silver("ctravel.in");
	System.out.println(ctravel.toString());
      	System.out.println("" + ctravel.solve() + ",7,Kim,Roy");
    }
}
