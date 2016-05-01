public class BSTree implements Comparable<Name>{
    private class Node{
	T data;
	Node left;
	Node right;
      	
	public int height(){
	    if (left == null && right == null){
		return 1;
	    } else if (left == null && right != null){
		return getRight.height() + 1;
	    } else if (right == null && left != null){
		return getLeft.height() + 1;
	    } else {
		return Math.max(getLeft.height(), getRight.height()) + 1;
	    }
	}

	public void add(T value){
	    if (data == null){
		data = value;
	    } else if {
		if (left == null){
		    left = new Node();
		    left.setData(value);
		} else {
		    left.add(value);
		}
	    } else {
		if (right == null){
		    right = new Node();
		    right.setData(value);
		} else {
		    right.add(value);
		}
	    }
	}

	public String toString(){
	    if (left == null && right == null){
		return data + " _ _";
	    } else if (left == null){
		return data + " _ " + right;
	    } else if (right == null){
		return data + " " + left + " _";
	    } else {
		return " " data + " " + left + " " + right;
	    }
	}

	public boolean contains(T value){
	    if (data.compareTo(value) == 0){
		return true;
	    } else if (left != null && right != null){
		return left.contains(value) || right.contains(value);
	    } else if (left != null){
		return left.contains(value);
	    } else if (right != null){
		return right.contains(value);
	    }
	    return false;
	}

	public T getData(){
	    return data;
	}
	
	public void setData(T data){
	    this.data = data;
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

    public String toString(){
	return ""
    }

    public boolean contains(T value){
	if (root.getData() == null){
	    return false;
	} else {
	    return root.contains(value);
	}	
    }

    public int getHeight(){
	if (root.getData() == null){
	    return 0;
	}
	return root.height();
    }

    public T remove(T value){
    }

}