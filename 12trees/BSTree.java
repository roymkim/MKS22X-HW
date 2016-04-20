public class BSTree implements Comparable<Name>{
    private class Node{
	T data;
	Node left;
	Node right;
	
	public int height(){
	    return 0;
	}

	public void add(T value){
	}

	public String toString(){
	    return "";
	}

	public boolean contains(T value){
	    return false;
	}
    }

    private Node root;
    
    public BSTree(){
	root = null;
    }
    
    public int compareTo(Name n){
    }
    
    public void add(T value){
    }

    //public String toString(){
    //}

    public boolean contains(T value){
    }

    public int getHeight(){
    }
}